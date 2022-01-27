package com.project.database.models.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.database.models.answers.Answers;
import com.project.database.models.form.Form;
import com.project.database.models.questionType.QuestionType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String allPossibleAnswers;

    private String question;

    @OneToOne
    @JsonProperty(required = true)
    private QuestionType questionType;

    @ManyToOne
    private Form form;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval=true)
    @JoinColumn
    private List<Answers> answers  = new ArrayList<>();

    public Question (String allPossibleAnswers, String question, QuestionType questionType, List<Answers> answers) {
        this.allPossibleAnswers = allPossibleAnswers;
        this.question = question;
        this.questionType = questionType;
        this.answers = answers;
    }



    public Question() {

    }


    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllPossibleAnswers() {
        return allPossibleAnswers;
    }

    public void setAllPossibleAnswers(String allPossibleAnswers) {
        this.allPossibleAnswers = allPossibleAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionType getFormType() {
        return questionType;
    }

    public void setFormType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
}
