package com.hackathon.magnit.service;

import com.hackathon.magnit.dao.OptionsRepository;
import com.hackathon.magnit.dao.QuestionsOptionsRepository;
import com.hackathon.magnit.dao.QuestionsRepository;
import com.hackathon.magnit.domain.Options;
import com.hackathon.magnit.domain.Questions;
import com.hackathon.magnit.domain.Questions_Options;
import com.hackathon.magnit.response.QuestionsOptionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

/*
 *
 * Impl class that Retrieves Question and Options based on QuestionId
 *
 * */
@Service
public class QuestionOptionServiceImpl implements QuestionOptionService {

    @Autowired
    private QuestionsOptionsRepository questionsOptionsRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private OptionsRepository optionsRepository;
    /*
     *
     *  Retrieves Question and Options based on QuestionId
     *
     * */
    @Override
    public QuestionsOptionsResponse getQuestionAndOptions(Integer questionId) {

        QuestionsOptionsResponse response = null;

        List<Questions_Options> questionsOptions = questionId != null  ? questionsOptionsRepository.findQuestions_OptionsByQuestionId(questionId)
                : questionsOptionsRepository.findAll();

        if(!ObjectUtils.isEmpty(questionsOptions)){
            response =  mapQuestionOptionsToResponse(questionsOptions);
        } else {
           Optional<Questions> questions =  questionsRepository.findById(questionId);
           if(questions.isPresent()) {
               response = new QuestionsOptionsResponse();
               response.setQuestionId(questionId);
               response.setQuestion(questions.get().getQuestion());
               response.setStatus("Success");
           }
        }

        return response;

    }

    /*
     *
     * Mapper method that links Questions and option along with linked options
     *
     * */

    private QuestionsOptionsResponse mapQuestionOptionsToResponse(List<Questions_Options> questionsOptions) {

        QuestionsOptionsResponse response = new QuestionsOptionsResponse();

        if (!ObjectUtils.isEmpty(questionsOptions)) {
            int questionId = questionsOptions.get(0).getQuestionId();

            Optional<Questions> questionsOptional = questionsRepository.findById(questionId);

            if (questionsOptional.isPresent()) {
                Questions question = questionsOptional.get();
                response.setQuestionId(question.getQuestionId());
                response.setQuestion(question.getQuestion());
            }

            List<Integer> optionIds = questionsOptions.stream().map(Questions_Options::getOptionId).collect(Collectors.toList());

            List<Options> optionsList = optionsRepository.findAllById(optionIds);

            optionsList.forEach(options -> {
               Questions_Options question = questionsOptions.stream()
                       .filter(  questionOption -> options.getOptionId() == questionOption.getOptionId()).findFirst().get();
                options.setLinkedOptionId(question.getLinkedOptionId());
                options.setLinked(question.isLinked());

            });


            response.setOptions(optionsList);
            response.setStatus("Success");
        }

        return response;

    }
}
