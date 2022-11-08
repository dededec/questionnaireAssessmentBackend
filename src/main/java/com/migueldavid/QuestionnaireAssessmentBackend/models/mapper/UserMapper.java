package com.migueldavid.QuestionnaireAssessmentBackend.models.mapper;

import com.migueldavid.QuestionnaireAssessmentBackend.models.dto.UserDTO;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.User;
import com.migueldavid.QuestionnaireAssessmentBackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;

public abstract class UserMapper {

    @Autowired
    protected UserRepository userRepository;

    public abstract User fromUserDTOtoUser(UserDTO userDTO);
}
