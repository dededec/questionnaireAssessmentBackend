package com.migueldavid.QuestionnaireAssessmentBackend.controllers;

import com.migueldavid.QuestionnaireAssessmentBackend.models.dto.QuestionDTO;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Answer;
import com.migueldavid.QuestionnaireAssessmentBackend.services.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import com.migueldavid.QuestionnaireAssessmentBackend.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class QuestionController {

    @Autowired
    private QuestionService service;
    @Autowired
    private AnswerService answerService;

    @PostMapping(path = "/question/add")
    private ResponseEntity<Question> createQuestion(@RequestBody Question question){
        Question saved = service.addQuestion(question);
        if(saved == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/question/delete/all")
    private ResponseEntity DeleteAllQuestions(){
        service.deleteAllQuestions();
        return new ResponseEntity( HttpStatus.OK);
    }

    @GetMapping(path = "/question/delete/{id}")
    private ResponseEntity DeleteQuestionById(@PathVariable Integer id){

        Question question = service.getQuestion(id);

        if(question == null){
            return new ResponseEntity( HttpStatus.BAD_REQUEST);
        }

        service.deleteQuestion(question);

        return new ResponseEntity( HttpStatus.OK);
    }

    @GetMapping(path = "/question/get/all")
    private ResponseEntity<List<QuestionDTO>> getAllQuestion(){

        List<Question> questions = service.getQuestions();
        List<QuestionDTO> questionsAnswers = new ArrayList<>();

        for (Question question: questions) {
            List<Answer> answers = answerService.getAnswersToQuestion(question);
            QuestionDTO questionDTO = new QuestionDTO(question.getId(), question.getQuestionText(), answers);
            questionsAnswers.add(questionDTO);
        }
        return new ResponseEntity<>(questionsAnswers, HttpStatus.OK);
    }
}
