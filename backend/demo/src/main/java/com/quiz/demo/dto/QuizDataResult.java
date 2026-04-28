package com.quiz.demo.dto;

import lombok.Data;

@Data
public class QuizDataResult {
    private String name;
    private String category;
    private String difficulty;
    private String totalQuiz;
    private String score;
}
