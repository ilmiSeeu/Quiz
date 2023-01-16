package com.example.Quiz_Project.pojo;
import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //here it gets the studenID
    @ManyToOne
    private Student student;

    //here it gets the questionID
    @ManyToOne
    private Question question;
    private String studentAnswer;
    private String correct;

    public Answer() { } // default constructor

    public Answer(Student student, Question question, String studentAnswer) {
        this.student = student;
        this.question = question;
        this.studentAnswer = studentAnswer;
    }

    //This method will check if the student answer is equal to the correctAnswer, and will return a boolean
    public boolean isCorrect() {
        return studentAnswer.equalsIgnoreCase(correct);
    }

    //Get and Set Methods
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correct = correctAnswer;

    }
}