package com.example.qna.service;

import com.example.qna.entity.Answer;

import java.util.List;

public interface AnswerService {
    void save(Answer answer);
    void delete(String id);
    List<Answer> findByQuestionId(String id);
    void setAnswerAccepted(String id);
    Answer findById(String id);
}
