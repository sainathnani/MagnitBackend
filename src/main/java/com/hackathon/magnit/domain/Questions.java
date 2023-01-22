package com.hackathon.magnit.domain;


import javax.persistence.*;
import lombok.Getter;
/*
 *
 *  Questions class
 *
 * */
@Entity
@Table(name = "Questions")
@Getter
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "questionId")
    private int questionId;
    @Column(name = "question")

    private String question;
}
