package com.qfedu.man.exception;

import com.qfedu.man.common.JsonBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*//异常类必须使用该注解
@ControllerAdvice
@ResponseBody//看情况*/
/*@RestControllerAdvice 相当于 @ControllerAdvice + @ResponseBody*/
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public JsonBean exception(Exception e){
        e.printStackTrace();
        return new JsonBean(1,e.getMessage());
    }
}
