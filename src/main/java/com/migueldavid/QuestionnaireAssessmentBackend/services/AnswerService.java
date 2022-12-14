package com.migueldavid.QuestionnaireAssessmentBackend.services;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Answer;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import com.migueldavid.QuestionnaireAssessmentBackend.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {


    @Autowired
    public AnswerRepository answerRepository;

    public Answer addAnswerToQuestion(Answer answer){
        return answerRepository.save(answer);
    }

    public Answer getAnswerById(int id) {
        Optional<Answer> opt = answerRepository.findById(id);
        return opt.orElse(null);
    }

    public List<Answer> getAnswersToQuestion(Question question){
    return answerRepository.findByQuestion(question);
    }

}
