package com.project.controller.form;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.controller.AbstractController;
import com.project.database.models.form.Form;
import com.project.database.models.users.Users;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.dto.domain.SavedForm;
import com.project.dto.requests.form.GetFormByIDRequest;
import com.project.models.UserPrincipalFront;
import com.project.service.GenerateSaltStringService;
import org.springframework.http.ContentDisposition;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Controller
public class GlobalFormController extends AbstractController {


    IUsersRepository usersRepository;

    IFormRepository formRepository;


    public GlobalFormController(IUsersRepository usersRepository, IFormRepository formRepository) {
        this.usersRepository = usersRepository;
        this.formRepository = formRepository;
    }

    @PostMapping("/form/save")
    public void getFormToBeSaved(HttpServletResponse response, @Valid @RequestBody GetFormByIDRequest getFormByIdRequest, BindingResult bindingResult) throws JsonProcessingException {

        Authentication tes = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipalFront currentPrincipal = (UserPrincipalFront) tes.getPrincipal();

        Users users = usersRepository.getById(currentPrincipal.getId());

        Form form = users.getForms().stream().filter(elem -> Objects.equals(elem.getId(), getFormByIdRequest.getId())).findFirst().orElseThrow();

        ObjectMapper objectMapper = new ObjectMapper();
        SavedForm savedForm = new SavedForm(form);
        String savedFormString = objectMapper.writeValueAsString(savedForm.getData());

        byte[] file = savedFormString.getBytes(StandardCharsets.UTF_8);

        try {
            response.getOutputStream().write(file);
        } catch (IOException e) {
            // Do something
        }
    }

}
