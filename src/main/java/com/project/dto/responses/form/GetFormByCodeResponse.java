package com.project.dto.responses.form;

import com.project.database.models.form.Form;
import com.project.dto.responses.Response;

import java.util.stream.Collectors;


public class GetFormByCodeResponse extends Response {

   Form form;

    public GetFormByCodeResponse(Boolean success, String message, Form form) {
        super(success, message);
        this.form = form;
        form.setQuestions(  form.getQuestions().stream().peek(question -> question.setAnswers(null)).collect(Collectors.toList()));

    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
