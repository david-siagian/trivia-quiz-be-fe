package com.quiz.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResult {
    private String category;
    @JsonProperty("correct_answer")
    private String correctAnswer;
    private String difficulty;
    private String question;
    @JsonProperty("incorrect_answers")
    private List<String> incorrectAnswers;
    private String type;
}
