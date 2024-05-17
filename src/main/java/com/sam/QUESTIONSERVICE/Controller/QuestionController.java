package com.sam.QUESTIONSERVICE.Controller;
import com.sam.QUESTIONSERVICE.Service.QuestionService;
import com.sam.QUESTIONSERVICE.models.Question;
import com.sam.QUESTIONSERVICE.models.QuestionWrapper;
import com.sam.QUESTIONSERVICE.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String category){
        return questionService.getByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PostMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numQ){
        return questionService.getQuestionsForQuiz(category,numQ);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionsIds){
        return questionService.getQuestionsFromId(questionsIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore( @RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

//    generate quiz
//    get/Questions(qid)
//    getScore
}
