package models.entities;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column
    private String email;

    @Column
    @OneToMany()
    private Answer User;
}
