package com.hackathon.magnit.response;

import com.hackathon.magnit.domain.Options;
import lombok.Data;

import java.util.List;

/*
 *
 *  Response class that sends mapped Questions and Options class
 *
 * */
@Data
public class QuestionsOptionsResponse {

    private int questionId;
    private String question;
    private List<Options> options;
    private String status;

}
