package com.project.dto.responses.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.database.enums.QuestionTypeEnum;
import com.project.database.enums.RulesTypeEnum;
import com.project.database.models.form.Form;
import com.project.database.models.question.Question;
import com.project.database.models.rulesType.RulesType;
import com.project.dto.responses.Response;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class GetFormByIDResponse extends Response {


    Data data;


    public GetFormByIDResponse(Boolean success, String message, Form form) {
        super(success, message);

        this.data = new Data(
                form.getName(),
                form.getCode(),
                form.getLock(),
                form,
                form.getId()

        );

    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private class Data{
        private Long id;
        private String name;
        private String code;
        private Boolean isLock;
        private List<DataQuestion> questions = new ArrayList<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Boolean getLock() {
            return isLock;
        }

        public void setLock(Boolean lock) {
            isLock = lock;
        }

        public List<DataQuestion> getQuestions() {
            return questions;
        }

        public void setQuestions(List<DataQuestion> questions) {
            this.questions = questions;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Data(String name, String code, Boolean isLockForm , Form form, Long id) {
            this.name = name;
            this.code = code;
            this.isLock = isLockForm;
            this.id = id;

            for(Question question : form.getQuestions()){



                DataQuestionType dataQuestionType = new DataQuestionType(
                        question.getQuestionType().getId(),
                        question.getQuestionType().getQuestionTypeRenderText(),
                        question.getQuestionType().getQuestionType()
                );

                DataRules dataRules= null;

                if(question.getRules() != null){
                    DataRulesType dataRulesType = new DataRulesType(
                            question.getRules().getRulesType().getId(),
                            question.getRules().getRulesType().getRulesTypeEnum(),
                            question.getRules().getRulesType().getRulesTypeRenderText()
                    );

                    dataRules = new DataRules(
                            question.getRules().getId(),
                            question.getRules().getAbstractID(),
                            dataRulesType,
                            question.getRules().getSpecifiedValue()
                    );
                }



                questions.add(
                        new DataQuestion(
                                question.getId(),
                                question.getAllPossibleAnswers(),
                                question.getQuestion(),
                                question.getEcts(),
                                question.getAbstractID(),
                                dataQuestionType,
                                dataRules,
                                question.getRequired()

                        )
                );
            }
        }
    }

    private class DataQuestion {
        private Long id;
        private String allPossibleAnswers;
        private String question;
        private Long ects;
        private Boolean required;
        private Long abstractID;
        private DataRules rules;
        private DataQuestionType questionType;



        public DataQuestion(Long id, String allPossibleAnswers, String question, Long ects, Long abstractID, DataQuestionType questionType,DataRules rules,Boolean required) {
            this.id = id;
            this.allPossibleAnswers = allPossibleAnswers;
            this.question = question;
            this.ects = ects;
            this.abstractID = abstractID;
            this.questionType = questionType;
            this.rules = rules;
            this.required = required;
        }

        public Boolean getRequired() {
            return required;
        }

        public void setRequired(Boolean required) {
            this.required = required;
        }

        public DataRules getRules() {
            return rules;
        }

        public void setRules(DataRules rules) {
            this.rules = rules;
        }

        public Long getAbstractID() {
            return abstractID;
        }

        public void setAbstractID(Long abstractID) {
            this.abstractID = abstractID;
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

        public DataQuestionType getQuestionType() {
            return questionType;
        }

        public void setQuestionType(DataQuestionType questionType) {
            this.questionType = questionType;
        }

        public Long getEcts() {
            return ects;
        }

        public void setEcts(Long ects) {
            this.ects = ects;
        }
    }

    private class DataQuestionType{
        private Long id;
        private String questionTypeRenderText;
        private QuestionTypeEnum questionType;

        public DataQuestionType(Long id,String questionTypeRenderText, QuestionTypeEnum questionType) {
            this.id=id;
            this.questionTypeRenderText = questionTypeRenderText;
            this.questionType = questionType;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getQuestionTypeRenderText() {
            return questionTypeRenderText;
        }

        public void setQuestionTypeRenderText(String questionTypeRenderText) {
            this.questionTypeRenderText = questionTypeRenderText;
        }

        public QuestionTypeEnum getQuestionType() {
            return questionType;
        }

        public void setQuestionType(QuestionTypeEnum questionType) {
            this.questionType = questionType;
        }
    }

    private class DataRules{

        private Long id;
        private Long abstractID;
        private DataRulesType rulesType;
        private String specifiedValue;


        public DataRules(Long id, Long abstractID, DataRulesType datarulesType,String specifiedValue) {
            this.id = id;
            this.abstractID = abstractID;
            this.rulesType = datarulesType;
            this.specifiedValue=specifiedValue;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getAbstractID() {
            return abstractID;
        }

        public void setAbstractID(Long abstractID) {
            this.abstractID = abstractID;
        }

        public DataRulesType getRulesType() {
            return rulesType;
        }

        public void setRulesType(DataRulesType rulesType) {
            this.rulesType = rulesType;
        }

        public String getSpecifiedValue() {
            return specifiedValue;
        }

        public void setSpecifiedValue(String specifiedValue) {
            this.specifiedValue = specifiedValue;
        }
    }

    private class DataRulesType{

        private Long id;
        private RulesTypeEnum rulesTypeEnum;
        private String rulesTypeRenderText;

        public DataRulesType(Long id, RulesTypeEnum rulesTypeEnum, String rulesTypeRenderText) {
            this.id = id;
            this.rulesTypeEnum = rulesTypeEnum;
            this.rulesTypeRenderText = rulesTypeRenderText;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public RulesTypeEnum getRulesTypeEnum() {
            return rulesTypeEnum;
        }

        public void setRulesTypeEnum(RulesTypeEnum rulesTypeEnum) {
            this.rulesTypeEnum = rulesTypeEnum;
        }

        public String getRulesTypeRenderText() {
            return rulesTypeRenderText;
        }

        public void setRulesTypeRenderText(String rulesTypeRenderText) {
            this.rulesTypeRenderText = rulesTypeRenderText;
        }
    }
}
