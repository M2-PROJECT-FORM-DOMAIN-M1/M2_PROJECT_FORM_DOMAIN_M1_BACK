package com.project.database.repository.answers;

import com.project.database.models.answers.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IAnswersRepository extends JpaRepository<Answers, Long> {

    @Query("select new java.lang.Boolean(count(*) > 0) from Answers item where item.question.id IN :idsQuestion and item.mail = :email")
    Boolean getAlreadyAnswers(@Param("idsQuestion") List<Long> idsQuestion,@Param("email") String email);

    @Query("select item from Answers item where item.question.id IN :idsQuestion and item.mail = :email")
    List<Answers> getAnswersSavedPerUsers(@Param("idsQuestion") List<Long> idsQuestion, @Param("email") String email);


}
