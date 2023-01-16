package com.example.javapro.pojo;

import jakarta.persistence.*;

@Entity
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Student student;
    private int score;


    public Leaderboard(Student student, int score) {
        this.student = student;
        this.score = score;
    }
    public Leaderboard(Student student) {
        this.student = student;
        this.score = 0;
    }
    //Default Constructor
    public Leaderboard() {

    }


    //Get and Set methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}