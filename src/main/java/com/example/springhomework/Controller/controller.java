package com.example.springhomework.Controller;


import com.example.springhomework.Annotation.BucketAnnotation;
import com.example.springhomework.VO.ResponceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @BucketAnnotation
    @GetMapping("/msg")
    public ResponceVO getMsg(){
        return ResponceVO.ok("hello");
    }
}
