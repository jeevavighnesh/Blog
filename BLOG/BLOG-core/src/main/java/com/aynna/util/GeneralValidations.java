package com.aynna.util;

import com.aynna.dao.UserDAO;
import com.aynna.exception.ValidatorException;

public class GeneralValidations {
	
	UserDAO userdao = new UserDAO();
	

	public void isValidField(String str, String message) throws ValidatorException {

		if (str == null || str.isEmpty()) {
			throw new ValidatorException("!!!!Empty " + message + " field!!!!");
		}

	}

	public void isValidField(String email) throws ValidatorException {
		
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		if (!(email.matches(regex))){
			throw new ValidatorException("!!!!Invalid EmailId !!!!");
		}
	}
	
	public void isAlreadyRegistered(String email) throws ValidatorException{
		
		if (!userdao.find(email)){
			throw new ValidatorException("!!!!You're Already Registered to us!!!!");
		}
	}

}
