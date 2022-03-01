package com.project.dto.requests.answer;

import java.util.List;

public class SendAnswerRequest {

    String email;
    String token;
    List<Data> answers;
    String code;

    public String getCode() {
        return code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SendAnswerRequest() {

    }

    public List<Data> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Data> answers) {
        this.answers = answers;
    }

    public static class Data {
        String answer;
        Long question;

        public Data() {

        }

        public Data(String answer, String mail, Long question) {
            this.answer = answer;
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }


        public Long getQuestion() {
            return question;
        }

        public void setQuestion(Long question) {
            this.question = question;
        }
    }
}
