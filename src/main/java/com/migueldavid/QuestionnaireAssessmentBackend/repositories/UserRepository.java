package com.migueldavid.QuestionnaireAssessmentBackend.repositories;

import com.migueldavid.QuestionnaireAssessmentBackend.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
