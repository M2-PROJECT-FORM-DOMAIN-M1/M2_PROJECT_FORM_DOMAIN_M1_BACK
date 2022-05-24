package com.project.controller.admin;

import com.project.controller.AbstractController;
import com.project.database.models.form.Form;
import com.project.database.models.users.Users;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.dto.requests.admin.AdminEditAndAddFormToUsersRequest;
import com.project.dto.responses.Response;
import com.project.dto.responses.form.GetFormByIDResponse;
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
import java.util.stream.IntStream;

@Controller
public class AdminEditAndAddFormController extends AbstractController {


    IUsersRepository usersRepository;
    IFormRepository formRepository;
    GenerateSaltStringService generateSaltString;

    public AdminEditAndAddFormController(IUsersRepository usersRepository, IFormRepository formRepository,GenerateSaltStringService generateSaltString) {
        this.usersRepository = usersRepository;
        this.formRepository = formRepository;
        this.generateSaltString=generateSaltString;

    }

    @PostMapping("/admin/editAndAddForm")
    public ResponseEntity<?> editAndAddFormToUsers(@Valid @RequestBody AdminEditAndAddFormToUsersRequest adminEditAndAddFormToUsersRequest , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }

        Authentication tes = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipalFront currentPrincipal = (UserPrincipalFront) tes.getPrincipal();

        Users users = usersRepository.getById(currentPrincipal.getId());

        Users finalUsers = users;
        int indexOpt = IntStream.range(0, users.getForms().size())
                .filter(i -> adminEditAndAddFormToUsersRequest.getForm().getId().equals(finalUsers.getForms().get(i).getId()))
                .findFirst().orElseThrow();

        adminEditAndAddFormToUsersRequest.getForm().setUsers(users);
        users.getForms().set(indexOpt,adminEditAndAddFormToUsersRequest.getForm());

        usersRepository.save(users);

        return ResponseEntity.status(200).body(new GetFormByIDResponse(false,"form by id",formRepository.getById(adminEditAndAddFormToUsersRequest.getForm().getId())));
    }


    @PostMapping("/admin/importSaved")
    public ResponseEntity<?> importSavedForm(@Valid @RequestBody AdminEditAndAddFormToUsersRequest adminEditAndAddFormToUsersRequest , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }

        Authentication tes = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipalFront currentPrincipal = (UserPrincipalFront) tes.getPrincipal();

        Users users = usersRepository.getById(currentPrincipal.getId());

        Form form =  adminEditAndAddFormToUsersRequest.getForm();
        form.setCode(generateSaltString.getSaltString(5));

        form.setUsers(users);

        formRepository.save(adminEditAndAddFormToUsersRequest.getForm());

        return ResponseEntity.status(200).body(new GetFormByIDResponse(false,"form by id",formRepository.getById(adminEditAndAddFormToUsersRequest.getForm().getId())));
    }
}
