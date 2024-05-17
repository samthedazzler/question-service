package com.sam.QUESTIONSERVICE.Service;
import com.sam.QUESTIONSERVICE.Dao.QuestionDao;
import com.sam.QUESTIONSERVICE.models.Question;
import com.sam.QUESTIONSERVICE.models.QuestionWrapper;
import com.sam.QUESTIONSERVICE.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Question>> getByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Question Saved",HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Record Not Saved", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int numQ) {
        List<Integer> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
        return  new ResponseEntity<>(questions,HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionsIds) {
        List<QuestionWrapper> wrappers=new ArrayList<>();
        List<Question> questions=new ArrayList<>();
        for(Integer id:questionsIds){
            questions.add(questionDao.findById(id).get());
        }
        for(Question q:questions){
            QuestionWrapper wp=new QuestionWrapper(q.getQid(),q.getQuestion(),q.getOption_1(),q.getOption_2(),q.getOption_3(),q.getOption_4());
            wrappers.add(wp);
        }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        int right=0;
        for(Response response1:responses){
            Question question=questionDao.findById(response1.getId()).get();
            if(response1.getResponse().equals(question.getRight_answer())) {
                right++;
            }
        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}
