package models.entities;

import jakarta.persistence.*;

@Entity
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column
    private String questionText;

}
