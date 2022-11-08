package com.migueldavid.QuestionnaireAssessmentBackend.controllers;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.User;
import com.migueldavid.QuestionnaireAssessmentBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(path = "/add")
    private ResponseEntity<User> createUser(@RequestBody User user){
        User saved = service.addUser(user);
        if(saved == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/user/get/{id}")
    private ResponseEntity<User> getUser(@PathVariable int id){
        User user = service.getUser(id);
        if(user != null){
            return new ResponseEntity<>(null, HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }
}
