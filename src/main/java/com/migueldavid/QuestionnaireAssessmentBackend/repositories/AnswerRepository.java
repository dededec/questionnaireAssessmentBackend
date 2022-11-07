package com.migueldavid.QuestionnaireAssessmentBackend.repositories;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
