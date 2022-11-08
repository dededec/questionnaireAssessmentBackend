package com.migueldavid.QuestionnaireAssessmentBackend.controllers;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import com.migueldavid.QuestionnaireAssessmentBackend.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService service;

    @PostMapping(path = "/add")
    private ResponseEntity<Question> createQuestion(@RequestBody Question question){
        return null;
    }

    @GetMapping(path = "/get/{id}")
    private ResponseEntity<Question> getQuestion(@PathVariable int id){
        return null;
    }

    @GetMapping(path = "/get/all")
    private ResponseEntity<Question> getAllQuestion(){
        return null;
    }
}
