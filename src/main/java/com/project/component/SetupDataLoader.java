package com.project.component;



import com.project.database.enums.RoleNameEnum;
import com.project.database.models.role.Role;
import com.project.database.models.users.Users;
import com.project.database.repository.role.IRoleRepository;
import com.project.database.repository.users.IUsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;



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

        usersRepository.deleteAll();
        roleRepository.deleteAll();


        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role(RoleNameEnum.ROLE_ADMIN));
        roleList.add(new Role(RoleNameEnum.ROLE_SUPER_ADMIN));
        roleRepository.saveAll(roleList);


        usersRepository.save(new Users("admin",
                "admin",
                "admin@admin.admin",
                passwordEncoder.encode("admin"),
                roleList.get(0)
        ));

    }
}