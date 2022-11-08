package com.migueldavid.QuestionnaireAssessmentBackend.models.dto;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Answer;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDTO {

    private Integer id;

    private String questionText;

    private List<Answer> answers;

}
