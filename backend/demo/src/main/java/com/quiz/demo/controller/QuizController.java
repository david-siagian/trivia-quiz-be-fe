package com.quiz.demo.controller;

import com.quiz.demo.dto.QuizApiResult;
import com.quiz.demo.dto.QuizDataResult;
import com.quiz.demo.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/get")
    public ResponseEntity<List<QuizApiResult>> getQuiz(@RequestParam(value = "amount", defaultValue = "5") int amount,
                                                       @RequestParam(value = "category", defaultValue = "17") int category,
                                                       @RequestParam(value = "difficulty", defaultValue = "easy") String difficulty,
                                                       @RequestParam(value = "type", defaultValue = "multiple") String type) {
        return ResponseEntity.ok(quizService.getQuiz(amount, category, difficulty, type));
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveQuizResult(@RequestBody QuizDataResult quizDataResult) {
        quizService.saveQuizResult(quizDataResult);
        return ResponseEntity.ok("Sucessfully saved the result");
    }

}
