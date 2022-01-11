package com.project.dto.requests.superAdmin;

import javax.validation.constraints.NotNull;

public class SuperAdminSearchAutoCompleteAdminRequest {


    @NotNull
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
