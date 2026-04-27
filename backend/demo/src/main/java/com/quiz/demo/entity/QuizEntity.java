package com.quiz.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_table")
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String category;
    private String difficulty;
    private String totalQuiz;
    private String score;
    private String createdAt;
}
