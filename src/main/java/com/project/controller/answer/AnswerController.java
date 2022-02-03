package com.project.controller.answer;

import com.project.controller.AbstractController;
import com.project.database.models.answers.Answers;
import com.project.database.models.form.Form;
import com.project.database.models.question.Question;
import com.project.database.repository.answers.IAnswersRepository;
import com.project.database.repository.form.IFormRepository;
import com.project.database.repository.question.IQuestionRepository;
import com.project.dto.requests.answer.GetAnswersSavedPerUsersRequest;
import com.project.dto.requests.answer.SendAnswerRequest;
import com.project.dto.responses.Response;
import com.project.dto.responses.answer.GetAnswersSavedPerUsersResponse;
import com.project.models.UserAzure;
import com.project.service.UserAzureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AnswerController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);


    IQuestionRepository questionRepository;

    IAnswersRepository answersRepository;

    UserAzureService userAzureService;

    IFormRepository formRepository;

    public AnswerController(IQuestionRepository questionRepository, IAnswersRepository answersRepository, UserAzureService userAzureService, IFormRepository formRepository) {
        this.questionRepository = questionRepository;
        this.answersRepository = answersRepository;
        this.userAzureService = userAzureService;
        this.formRepository = formRepository;
    }


    @PostMapping("/public/answer/sendAnswer")
    public ResponseEntity sendAnswer(@Valid @RequestBody SendAnswerRequest sendAnswerRequest, BindingResult bindingResult) {
        UserAzure userAzure;
        try {
            userAzure = userAzureService.getUserAzure(sendAnswerRequest.getEmail(), sendAnswerRequest.getToken());
        } catch (Exception e) {
            return ResponseEntity.status(299).body(new Response(false, "invalid token"));
        }


        if (answersRepository.existsByMail(userAzure.getMail())) {
            return ResponseEntity.status(299).body(new Response(false, "you have already answered to this form"));
        } else {
            for (SendAnswerRequest.Data data : sendAnswerRequest.getAnswers()) {
                Question question = questionRepository.findById(data.getQuestion()).orElseThrow();
                Answers answers = new Answers();
                answers.setMail(userAzure.getMail());
                answers.setAnswer(data.getAnswer());

                List<Answers> answersList = question.getAnswers();
                answersList.add(answers);

                question.setAnswers(answersList);
                answers.setQuestion(question);
                questionRepository.save(question);

            }

        }
        return ResponseEntity.status(200).body(new Response(true, "answer send"));
    }

    @PostMapping("/public/answer/getAnswersSaved")
    public ResponseEntity getAnswerIfAlreadyAnswered(@Valid @RequestBody GetAnswersSavedPerUsersRequest getAnswersSavedPerUsersRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(298).body(new Response(false, "error checking if form is already answered"));
        }

        UserAzure userAzure;
        try {
            userAzure = userAzureService.getUserAzure(getAnswersSavedPerUsersRequest.getEmail(), getAnswersSavedPerUsersRequest.getToken());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(299).body(new Response(false, "invalid token"));
        }

        Form form = formRepository.findByCode(getAnswersSavedPerUsersRequest.getCode()).orElseThrow();

        List<Long> ids = form.getQuestions().stream().map((Question::getId)).collect(Collectors.toList());
        List<Answers> answers = answersRepository.getAnswersSavedPerUsers(ids, userAzure.getMail());


        return ResponseEntity.status(200).body(new GetAnswersSavedPerUsersResponse(true, "answers exist by mail", answers));

    }

}
