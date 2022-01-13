package com.project.database.models.question;

import com.project.database.enums.FormType;
import com.project.database.models.answers.Answers;
import com.project.database.models.form.Form;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Question", indexes = {
        @Index(name = "idx_question_form_id", columnList = "form_id")
})
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String allPossibleAnswers;

    private String question;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Size(max = 40)
    private FormType formType;

    @ManyToOne
    @JoinColumn
    private Form form;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn
    private List<Answers> answers  = new ArrayList<>();

    public Question (String allPossibleAnswers, String question, FormType formType, List<Answers> answers) {
        this.allPossibleAnswers = allPossibleAnswers;
        this.question = question;
        this.formType = formType;
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

    public FormType getFormType() {
        return formType;
    }

    public void setFormType(FormType formType) {
        this.formType = formType;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
}
