package com.project.dto.requests.admin;

import com.project.database.models.form.Form;

import javax.validation.constraints.NotNull;

public class AdminEditAndAddFormToUsersRequest {

    @NotNull
    Form form;

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
