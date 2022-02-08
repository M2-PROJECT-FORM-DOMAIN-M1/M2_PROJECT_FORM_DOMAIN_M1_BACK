package com.project.dto.responses.superAdmin;

import com.project.database.models.form.Form;
import com.project.database.models.users.Users;
import com.project.dto.responses.Response;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SuperAdminAdminGetAdminResponse extends Response {

    private Users user;


    public SuperAdminAdminGetAdminResponse(Boolean success, String message, Users user) {
        super(success, message);
        user.setPassword("");

        for(Form form : user.getForms()){
            form.setQuestions(null);
        }

        this.user = user;

    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
