package com.project.database.repository.questionType;

import com.project.database.models.questionType.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType, Long> {
}
