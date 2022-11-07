package com.migueldavid.QuestionnaireAssessmentBackend.services;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import com.migueldavid.QuestionnaireAssessmentBackend.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {


    @Autowired
    public AnswerRepository answerRepository;

    public Answer addAnswerToQuestion(Answer answer){
        return answerRepository.save(answer);
    }

}
