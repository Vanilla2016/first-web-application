package com.in28minutes.actions;

import com.opensymphony.xwork2.ActionSupport;

public class SetUpAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public String readNameTableString = null;
	public static final String INGREDIENTSQUERY =  "SELECT INGREDIENTID, INGREDIENTNAME FROM SYMPTOMSDB.INGREDIENTS";
	
	public String execute() {
		System.out.println("FOUND!");
				return SUCCESS;
	  }
}
