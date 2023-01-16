package com.example.Quiz_Project.service;

import com.example.Quiz_Project.pojo.*;
import com.example.Quiz_Project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    //reason for not many methods is that we dont have a service controller
    //the controll happens in the stundentController, this is supposed to be a log, no reason for editing

    @Autowired
    private AnswerRepository answerRepository;

    //Here we store an answer to the database,
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer getAnswerById(long id){
        return answerRepository.findById(id).get();
    }



}