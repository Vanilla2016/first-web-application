package com.in28minutes;

public class UserValidation {

	public boolean isUserValid (String name, String password) {
		
		if (name.equals("Dominic") && password.equals("Heffalump")) {
				return true;
		} else {
			return false;
		}
	}
}
