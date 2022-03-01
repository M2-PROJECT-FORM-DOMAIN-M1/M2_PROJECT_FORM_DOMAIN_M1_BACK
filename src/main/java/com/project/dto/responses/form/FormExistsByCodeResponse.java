package com.project.dto.responses.form;

import com.project.dto.responses.Response;

public class FormExistsByCodeResponse extends Response {
    Boolean exist;
    Boolean isLock;

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public FormExistsByCodeResponse(Boolean success, String message, Boolean isFormExist, Boolean isLock) {
        super(success, message);
        this.exist=isFormExist;
        this.isLock=isLock;
    }

}
