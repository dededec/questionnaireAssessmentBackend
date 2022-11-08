package com.migueldavid.QuestionnaireAssessmentBackend.services;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.migueldavid.QuestionnaireAssessmentBackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUser(int id) {
        Optional<User> optUser = userRepository.findById(id);
        return optUser.orElse(null);
    }

}
