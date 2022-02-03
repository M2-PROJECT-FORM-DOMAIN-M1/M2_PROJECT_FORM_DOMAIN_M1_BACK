package com.project.component;


import com.project.database.enums.QuestionTypeEnum;
import com.project.database.enums.RoleNameEnum;
import com.project.database.models.form.Form;
import com.project.database.models.question.Question;
import com.project.database.models.questionType.QuestionType;
import com.project.database.models.role.Role;
import com.project.database.models.users.Users;
import com.project.database.repository.answers.IAnswersRepository;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.question.IQuestionRepository;
import com.project.database.repository.questionType.IQuestionTypeRepository;
import com.project.database.repository.role.IRoleRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.service.GenerateSaltStringService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    GenerateSaltStringService generateSaltString;

    IQuestionRepository questionRepository;

    IFormRepository formRepository;

    IRoleRepository roleRepository;

    IQuestionTypeRepository formTypeRepository;

    IAnswersRepository answersRepository;

    IUsersRepository usersRepository;

    PasswordEncoder passwordEncoder;

    public SetupDataLoader(IAnswersRepository answersRepository, GenerateSaltStringService generateSaltString, IQuestionRepository questionRepository, IFormRepository formRepository, IRoleRepository roleRepository, IQuestionTypeRepository formTypeRepository, IUsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.alreadySetup = alreadySetup;
        this.generateSaltString = generateSaltString;
        this.questionRepository = questionRepository;
        this.formRepository = formRepository;
        this.roleRepository = roleRepository;
        this.formTypeRepository = formTypeRepository;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.answersRepository = answersRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup)
            return;


        List<QuestionType> questionTypes = new ArrayList<>();
        questionTypes.add(new QuestionType(QuestionTypeEnum.CHECKBOX, "CheckBox"));
        questionTypes.add(new QuestionType(QuestionTypeEnum.RADIO, "Radio"));
        questionTypes.add(new QuestionType(QuestionTypeEnum.TEXTINPUT, "Text input"));
        formTypeRepository.saveAll(questionTypes);



        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Flo;Alex;Quentin",
                "Quel est ton prénom",
                questionTypes.get(0),
                null,0L

        ));


        questions.add(new Question("c;b;a",
                "Where is the way",
                questionTypes.get(1),
                null,5L

        ));

        questions.add(new Question("g;zeze;aazazaz",
                "Where is the second way",
                questionTypes.get(2),
                null,0L

        ));

        questions.add(new Question("g;zeze;aazazaz",
                "az",
                questionTypes.get(0),
                null,0L

        ));


        Form form = new Form("Ton prénom", "aaaaa", new ArrayList<>(questions));
        form.setLock(false);

        for (Question question : questions) {
            question.setForm(form);
        }
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
        form.setUsers(admin);
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