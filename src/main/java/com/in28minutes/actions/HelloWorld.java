package com.in28minutes.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends TutorialSupport {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "HelloWorld";
	 
	
		//changed this as inherited method getText was causing interference with it 
	    public String execute() throws Exception {
	        setMessage(MESSAGE);
	        return SUCCESS;
	    }
	 
	    private String message;
	 
	    public void setMessage(String message){
	        this.message = message;
	    }
	 
	    public String getMessage() {
	        return message;
	    }
}
