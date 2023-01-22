package com.hackathon.magnit.service;

import com.hackathon.magnit.response.QuestionsOptionsResponse;

public interface QuestionOptionService {

    /*
     *
     *  Service to Retrieve Question and Options based on QuestionId
     *
     * */
    QuestionsOptionsResponse getQuestionAndOptions (Integer questionId);
}
