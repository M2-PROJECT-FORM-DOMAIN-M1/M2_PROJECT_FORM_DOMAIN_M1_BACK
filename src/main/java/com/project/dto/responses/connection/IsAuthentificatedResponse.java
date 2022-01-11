package com.project.dto.responses.connection;

import com.project.database.models.users.Users;
import com.project.dto.responses.Response;

public class IsAuthentificatedResponse extends Response {
    public Boolean isConnected;
    private Users users;
    public IsAuthentificatedResponse(Boolean success, String message , Boolean isConnected,Users users) {
        super(success, message);
        this.isConnected = isConnected;
        this.users=users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Boolean getConnected() {
        return isConnected;
    }

    public void setConnected(Boolean connected) {
        isConnected = connected;
    }
}
