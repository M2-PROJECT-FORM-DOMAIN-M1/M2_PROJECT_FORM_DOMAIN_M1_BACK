package com.project.dto.responses.form;

import com.project.database.enums.QuestionTypeEnum;
import com.project.database.models.form.Form;
import com.project.database.models.question.Question;
import com.project.dto.responses.Response;

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
                        question.getFormType().getId(),
                        question.getFormType().getQuestionTypeRenderText(),
                        question.getFormType().getQuestionType()
                );

                questions.add(
                        new DataQuestion(
                                question.getId(),
                                question.getAllPossibleAnswers(),
                                question.getQuestion(),
                                dataQuestionType
                        )
                );
            }
        }
    }

    private class DataQuestion {
        private Long id;
        private String allPossibleAnswers;
        private String question;
        private DataQuestionType questionType;


        public DataQuestion(Long id,String allPossibleAnswers, String question, DataQuestionType questionType) {
            this.id=id;
            this.allPossibleAnswers = allPossibleAnswers;
            this.question = question;
            this.questionType = questionType;
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
}
