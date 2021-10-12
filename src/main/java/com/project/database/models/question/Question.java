package com.project.database.models.question;

import com.project.database.enums.FormType;
import com.project.database.models.answers.Answers;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
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

    @OneToMany
    private List<Answers> answers;
}
