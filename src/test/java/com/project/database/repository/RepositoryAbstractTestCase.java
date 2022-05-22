package com.project.database.repository;


import com.project.database.enums.QuestionTypeEnum;
import com.project.database.enums.RoleNameEnum;
import com.project.database.models.form.Form;
import com.project.database.models.question.Question;
import com.project.database.models.questionType.QuestionType;
import com.project.database.models.role.Role;
import com.project.database.models.users.Users;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.question.IQuestionRepository;
import com.project.database.repository.questionType.IQuestionTypeRepository;
import com.project.database.repository.role.IRoleRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.service.GenerateSaltStringService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RepositoryAbstractTestCase {

    @Autowired
    protected GenerateSaltStringService generateSaltString;
    @Autowired
    protected IQuestionRepository questionRepository;
    @Autowired
    protected IFormRepository formRepository;
    @Autowired
    protected IRoleRepository roleRepository;
    @Autowired
    protected IUsersRepository usersRepository;
    @Autowired
    protected IQuestionTypeRepository formTypeRepository;
    @Autowired
    protected PasswordEncoder passwordEncoder;



    @Before
    public void insertData(){


        usersRepository.deleteAll();

        List<QuestionType> questionTypes = new ArrayList<>();
        questionTypes.add(new QuestionType(QuestionTypeEnum.CHECKBOX, "CheckBox"));
        questionTypes.add(new QuestionType(QuestionTypeEnum.RADIO, "Radio"));
        questionTypes.add(new QuestionType(QuestionTypeEnum.TEXTINPUT, "Text input"));



        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Flo;Alex;Quentin",
                "Quel est ton prénom",
                questionTypes.get(0),
                null,0L,0L

        ));


        questions.add(new Question("c;b;a",
                "Where is the way",
                questionTypes.get(1),
                null,5L,1L

        ));

        questions.add(new Question("g;zeze;aazazaz",
                "Where is the second way",
                questionTypes.get(2),
                null,0L,3L

        ));

        questions.add(new Question("g;zeze;aazazaz",
                "az",
                questionTypes.get(0),
                null,0L,4L

        ));


        Form form = new Form("Ton prénom", "aaaaa", new ArrayList<>(questions));
        form.setLock(false);

        for (Question question : questions) {
            question.setForm(form);
        }
        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role(RoleNameEnum.ROLE_ADMIN));
        roleList.add(new Role(RoleNameEnum.ROLE_SUPER_ADMIN));
        roleRepository.deleteAll();
        roleRepository.saveAll(roleList);

        Users admin = new Users("admin",
                "admin",
                "admin@admin.admin",
                passwordEncoder.encode("admin"),
                roleList.get(0)
        );

        admin.setForms(Arrays.asList(form));



        usersRepository.save(new Users("superAdmin",
                "superAdmin",
                "superAdmin@superAdmin.superAdmin",
                passwordEncoder.encode("superAdmin"),
                roleList.get(1)
        ));

        usersRepository.save(new Users("1",
                "1",
                "1@1.1",
                passwordEncoder.encode("1"),
                roleList.get(0)
        ));

        usersRepository.save(new Users("1",
                "4",
                "test1@test1.test1",
                passwordEncoder.encode("1"),
                roleList.get(0)
        ));

        usersRepository.save(new Users("2",
                "2",
                "2@2.2",
                passwordEncoder.encode("superAdmin"),
                roleList.get(1)
        ));
        usersRepository.save(new Users("3",
                "3",
                "3@3.3",
                passwordEncoder.encode("superAdmin"),
                roleList.get(1)
        ));

    }

}
