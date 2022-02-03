package com.project.dto.responses.form;

import com.project.dto.responses.Response;

public class FormExistsByCodeResponse extends Response {
    Boolean exist;

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    public FormExistsByCodeResponse(Boolean success, String message, Boolean isFormExist) {
        super(success, message);
        this.exist=isFormExist;
    }
}
