package com.migueldavid.QuestionnaireAssessmentBackend.services;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import com.migueldavid.QuestionnaireAssessmentBackend.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    public QuestionRepository questionRepository;

    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }


    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }
    public Question getQuestion(Integer id){

        Optional<Question> question = questionRepository.findById(id);

        if(question.isEmpty()){
            return new Question();
        }

        return question.get();

    }
    public void deleteAllQuestions(){
        questionRepository.deleteAll();
    }
    public void deleteQuestion(Question question){
        questionRepository.delete(question);
    }








}
