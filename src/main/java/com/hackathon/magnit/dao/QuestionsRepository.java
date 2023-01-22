package com.hackathon.magnit.dao;

import com.hackathon.magnit.domain.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
 *
 *  Repo for Retrieving Questions
 *
 * */
@Repository
public interface QuestionsRepository  extends JpaRepository<Questions, Integer> {
}