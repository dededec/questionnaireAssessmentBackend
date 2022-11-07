package com.migueldavid.QuestionnaireAssessmentBackend.services;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import com.migueldavid.QuestionnaireAssessmentBackend.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    public QuestionRepository questionRepository;

    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }







}
