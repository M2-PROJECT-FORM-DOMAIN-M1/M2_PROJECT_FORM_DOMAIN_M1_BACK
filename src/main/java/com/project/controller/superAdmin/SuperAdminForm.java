package com.project.controller.superAdmin;

import com.project.controller.AbstractController;
import com.project.database.models.form.Form;
import com.project.database.repository.form.IFormRepository;
import com.project.dto.requests.form.GetFormByIDRequest;
import com.project.dto.responses.Response;
import com.project.dto.responses.form.GetFormByIDResponse;
import com.project.dto.responses.form.GetFormByIdFullResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class SuperAdminForm extends AbstractController {


    IFormRepository formRepository;


    public SuperAdminForm(IFormRepository formRepository) {
        this.formRepository = formRepository;
    }


    @PostMapping("/form/getFormById")
    public ResponseEntity getFormById(@Valid @RequestBody GetFormByIDRequest getFormByIdRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(298).body(new Response(false, "error when getting form by id"));
        }
        Form form = formRepository.findById(getFormByIdRequest.getId()).orElseThrow();
        return ResponseEntity.status(200).body(new GetFormByIDResponse(true, "form by id", form));

    }

    @PostMapping("/form/getFormByIdFull")
    public ResponseEntity getFormByIdFull(@Valid @RequestBody GetFormByIDRequest getFormByIdRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(298).body(new Response(false, "error when getting form by id"));
        }
        Form form = formRepository.findById(getFormByIdRequest.getId()).orElseThrow();
        return ResponseEntity.status(200).body(new GetFormByIdFullResponse(true, "form by id", form));

    }


}
