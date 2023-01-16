package com.example.Quiz_Project.repository;

import com.example.Quiz_Project.pojo.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {

    //Creating a JPA Query, where we select lb(Student parameter) from leaderboard
    @Query("SELECT lb FROM Leaderboard lb WHERE lb.student = :student")
    Leaderboard findByStudent(@Param("student") Student student);

}
