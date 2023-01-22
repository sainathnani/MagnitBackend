package com.hackathon.magnit.domain;

import javax.persistence.*;
import lombok.Getter;

/*
 *
 *  Questions Options class
 *
 * */
@Entity
@Getter
public class Questions_Options {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Questions_Options_Id")
    private int id;

    @Column(name = "Question_Id")
    private int questionId;
    @Column(name = "Options_Id")
    private int optionId;
    @Column(name = "Description")
    private String description;

    @Column(name = "Is_Linked")
    private boolean isLinked;

    @Column(name = "Linked_Option_Id")
    private Integer linkedOptionId;

}
