package com.quiz.demo.mapper;

import com.quiz.demo.dto.QuizDataResult;
import com.quiz.demo.entity.QuizEntity;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {

    public QuizEntity mapDtoToEntity(QuizDataResult dto) {
        QuizEntity entity = new QuizEntity();
        entity.setName(dto.getName());
        entity.setCategory(dto.getCategory());
        entity.setDifficulty(dto.getDifficulty());
        entity.setTotalQuiz(dto.getTotalQuiz());
        entity.setScore(dto.getScore());
        return entity;
    }
}
