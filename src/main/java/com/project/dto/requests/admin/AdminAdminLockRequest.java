package com.project.dto.requests.admin;

public class AdminAdminLockRequest {
    private long id;
    private Boolean lock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }
}
