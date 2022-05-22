package com.project.controller.rulesType;

import com.project.controller.AbstractController;
import com.project.database.models.rulesType.RulesType;
import com.project.database.repository.rulesType.IRulesTypeRepository;
import com.project.dto.responses.rulesType.RulesTypeGetAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RulesTypeController extends AbstractController {

    IRulesTypeRepository rulesTypeRepository;

    public RulesTypeController(IRulesTypeRepository rulesTypeRepository) {
        this.rulesTypeRepository = rulesTypeRepository;
    }

    @GetMapping("/rulesType/getAll")
    public ResponseEntity<?> getAll() {

        List<RulesType> rulesTypes = rulesTypeRepository.findAll();
        return ResponseEntity.ok(new RulesTypeGetAllResponse(true, "get all rules type", rulesTypes));
    }
}

