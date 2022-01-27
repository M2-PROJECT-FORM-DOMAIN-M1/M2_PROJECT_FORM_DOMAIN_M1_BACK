package com.project.controller.questionType;

import com.project.controller.AbstractController;
import com.project.database.models.questionType.QuestionType;
import com.project.database.repository.questionType.IQuestionTypeRepository;
import com.project.dto.responses.questionType.QuestionTypeGetAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QuestionTypeController extends AbstractController {


    @Autowired
    IQuestionTypeRepository formTypeRepository;

    @GetMapping("/questionType/getAll")
    public ResponseEntity getAll(){

        List<QuestionType> questionTypeList = formTypeRepository.findAll();
        return ResponseEntity.ok(new QuestionTypeGetAllResponse(true,"get all form type", questionTypeList));
    }
}
