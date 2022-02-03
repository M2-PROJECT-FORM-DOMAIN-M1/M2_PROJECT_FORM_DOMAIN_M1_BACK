package com.project.database.repository.form;


import com.project.database.models.form.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IFormRepository extends JpaRepository<Form, Long> {
    boolean existsByCode(String code);
    Optional<Form> findByCode(String code);

}
