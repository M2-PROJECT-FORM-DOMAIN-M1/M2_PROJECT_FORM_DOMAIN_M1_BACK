package com.project.component;


import com.project.database.enums.QuestionTypeEnum;
import com.project.database.enums.RoleNameEnum;
import com.project.database.enums.RulesTypeEnum;
import com.project.database.models.answers.Answers;
import com.project.database.models.form.Form;
import com.project.database.models.question.Question;
import com.project.database.models.questionType.QuestionType;
import com.project.database.models.role.Role;
import com.project.database.models.rulesType.RulesType;
import com.project.database.models.users.Users;
import com.project.database.repository.answers.IAnswersRepository;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.question.IQuestionRepository;
import com.project.database.repository.questionType.IQuestionTypeRepository;
import com.project.database.repository.role.IRoleRepository;
import com.project.database.repository.rulesType.IRulesTypeRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.service.GenerateSaltStringService;
import org.apache.commons.lang3.RandomStringUtils;
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

    IRulesTypeRepository rulesTypeRepository;

    public SetupDataLoader(IRulesTypeRepository rulesTypeRepository, IAnswersRepository answersRepository, GenerateSaltStringService generateSaltString, IQuestionRepository questionRepository, IFormRepository formRepository, IRoleRepository roleRepository, IQuestionTypeRepository formTypeRepository, IUsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.alreadySetup = alreadySetup;
        this.generateSaltString = generateSaltString;
        this.questionRepository = questionRepository;
        this.formRepository = formRepository;
        this.roleRepository = roleRepository;
        this.formTypeRepository = formTypeRepository;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.answersRepository = answersRepository;
        this.rulesTypeRepository=rulesTypeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup)
            return;


        List<QuestionType> questionTypes = new ArrayList<>();
        questionTypes.add(new QuestionType(QuestionTypeEnum.CHECKBOX, "Multiple choices"));
        questionTypes.add(new QuestionType(QuestionTypeEnum.RADIO, "Unique choice"));
        questionTypes.add(new QuestionType(QuestionTypeEnum.TEXTINPUT, "Open question"));
        formTypeRepository.saveAll(questionTypes);


        List<RulesType> rulesTypes = new ArrayList<>();
        rulesTypes.add(new RulesType(RulesTypeEnum.AT_LEAST_ONE, "at least one"));
        rulesTypes.add(new RulesType(RulesTypeEnum.FILLED, "filled"));
        rulesTypes.add(new RulesType(RulesTypeEnum.SPECIFIED_VALUE, "specified value(s)"));
        rulesTypeRepository.saveAll(rulesTypes);


        List<Answers> answersQuestion1 = new ArrayList<>();
        List<Answers> answersQuestion2 = new ArrayList<>();

        List<Answers> answersQuestion3 = new ArrayList<>();

        answersQuestion1.add(new Answers(
                "a@a.com",
                "a",
                null
        ));

        answersQuestion1.add(new Answers(
                "a@a.com",
                "a;z",
                null
        ));

        answersQuestion1.add(new Answers(
                "b@b.com",
                "b",
                null
        ));

        answersQuestion1.add(new Answers(
                "c@b.com",
                "c",
                null
        ));

        answersQuestion2.add(new Answers(
                "a@a.com",
                "test",
                null
        ));

        answersQuestion2.add(new Answers(
                "b@b.com",
                "test",
                null
        ));

        answersQuestion2.add(new Answers(
                "d@d.com",
                "test",
                null
        ));



        for(int i = 0 ; i < 10 ; i++){
            answersQuestion3.add(new Answers(
                    RandomStringUtils.randomAlphabetic(10),
           RandomStringUtils.randomAlphabetic(5),
                    null
            ));
        }




        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Flo;Alex;Quentin",
                "Quel est ton prénom",
                questionTypes.get(0),
                answersQuestion1,0L,
                0L
        ));

        for (Answers answers1 : answersQuestion1){
            answers1.setQuestion(questions.get(0));
        }

        questions.add(new Question("c;b;a",
                "Where is the way",
                questionTypes.get(1),
                answersQuestion2,5L,1L

        ));

        for (Answers answers1 : answersQuestion2){
            answers1.setQuestion(questions.get(1));
        }

        questions.add(new Question("g;zeze;aazazaz",
                "Where is the second way",
                questionTypes.get(2),
                answersQuestion3,0L,2L

        ));

        for (Answers answers1 : answersQuestion3){
            answers1.setQuestion(questions.get(2));
        }

        questions.add(new Question("g;zeze;aazazaz",
                "az",
                questionTypes.get(0),
                null,0L,3L

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