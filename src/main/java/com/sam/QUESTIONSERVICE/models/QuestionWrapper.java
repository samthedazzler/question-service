package com.sam.QUESTIONSERVICE.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuestionWrapper {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int qid;
    private String question;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
}
