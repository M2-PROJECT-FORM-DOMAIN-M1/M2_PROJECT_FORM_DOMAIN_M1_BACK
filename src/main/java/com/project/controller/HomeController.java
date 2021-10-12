package com.project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController extends AbstractController{


    @PostMapping("/getCode")
    public ResponseEntity<?> test(){
        return  ResponseEntity.ok("toto");
    }

}
