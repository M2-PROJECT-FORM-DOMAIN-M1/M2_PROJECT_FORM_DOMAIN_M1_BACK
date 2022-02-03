package com.project.controller.form;

import com.project.controller.AbstractController;
import com.project.database.models.form.Form;
import com.project.database.repository.form.IFormRepository;
import com.project.dto.requests.form.GetFormByCodeRequest;
import com.project.dto.requests.form.GetFormByIDRequest;
import com.project.dto.responses.Response;
import com.project.dto.responses.form.FormExistsByCodeResponse;
import com.project.dto.responses.form.GetFormByCodeResponse;
import com.project.dto.responses.form.GetFormByIDResponse;
import com.project.service.UserAzureService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class FormController extends AbstractController {


    IFormRepository formRepository;

    UserAzureService userAzureService;


    public FormController(IFormRepository formRepository, UserAzureService userAzureService) {
        this.formRepository = formRepository;
        this.userAzureService = userAzureService;
    }

    @PostMapping("/form/getFormById")
    public ResponseEntity getFormById(@Valid @RequestBody GetFormByIDRequest getFormByIdRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(298).body(new Response(false, "error when getting form by id"));
        }
        Form form = formRepository.findById(getFormByIdRequest.getId()).orElseThrow();
        return ResponseEntity.status(200).body(new GetFormByIDResponse(true, "form by id", form));

    }

    @PostMapping("/public/form/getFormByCode")
    public ResponseEntity getFormByCode(@Valid @RequestBody GetFormByCodeRequest getFormByCodeRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(298).body(new Response(false, "error when getting form by code"));
        }
        Form form = formRepository.findByCode(getFormByCodeRequest.getCode()).orElseThrow();
        return ResponseEntity.status(200).body(new GetFormByCodeResponse(true, "form by code", form));

    }

    @PostMapping("/public/form/formExist")
    public ResponseEntity formExist(@Valid @RequestBody GetFormByCodeRequest getFormByCodeRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(298).body(new Response(false, "error checking if form exist by code"));
        }
        Boolean isFormExist = formRepository.existsByCode(getFormByCodeRequest.getCode());
        return ResponseEntity.status(200).body(new FormExistsByCodeResponse(true, "form by code", isFormExist));

    }



}
