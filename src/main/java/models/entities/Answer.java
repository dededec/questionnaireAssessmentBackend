package models.entities;

import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column
    private String answerText;

    @Column
    @OneToMany()
    private User User;

    @Column
    @ManyToOne()
    private Question question;
}
