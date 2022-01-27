package com.project.dto.requests.superAdmin;

import javax.validation.constraints.NotNull;

public class SuperAdminDeleteFormRequest {

    @NotNull
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
