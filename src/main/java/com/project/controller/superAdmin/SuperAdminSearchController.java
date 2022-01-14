package com.project.controller.superAdmin;

import com.project.controller.AbstractController;
import com.project.database.enums.RoleNameEnum;
import com.project.database.models.users.Users;
import com.project.database.repository.users.IUsersRepository;
import com.project.dto.requests.superAdmin.SuperAdminSearchAutoCompleteAdminRequest;
import com.project.dto.responses.Response;
import com.project.dto.responses.superAdmin.SuperAdminSearchAutoCompleteAdminResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SuperAdminSearchController extends AbstractController {


    @Autowired
    IUsersRepository iUsersRepository;


    @PostMapping("/superAdminSearch/autoCompleteUsers")
    public ResponseEntity getAutoCompleteAdmin(@Valid @RequestBody SuperAdminSearchAutoCompleteAdminRequest superAdminSearchAutoCompleteAdminRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }
        String input = superAdminSearchAutoCompleteAdminRequest.getInput();
        List<Users> usersList = iUsersRepository.findTop5ByRoleIsAndEmailContainsOrNameContainsOrUsernameContains(RoleNameEnum.ROLE_ADMIN,input,input,input).orElseThrow();
        return ResponseEntity.status(200).body(new SuperAdminSearchAutoCompleteAdminResponse(true,"Filtered Users",usersList));
    }
}
