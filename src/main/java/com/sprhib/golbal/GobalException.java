package com.sprhib.golbal;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GobalException {

	@ExceptionHandler(NullPointerException.class)
    public String showError()
    {
    	return "null";
    }
	@ExceptionHandler(Exception.class)
    public String showExp()
    {
    	return "exp";
    }
}
