package com.hackathon.magnit.controllers;


import com.hackathon.magnit.response.QuestionsOptionsResponse;
import com.hackathon.magnit.service.QuestionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class QuestionsOptionsController {

    @Autowired
    QuestionOptionService questionOptionService;

    /*
    *
    *  Retrieves Question and Options based on QuestionId
    *
    * */
    @GetMapping(value = "/questions/{questionId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Object> getQuestionAndOptionsForId(@PathVariable Integer questionId) {

        if (questionId > 0) {
            QuestionsOptionsResponse response = questionOptionService.getQuestionAndOptions(questionId);
            if (!Objects.isNull(response)) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("No QuestionId present", HttpStatus.BAD_REQUEST);
    }

}
