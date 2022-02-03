package com.project.database.repository.user;

import com.project.database.enums.RoleNameEnum;
import com.project.database.models.users.Users;
import com.project.database.repository.RepositoryAbstractTestCase;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.question.IQuestionRepository;
import com.project.database.repository.questionType.IQuestionTypeRepository;
import com.project.database.repository.role.IRoleRepository;
import com.project.database.repository.users.IUsersRepository;
import com.project.service.GenerateSaltStringService;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


public class RepositoryUserTestCase extends RepositoryAbstractTestCase {


    IUsersRepository usersRepository;



    public RepositoryUserTestCase(GenerateSaltStringService generateSaltString, IQuestionRepository questionRepository, IFormRepository formRepository, IRoleRepository roleRepository, IUsersRepository usersRepository, IQuestionTypeRepository formTypeRepository, PasswordEncoder passwordEncoder) {
        super(generateSaltString, questionRepository, formRepository, roleRepository, usersRepository, formTypeRepository, passwordEncoder);
    }

    @Test
    public void findByEmailOrNameOrUsername(){


        List<Users> empty = this.usersRepository.findTop5ByRoleIsAndEmailContainsOrNameContainsOrUsernameContains(RoleNameEnum.ROLE_ADMIN,"testazazaz","testazazaz","testazazaz").orElseThrow();
        Assert.isTrue(empty.size() == 0,"List must be empty");

        List<Users> empty1 = this.usersRepository.findTop5ByRoleIsAndEmailContainsOrNameContainsOrUsernameContains(RoleNameEnum.ROLE_ADMIN,"1","1","1").orElseThrow();
        Assert.isTrue(empty1.size() == 2,"List size must be equals to 2");




    }


}
