package com.project.database.models.form;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.database.models.question.Question;
import com.project.database.models.users.Users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, length = 5)
    private String code;

    @Column(name = "isLock", nullable = false)
    private Boolean isLock = true;

    @OneToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL },mappedBy = "form",orphanRemoval = true)
    @JsonManagedReference
    private List<Question> questions = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    @JsonBackReference
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Form(String name,String code ,List<Question> questions) {
        this.name = name;
        this.questions = questions;
        this.code = code;
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

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
