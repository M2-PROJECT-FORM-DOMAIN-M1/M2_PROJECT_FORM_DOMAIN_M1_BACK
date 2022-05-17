package com.project.controller.admin;

import com.project.controller.AbstractController;
import com.project.database.models.form.Form;
import com.project.database.models.users.Users;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.dto.requests.admin.AdminAdminLockRequest;
import com.project.dto.requests.admin.AdminDeleteFormRequest;
import com.project.dto.requests.common.IdRequest;
import com.project.dto.requests.superAdmin.SuperAdminAdminLockRequest;
import com.project.dto.requests.superAdmin.SuperAdminDeleteFormRequest;
import com.project.dto.responses.Response;
import com.project.dto.responses.superAdmin.SuperAdminAdminGetAdminResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class AdminDetailedInformationController extends AbstractController {

    @Autowired
    IFormRepository formRepository;

    @Autowired
    IUsersRepository usersRepository;

    @PostMapping("/admin/lock")
    public ResponseEntity adminLock(@Valid @RequestBody AdminAdminLockRequest adminAdminLockRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }
        Form form = formRepository.findById(adminAdminLockRequest.getId()).orElseThrow();
        form.setLock(adminAdminLockRequest.getLock());

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
