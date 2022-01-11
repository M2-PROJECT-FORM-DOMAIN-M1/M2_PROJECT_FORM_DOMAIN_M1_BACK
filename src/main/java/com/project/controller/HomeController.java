package com.project.controller;


import com.project.dto.requests.home.HomeRequest;
import com.project.dto.responses.home.HomeResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController extends AbstractController{


    @PostMapping("/getCode")
    public ResponseEntity<?> test(@RequestBody HomeRequest codeRequest){
        System.out.println(codeRequest.getCode());
        return new ResponseEntity<>(new HomeResponse(true, "Code récupéré: " + codeRequest.getCode()),HttpStatus.ACCEPTED);
    }


}
