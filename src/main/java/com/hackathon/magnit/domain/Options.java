package com.hackathon.magnit.domain;

import lombok.Getter;

import javax.persistence.*;

/*
 *
 *  Options class
 *
 * */
@Entity
@Getter
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Option_Id")
    private int optionId;

    @Column(name = "Option")
    private String option;

    @Column(name = "Score")
    private int score;

    @Transient
    private boolean isLinked;
    @Transient
    private Integer linkedOptionId;

    public void setLinked(boolean linked) {
        isLinked = linked;
    }

    public void setLinkedOptionId(Integer linkedOptionId) {
        this.linkedOptionId = linkedOptionId;
    }
}
