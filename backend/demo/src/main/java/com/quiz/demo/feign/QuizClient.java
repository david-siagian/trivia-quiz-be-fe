package com.quiz.demo.feign;

import com.quiz.demo.dto.QuizResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "quiz",
        url = "https://opentdb.com/api.php"
)
public interface QuizClient {

    @GetMapping
    QuizResponse getQuiz(@RequestParam(value = "amount") int amount,
                         @RequestParam(value = "category") int category,
                         @RequestParam(value = "difficulty") String difficulty,
                         @RequestParam(value = "type") String type);

}
