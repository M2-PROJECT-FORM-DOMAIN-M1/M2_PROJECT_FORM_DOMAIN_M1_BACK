package com.project.dto.responses.questionType;

import com.project.database.enums.QuestionTypeEnum;
import com.project.database.models.questionType.QuestionType;
import com.project.dto.responses.Response;

import java.util.ArrayList;
import java.util.List;

public class QuestionTypeGetAllResponse extends Response {

    private List<Data> dataList = new ArrayList<>();

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public QuestionTypeGetAllResponse(Boolean success, String message, List<QuestionType> questionTypeList) {
        super(success, message);

        for (QuestionType questionType : questionTypeList) {
            this.dataList.add(new Data(
                    questionType.getId(),
                    questionType.getQuestionType(),
                    questionType.getQuestionTypeRenderText()
            ));
        }


    }


    private class Data {
        private Long id;
        private QuestionTypeEnum questionType;
        private String questionTypeRenderText;

        public Data(Long id, QuestionTypeEnum questionType, String questionTypeRenderText) {
            this.id = id;
            this.questionType = questionType;
            this.questionTypeRenderText = questionTypeRenderText;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public QuestionTypeEnum getQuestionType() {
            return questionType;
        }

        public void setQuestionType(QuestionTypeEnum questionType) {
            this.questionType = questionType;
        }

        public String getQuestionTypeRenderText() {
            return questionTypeRenderText;
        }

        public void setQuestionTypeRenderText(String questionTypeRenderText) {
            this.questionTypeRenderText = questionTypeRenderText;
        }
    }
}
