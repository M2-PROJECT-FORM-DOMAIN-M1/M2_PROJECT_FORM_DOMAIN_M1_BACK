package com.project.dto.responses.superAdmin;

import com.project.database.models.users.Users;
import com.project.dto.responses.Response;

import java.util.List;

public class SuperAdminGetAllAdminResponse extends Response {

    List<Users> usersList;

    public SuperAdminGetAllAdminResponse(Boolean success, String message, List<Users> usersList) {
        super(success, message);
        this.usersList = usersList;
    }


    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }
}
