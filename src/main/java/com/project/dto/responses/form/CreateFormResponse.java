package com.project.dto.responses.form;

import com.project.database.models.form.Form;
import com.project.dto.responses.Response;

public class CreateFormResponse extends Response {

    Form form;

    public CreateFormResponse(Boolean success, String message, Form form) {
        super(success, message);
        this.form = form;
    }

    public Form getForm() {
        return form;
    }
}
