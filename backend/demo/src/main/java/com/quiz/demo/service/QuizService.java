package com.quiz.demo.service;

import com.quiz.demo.dto.QuizDataResult;
import com.quiz.demo.dto.QuizResponse;
import com.quiz.demo.dto.QuizApiResult;
import com.quiz.demo.entity.QuizEntity;
import com.quiz.demo.exception.QuizException;
import com.quiz.demo.feign.QuizClient;
import com.quiz.demo.mapper.QuizMapper;
import com.quiz.demo.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizService {

    private final QuizClient quizClient;
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    public List<QuizApiResult> getQuiz(int amount, int category, String difficulty, String type) {
        QuizResponse quiz = quizClient.getQuiz(amount, category, difficulty, type);
        log.info("{}", quiz);
        if (!quiz.getResponseCode().equalsIgnoreCase("0")) {
            throw new QuizException("Failed to get quiz");
        }
        return quiz.getResults();
    }

    public void saveQuizResult(QuizDataResult quizDataResult) {
        log.info("{}", quizDataResult);
        QuizEntity quizEntity = quizMapper.mapDtoToEntity(quizDataResult);
        quizRepository.save(quizEntity);
    }
}