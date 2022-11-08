package com.migueldavid.QuestionnaireAssessmentBackend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "user_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String email;

    @OneToMany()
    private List<Answer> answers;


    public User(String s, List<Answer> answerList) {
        this.email = s;
        this.answers = answerList;
    }
}
