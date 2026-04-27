package com.quiz.demo.controller;

import com.quiz.demo.dto.QuizResult;
import com.quiz.demo.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/get")
    public List<QuizResult> getQuiz(@RequestParam(value = "amount", defaultValue = "5") int amount,
                                    @RequestParam(value = "category", defaultValue = "17") int category,
                                    @RequestParam(value = "difficulty", defaultValue = "easy") String difficulty,
                                    @RequestParam(value = "type", defaultValue = "multiple") String type) {
        return quizService.getQuiz(amount, category, difficulty, type);
    }

}
