package com.migueldavid.QuestionnaireAssessmentBackend.models.dto;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Answer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private Integer id;

    private String email;

    private List<Answer> answers;

}
