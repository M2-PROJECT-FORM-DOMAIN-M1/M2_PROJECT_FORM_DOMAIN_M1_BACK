package com.project.controller.superAdmin;

import com.project.controller.AbstractController;
import com.project.database.models.form.Form;
import com.project.database.models.users.Users;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.dto.requests.common.IdRequest;
import com.project.dto.requests.superAdmin.SuperAdminAdminLockRequest;
import com.project.dto.requests.superAdmin.SuperAdminDeleteForm;
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
public class SuperAdminDetailedInformationController extends AbstractController {

    @Autowired
    IFormRepository formRepository;

    @Autowired
    IUsersRepository usersRepository;

    @PostMapping("/superAdmin/admin/lock")
    public ResponseEntity adminLock(@Valid @RequestBody SuperAdminAdminLockRequest superAdminAdminLockRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }
        Form form = formRepository.findById(superAdminAdminLockRequest.getId()).orElseThrow();
        form.setLock(superAdminAdminLockRequest.getLock());

        formRepository.save(form);
        return ResponseEntity.status(200).body(new Response(true,""));
    }

    @PostMapping("/superAdmin/admin/deleteForm")
    public ResponseEntity deleteForm(@Valid @RequestBody SuperAdminDeleteForm superAdminDeleteForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }
        Form form = formRepository.findById(superAdminDeleteForm.getId()).orElseThrow();
        formRepository.delete(form);

        return ResponseEntity.status(200).body(new Response(true,""));
    }

    @PostMapping("/superAdmin/admin/getAdmin")
    public ResponseEntity getAdmin(@Valid @RequestBody IdRequest idRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(298).body(new Response(false,""));
        }

        Users users = usersRepository.findById(idRequest.getId()).orElseThrow();

        return ResponseEntity.status(200).body(new SuperAdminAdminGetAdminResponse(true,"",users));

    }

}
