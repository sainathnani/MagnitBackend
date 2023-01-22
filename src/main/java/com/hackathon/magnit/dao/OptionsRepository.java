package com.hackathon.magnit.dao;

import com.hackathon.magnit.domain.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *
 *  Repo for Retrieving Options
 *
 * */
@Repository
public interface OptionsRepository extends JpaRepository<Options, Integer> {
}