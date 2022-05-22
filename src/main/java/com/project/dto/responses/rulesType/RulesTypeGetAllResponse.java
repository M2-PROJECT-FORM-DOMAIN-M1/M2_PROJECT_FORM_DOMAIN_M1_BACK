package com.project.dto.responses.rulesType;

import com.project.database.models.rulesType.RulesType;
import com.project.dto.responses.Response;

import java.util.List;

public class RulesTypeGetAllResponse  extends Response {

    private List<RulesType> rulesType;


    public RulesTypeGetAllResponse(Boolean success, String message, List<RulesType> rulesType) {
        super(success, message);
        this.rulesType = rulesType;
    }

    public List<RulesType> getRulesType() {
        return rulesType;
    }

    public void setRulesType(List<RulesType> rulesTypes) {
        this.rulesType = rulesTypes;
    }
}
