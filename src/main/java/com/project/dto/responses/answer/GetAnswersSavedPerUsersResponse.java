package com.project.dto.responses.answer;

import com.project.database.models.answers.Answers;
import com.project.dto.responses.Response;

import java.util.ArrayList;
import java.util.List;

public class GetAnswersSavedPerUsersResponse extends Response {
    List<Data> answersList = new ArrayList<>();

    public GetAnswersSavedPerUsersResponse(Boolean success, String message, List<Answers> answersList) {
        super(success, message);

        for(Answers answers : answersList){
            this.answersList.add(
                    new Data(
                            answers.getAnswer(),
                            answers.getQuestion().getId()
                    )
            );
        }

    }

    public List<Data> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Data> answersList) {
        this.answersList = answersList;
    }

    public class Data {
        private String answer;
        private Long questionId;

        public Data(String answer, Long questionId) {
            this.answer = answer;
            this.questionId = questionId;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public Long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }
    }
}
