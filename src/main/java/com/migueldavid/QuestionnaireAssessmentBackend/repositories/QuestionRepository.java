package com.migueldavid.QuestionnaireAssessmentBackend.repositories;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
