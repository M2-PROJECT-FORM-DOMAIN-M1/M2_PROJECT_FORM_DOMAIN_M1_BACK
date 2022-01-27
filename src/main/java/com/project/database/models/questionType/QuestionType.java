package com.project.database.models.questionType;

import com.project.database.enums.QuestionTypeEnum;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private QuestionTypeEnum questionType;

    private String questionTypeRenderText;

    public QuestionType() {
    }

    public QuestionType(QuestionTypeEnum questionType, String questionTypeRenderText) {
        this.questionType = questionType;
        this.questionTypeRenderText = questionTypeRenderText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionTypeEnum getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionTypeEnum formType) {
        this.questionType = formType;
    }

    public String getQuestionTypeRenderText() {
        return questionTypeRenderText;
    }

    public void setQuestionTypeRenderText(String formTypeRenderText) {
        this.questionTypeRenderText = formTypeRenderText;
    }
}
