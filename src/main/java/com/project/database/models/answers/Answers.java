package com.project.database.models.answers;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.database.models.question.Question;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    private String mail;

    @NotBlank
    @Size(max = 80)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private Question question;

    public Answers(String mail, String answer, Question question) {
        this.mail = mail;
        this.answer = answer;
        this.question = question;
    }

    public Answers(Long id, String mail, String answer) {
        this.id = id;
        this.mail = mail;
        this.answer = answer;
    }

    public Answers() {

    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
