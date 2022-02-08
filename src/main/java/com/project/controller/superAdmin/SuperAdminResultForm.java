package com.project.controller.superAdmin;

import com.project.controller.AbstractController;
import com.project.database.repository.form.IFormRepository;
import org.springframework.stereotype.Controller;

@Controller
public class SuperAdminResultForm extends AbstractController {

    IFormRepository formRepository;


    public SuperAdminResultForm(IFormRepository formRepository) {
        this.formRepository = formRepository;
    }
}
