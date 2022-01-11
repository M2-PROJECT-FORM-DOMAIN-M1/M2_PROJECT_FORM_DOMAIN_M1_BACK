package com.project.dto.responses.superAdmin;

import com.project.database.models.users.Users;
import com.project.dto.responses.Response;

import java.util.ArrayList;
import java.util.List;

public class SuperAdminSearchAutoCompleteAdminResponse extends Response {


    private List<Data> usersList = new ArrayList<>();

    public SuperAdminSearchAutoCompleteAdminResponse(Boolean success, String message, List<Users> usersList) {
        super(success, message);
        for(Users users : usersList){
            this.usersList.add(new Data(users.getId(),users.getUsername()));
        }

    }

    public List<Data> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Data> usersList) {
        this.usersList = usersList;
    }

    private class Data {
        private Long id;
        private String userName;

        public Data(Long id, String userName) {
            this.id = id;
            this.userName = userName;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

}
