package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String getUser() {
        return "user";
    }
    
    @GetMapping("/exception")
    public String getException() throws Exception {
        throw new Exception();
    }
    
    @GetMapping("/illegal")
    public String getIllegalState() throws IllegalStateException {
    	throw new IllegalStateException();
    }
    
    
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
    	System.out.println("exception");
    }
    
    @ExceptionHandler(IllegalStateException.class)
    public void handleException2(IllegalStateException e) {
    	System.out.println("IllegalState");
    }
    
    @GetMapping("/cookieTest")
    public UserCookie getCookie() {
    	UserCookie userCookie = new UserCookie();
    	userCookie.setValue1("test1");
    	userCookie.setValue2("value2");
    	userCookie.setValue3(33);
    	return userCookie;
    }
    
    @GetMapping("/redirectTest")
    public String getRedirect() {
    	return "redirect:https://www.naver.com/";
    }
    
    
    
    @GetMapping("/planePageTest")
    public String getPlanePage() {
    	return "<html>\n" + "<header><title>Welcome</title></header>\n" +
    		    "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
    }
    
    
    public class UserException extends IllegalStateException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    	
    }
    
    @GetMapping("/userexception")
    public String getUserException() throws UserException {
    	throw new UserException();
    }
    
    class UserCookie{
    	String value1;
    	String value2;
    	int value3;
		public String getValue1() {
			return value1;
		}
		public void setValue1(String value1) {
			this.value1 = value1;
		}
		public String getValue2() {
			return value2;
		}
		public void setValue2(String value2) {
			this.value2 = value2;
		}
		public int getValue3() {
			return value3;
		}
		public void setValue3(int value3) {
			this.value3 = value3;
		}
    	
    	
    }
    
}