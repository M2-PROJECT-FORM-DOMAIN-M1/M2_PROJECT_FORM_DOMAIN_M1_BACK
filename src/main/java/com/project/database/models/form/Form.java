package com.project.database.models.form;

import com.project.database.models.question.Question;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade= {CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Question> questions;

    @Column(name = "isLock", nullable = false)
    private Boolean isLock = false;

    public Form(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }


    public Form() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }
}
