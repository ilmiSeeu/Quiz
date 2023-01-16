package com.example.javapro.controller;

import com.example.javapro.pojo.*;
import com.example.javapro.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;
    @Autowired
    private StudentService studentService;

    //Requesting a Get for a student by studentid
    @GetMapping("/{studentId}")
    public Leaderboard findByStudent(@PathVariable long studentId) {
        Student student = studentService.getStudentById(studentId);
        return leaderboardService.findByStudent(student);
    }

    //Requesting a Get for all data in leaderboard
    @GetMapping
    public List<Leaderboard> findAll() {
        return leaderboardService.getAllLeaderboards();
    }

    //Requesting a Get for all data in leaderboard sorted
    @GetMapping("/rank")
    public List<Leaderboard> getRank() {
        List<Leaderboard> leaderboardList = leaderboardService.getAllLeaderboards();
        //The lambda expression takes two parameters, a and b, which represent two objects in the list. The expression b.getScore() - a.getScore() compares the scores of the two objects. If the result is a negative number, it means that a has a higher score than b so a comes before b in the sorted list.
        leaderboardList.sort((a, b) -> b.getScore() - a.getScore());
        return leaderboardList;
    }


    //Requesting a Get for the rank of a student by studentid
    @GetMapping("/rank/{studentId}")
    public int getRank(@PathVariable long studentId) {
        Student student = studentService.getStudentById(studentId);
        return leaderboardService.getRank(student);
    }
}