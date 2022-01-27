package com.project.dto.requests.superAdmin;

import com.project.database.models.form.Form;

import javax.validation.constraints.NotNull;

public class SuperAdminEditAndAddFormToUsersRequest {
    Long id;

    @NotNull
    Form form;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
