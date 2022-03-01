package com.project.dto.responses.form;

import com.project.database.models.form.Form;
import com.project.dto.responses.Response;

public class GetFormByIdFullResponse extends Response {
    Form form;


    public GetFormByIdFullResponse(Boolean success, String message, Form form) {
        super(success, message);
        this.form=form;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
