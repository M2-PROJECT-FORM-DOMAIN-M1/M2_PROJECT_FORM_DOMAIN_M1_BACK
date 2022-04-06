package com.project.controller.superAdmin;

import com.project.controller.AbstractController;
import com.project.database.enums.RoleNameEnum;
import com.project.database.models.users.Users;
import com.project.database.repository.users.IUsersRepository;
import com.project.dto.requests.common.IdRequest;
import com.project.dto.responses.Response;
import com.project.dto.responses.superAdmin.SuperAdminAdminGetAdminResponse;
import com.project.dto.responses.superAdmin.SuperAdminGetAllAdminResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SuperAdminHome extends AbstractController {


    IUsersRepository usersRepository;

    public SuperAdminHome(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @PostMapping("/superAdmin/getAllAdmin")
    public ResponseEntity getAdmin(){

        List<Users> users = usersRepository.findAllByRoleName(RoleNameEnum.ROLE_ADMIN);

        return ResponseEntity.status(200).body(new SuperAdminGetAllAdminResponse(true,"",users));

    }


}
