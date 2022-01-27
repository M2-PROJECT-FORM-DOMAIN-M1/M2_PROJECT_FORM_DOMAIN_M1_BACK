package com.project.controller.superAdmin;

import com.project.controller.AbstractController;
import com.project.database.models.users.Users;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.dto.requests.superAdmin.SuperAdminEditAndAddFormToUsersRequest;
import com.project.dto.responses.Response;
import com.project.dto.responses.form.GetFormByIDResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.stream.IntStream;

@Controller
public class SuperAdminEditAndAddForm extends AbstractController {


    IUsersRepository usersRepository;
    IFormRepository formRepository;

    public SuperAdminEditAndAddForm(IUsersRepository usersRepository, IFormRepository formRepository) {
        this.usersRepository = usersRepository;
        this.formRepository = formRepository;
    }

    @PostMapping("/superAdmin/editAndAddFormToUsers")
    public ResponseEntity<?> editAndAddFormToUsers(@Valid @RequestBody SuperAdminEditAndAddFormToUsersRequest superAdminEditAndAddFormToUsersRequest , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }

        Users users = usersRepository.getById(superAdminEditAndAddFormToUsersRequest.getId());

        Users finalUsers = users;
        int indexOpt = IntStream.range(0, users.getForms().size())
                .filter(i -> superAdminEditAndAddFormToUsersRequest.getForm().getId().equals(finalUsers.getForms().get(i).getId()))
                .findFirst().orElseThrow();

        users.getForms().set(indexOpt,superAdminEditAndAddFormToUsersRequest.getForm());

        usersRepository.save(users);

        return ResponseEntity.status(200).body(new GetFormByIDResponse(false,"form by id",formRepository.getById(superAdminEditAndAddFormToUsersRequest.getForm().getId())));
    }

}
