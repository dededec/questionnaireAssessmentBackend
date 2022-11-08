package com.migueldavid.QuestionnaireAssessmentBackend.repositories;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Answer;
import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {


    public List<Answer> findByQuestion(Question question);
}
