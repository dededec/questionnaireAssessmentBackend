package com.migueldavid.QuestionnaireAssessmentBackend.controllers;

import com.migueldavid.QuestionnaireAssessmentBackend.models.dto.AnswerDTO;
import com.migueldavid.QuestionnaireAssessmentBackend.models.dto.UserDTO;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Answer;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.User;
import com.migueldavid.QuestionnaireAssessmentBackend.services.AnswerService;
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

    @Autowired
    private AnswerService answerService;

    @PostMapping(path = "/user/add")
    private ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());
        Answer aux;
        for (AnswerDTO dto: userDTO.getAnswers()) {
            aux = answerService.getAnswerById(dto.getId());
            if(aux == null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            user.getAnswers().add(aux);
        }

        User saved = service.addUser(user);
        if(saved == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping(path = "/user/get/{email}")
    private ResponseEntity<UserDTO> getUser(@PathVariable String email){
        Optional<User> user = service.getUser(email);

        if(!user.isEmpty()){
            return new ResponseEntity<>(new UserDTO(user.get().getId(), user.get().getEmail(), user.get().getAnswers().stream().map(ans -> new AnswerDTO(ans.getId())).toList()),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
