package com.migueldavid.QuestionnaireAssessmentBackend.controllers;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import com.migueldavid.QuestionnaireAssessmentBackend.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService service;

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

//    @GetMapping(path = "/question/get/{id}")
//    private ResponseEntity<Question> getQuestion(@PathVariable int id){
//        return new ResponseEntity<>(service., HttpStatus.BAD_REQUEST);
//    }

    @GetMapping(path = "/question/get/all")
    private ResponseEntity<List<Question>> getAllQuestion(){
        return new ResponseEntity<>(service.getQuestions(), HttpStatus.OK);
    }
}
