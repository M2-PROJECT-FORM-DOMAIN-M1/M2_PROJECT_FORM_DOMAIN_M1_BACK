package com.project.database.repository.users;

import com.project.database.enums.RoleNameEnum;
import com.project.database.models.role.Role;
import com.project.database.models.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface IUsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    Optional<List<Users>> findByRole(Role role);

    Optional<Users> findByUsernameOrEmail(String username, String email);

    List<Users> findByIdIn(List<Long> userIds);

    Optional<Users> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query("SELECT u FROM Users  u WHERE u.role.name = ?1 and (u.name LIKE CONCAT('%',?2,'%') or u.email LIKE CONCAT('%',?3,'%') or u.username LIKE CONCAT('%',?4,'%')) ")
    Optional<List<Users>> findTop5ByRoleIsAndEmailContainsOrNameContainsOrUsernameContains( RoleNameEnum role, String email, String name, String username);

}