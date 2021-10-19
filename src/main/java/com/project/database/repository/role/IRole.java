package com.project.database.repository.role;

import com.project.database.models.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRole extends JpaRepository<Role, Long> {


}