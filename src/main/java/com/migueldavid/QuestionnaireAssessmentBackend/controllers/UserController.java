package com.migueldavid.QuestionnaireAssessmentBackend.controllers;

import com.migueldavid.QuestionnaireAssessmentBackend.models.dto.UserDTO;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.User;
import com.migueldavid.QuestionnaireAssessmentBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(path = "/user/get/{email}")
    private ResponseEntity<UserDTO> getUser(@PathVariable String email){
        Optional<User> user = service.getUser(email);

        if(!user.isEmpty()){
            return new ResponseEntity<>(new UserDTO(user.get().getId(), user.get().getEmail(), user.get().getAnswers()),HttpStatus.FOUND);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
