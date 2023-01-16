package com.example.javapro.service;

import com.example.javapro.pojo.*;
import com.example.javapro.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    //Get all values in leaderboard
    public List<Leaderboard> getAllLeaderboards(){
        return leaderboardRepository.findAll();
    }

    public Leaderboard getLeaderboardById(long id){
        return leaderboardRepository.findById(id).get();
    }

    public Leaderboard saveLeaderboard(Leaderboard leaderboard){
        return leaderboardRepository.save(leaderboard);
    }

    public void deleteLeaderboard(long id){
        leaderboardRepository.deleteById(id);
    }

    //Find Student in leaderboard
    public Leaderboard findByStudent(Student student) {
        return leaderboardRepository.findByStudent(student);
    }

    //Get rank of the student in the leaderboard
    public int getRank(Student student) {
        //find first all leaderboard values
        List<Leaderboard> leaderboardList = leaderboardRepository.findAll();
        //The lambda expression takes two parameters, a and b, which represent two objects in the list. The expression b.getScore() - a.getScore() compares the scores of the two objects. If the result is a negative number, it means that a has a higher score than b so a comes before b in the sorted list.
        leaderboardList.sort((a, b) -> b.getScore() - a.getScore());
        //find the index of where the student is after sorting
        return leaderboardList.indexOf(findByStudent(student)) + 1;
    }

    //Update the leaderboard
    public void updatePoints(Student student, boolean isCorrect) {
        //Check if student is in leaderboard
        Leaderboard leaderboard = leaderboardRepository.findByStudent(student);
        //if no, add it to the leaderboard
        if (leaderboard == null) {
            leaderboard = new Leaderboard(student);
        }
        //if yes and its correct increment the score
        if (isCorrect) {
            leaderboard.setScore(leaderboard.getScore() + 1);
        }
        //Save to the leaderboard
        leaderboardRepository.save(leaderboard);
    }
}