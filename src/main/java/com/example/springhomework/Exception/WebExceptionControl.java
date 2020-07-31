package com.example.springhomework.Exception;

import com.example.springhomework.VO.ResponceVO;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class WebExceptionControl {
    @ExceptionHandler(APIException.class)
    public ResponceVO APIExceptionHandler(APIException e) {
        return ResponceVO.build(400,e.getMessage());
    }
}
