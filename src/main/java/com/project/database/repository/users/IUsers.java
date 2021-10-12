package com.project.database.repository.users;

import com.project.database.models.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsers extends JpaRepository<Users, Long> {



}