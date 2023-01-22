package com.hackathon.magnit.dao;

import com.hackathon.magnit.domain.Questions_Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
 *
 *  Repo for Retrieving Questions Options Mapping
 *
 * */
@Repository
public interface QuestionsOptionsRepository  extends JpaRepository<Questions_Options, Integer> {

    List<Questions_Options> findQuestions_OptionsByQuestionId(Integer id);

}
