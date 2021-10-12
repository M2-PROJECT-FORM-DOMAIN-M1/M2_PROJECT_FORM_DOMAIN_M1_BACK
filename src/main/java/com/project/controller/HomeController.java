package com.project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends AbstractController{


    @GetMapping("/")
    public ResponseEntity<?> test(){
        return  ResponseEntity.ok("toto");
    }

}
