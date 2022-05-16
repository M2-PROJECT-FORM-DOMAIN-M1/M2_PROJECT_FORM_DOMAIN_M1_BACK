package com.project.controller.superAdmin;

import com.project.controller.AbstractController;
import com.project.database.models.form.Form;
import com.project.database.models.users.Users;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.dto.requests.form.CreateFormRequest;
import com.project.dto.responses.Response;
import com.project.dto.responses.form.CreateFormResponse;
import com.project.models.UserPrincipalFront;
import com.project.service.GenerateSaltStringService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class SuperAdminCreateForm extends AbstractController {

    GenerateSaltStringService generateSaltString;

    IFormRepository formRepository;

    IUsersRepository usersRepository;


    public SuperAdminCreateForm(GenerateSaltStringService generateSaltString, IFormRepository formRepository, IUsersRepository usersRepository) {
        this.generateSaltString = generateSaltString;
        this.formRepository = formRepository;
        this.usersRepository = usersRepository;
    }

    @PostMapping("/createForm")
    public ResponseEntity adminLock(@Valid @RequestBody CreateFormRequest createFormRequest, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }

        Form form = new Form();
        form.setLock(true);
        form.setName(createFormRequest.getName());
        form.setCode(generateSaltString.getSaltString(5));

        Authentication tes = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipalFront currentPrincipal = (UserPrincipalFront) tes.getPrincipal();

        Users users = usersRepository.getById(currentPrincipal.getId());

        form.setUsers(users);

        Form savedForm =  formRepository.save(form);
        return ResponseEntity.status(200).body(new CreateFormResponse(true,"",savedForm));
    }
}
