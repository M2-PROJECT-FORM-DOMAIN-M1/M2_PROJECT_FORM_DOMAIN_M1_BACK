package com.project.database.repository.answers;

import com.project.database.models.answers.Answers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAnswers  extends JpaRepository<Answers, Long> {


}
