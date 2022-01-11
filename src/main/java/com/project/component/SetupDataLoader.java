package com.project.component;



import com.project.database.enums.FormType;
import com.project.database.enums.RoleNameEnum;
import com.project.database.models.form.Form;
import com.project.database.models.question.Question;
import com.project.database.models.role.Role;
import com.project.database.models.users.Users;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.question.IQuestionRepository;
import com.project.database.repository.role.IRoleRepository;
import com.project.database.repository.users.IUsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;

    @Autowired
    IQuestionRepository questionRepository;

    @Autowired
    IFormRepository formRepository;

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    IUsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup)
            return;



        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Flo;Alex;Quentin",
                "Quel est ton prénom",
                FormType.CHECKBOX,
                null
        ));


        questionRepository.saveAll(questions);

        Form form = new Form("Ton prénom",questions);
        formRepository.save(form);


        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role(RoleNameEnum.ROLE_ADMIN));
        roleList.add(new Role(RoleNameEnum.ROLE_SUPER_ADMIN));
        roleRepository.saveAll(roleList);


        Users admin = new Users("admin",
                "admin",
                "admin@admin.admin",
                passwordEncoder.encode("admin"),
                roleList.get(0)
        );

        admin.setForms(Arrays.asList(form));

        usersRepository.save(admin);

        usersRepository.save(new Users("superAdmin",
                "superAdmin",
                "superAdmin@superAdmin.superAdmin",
                passwordEncoder.encode("superAdmin"),
                roleList.get(1)
        ));

    }
}