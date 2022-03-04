package com.project.dto.requests.admin;
import javax.validation.constraints.NotNull;

public class AdminDeleteFormRequest {
    @NotNull
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
