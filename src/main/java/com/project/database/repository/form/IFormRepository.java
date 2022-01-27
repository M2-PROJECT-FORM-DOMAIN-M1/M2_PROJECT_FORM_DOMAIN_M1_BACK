package com.project.database.repository.form;


import com.project.database.models.form.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFormRepository extends JpaRepository<Form, Long> {
    boolean existsByCode(String code);
}
