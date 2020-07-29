package com.example.springhomework;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/msg")
    public String getMsg(){
        return "hello";
    }
}
