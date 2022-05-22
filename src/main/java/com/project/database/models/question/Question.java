package com.project.database.models.question;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.database.models.answers.Answers;
import com.project.database.models.form.Form;
import com.project.database.models.questionType.QuestionType;
import com.project.database.models.rules.Rules;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String allPossibleAnswers;

    private String question;

    private Long ects = 0L;

    private Long abstractID;

    @OneToOne
    @JsonProperty(required = true)
    private Rules rules;

    @OneToOne
    @JsonProperty(required = true)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "form_id")
    @JsonBackReference
    private Form form;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "question")
    @JsonManagedReference
    private List<Answers> answers = new ArrayList<>();


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }


    public Question(String allPossibleAnswers, String question, QuestionType questionType, List<Answers> answers, Long ects,Long abstractID) {
        this.allPossibleAnswers = allPossibleAnswers;
        this.question = question;
        this.questionType = questionType;
        this.answers = answers;
        this.ects = ects;
        this.abstractID=abstractID;
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

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    public Long getEcts() {
        return ects;
    }

    public void setEcts(Long ects) {
        this.ects = ects;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Long getAbstractID() {
        return abstractID;
    }

    public void setAbstractID(Long abstractID) {
        this.abstractID = abstractID;
    }
}
