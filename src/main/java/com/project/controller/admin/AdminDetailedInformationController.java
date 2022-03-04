package com.project.controller.admin;

import com.project.controller.AbstractController;
import com.project.database.models.form.Form;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.dto.requests.admin.AdminDeleteFormRequest;
import com.project.dto.requests.admin.AdminLockRequest;
import com.project.dto.responses.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class AdminDetailedInformationController extends AbstractController {


    IFormRepository formRepository;

    public AdminDetailedInformationController(IFormRepository formRepository, IUsersRepository usersRepository) {
        this.formRepository = formRepository;
        this.usersRepository = usersRepository;
    }

    IUsersRepository usersRepository;

    @PostMapping("/admin/lock")
    public ResponseEntity adminLock(@Valid @RequestBody AdminLockRequest adminLockRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }
        Form form = formRepository.findById(adminLockRequest.getId()).orElseThrow();
        form.setLock(adminLockRequest.getLock());

        formRepository.save(form);
        return ResponseEntity.status(200).body(new Response(true,""));
    }

    @PostMapping("/admin/deleteForm")
    public ResponseEntity deleteForm(@Valid @RequestBody AdminDeleteFormRequest adminDeleteFormRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }
        Form form = formRepository.findById(adminDeleteFormRequest.getId()).orElseThrow();
        formRepository.delete(form);

        return ResponseEntity.status(200).body(new Response(true,""));
    }
}
