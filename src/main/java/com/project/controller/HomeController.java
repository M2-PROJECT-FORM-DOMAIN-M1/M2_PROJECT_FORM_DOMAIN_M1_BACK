package com.project.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController extends AbstractController{


    @GetMapping("/")
    public ResponseEntity<?> test(){
        return  ResponseEntity.ok("az");
    }

}
