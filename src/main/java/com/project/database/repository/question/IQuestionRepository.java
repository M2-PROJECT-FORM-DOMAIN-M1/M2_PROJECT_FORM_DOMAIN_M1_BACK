package com.project.database.repository.question;

import com.project.database.models.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<Question, Long> {

}
