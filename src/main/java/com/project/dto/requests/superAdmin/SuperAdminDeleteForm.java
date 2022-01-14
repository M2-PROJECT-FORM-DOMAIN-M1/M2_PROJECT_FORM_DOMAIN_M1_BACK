package com.project.dto.requests.superAdmin;

import javax.validation.constraints.NotNull;

public class SuperAdminDeleteForm {

    @NotNull
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
