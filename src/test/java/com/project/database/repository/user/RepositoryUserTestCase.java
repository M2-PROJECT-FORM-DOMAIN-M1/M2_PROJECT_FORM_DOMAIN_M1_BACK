package com.project.database.repository.user;

import com.project.database.enums.RoleNameEnum;
import com.project.database.models.role.Role;
import com.project.database.models.users.Users;
import com.project.database.repository.RepositoryAbstractTestCase;
import com.project.database.repository.role.IRoleRepository;
import com.project.database.repository.users.IUsersRepository;
import io.jsonwebtoken.lang.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class RepositoryUserTestCase extends RepositoryAbstractTestCase {


    @Autowired
    IUsersRepository usersRepository;

    @Autowired
    IRoleRepository roleRepository;

    @Test
    public void findByEmailOrNameOrUsername(){


        List<Users> empty = this.usersRepository.findTop5ByRoleIsAndEmailContainsOrNameContainsOrUsernameContains(RoleNameEnum.ROLE_ADMIN,"testazazaz","testazazaz","testazazaz").orElseThrow();
        Assert.isTrue(empty.size() == 0,"List must be empty");

        List<Users> empty1 = this.usersRepository.findTop5ByRoleIsAndEmailContainsOrNameContainsOrUsernameContains(RoleNameEnum.ROLE_ADMIN,"1","1","1").orElseThrow();
        Assert.isTrue(empty1.size() == 2,"List size must be equals to 2");




    }


}
