package com.aynna.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aynna.dao.UserDAO;
import com.aynna.exception.ValidatorException;

public class GeneralValidations {
	
	UserDAO userdao = new UserDAO();

	public void isValidField(String str, String message) throws ValidatorException {

		if (str == null || "".equals(str.trim())) {
			throw new ValidatorException("!!!!Empty " + message + " field!!!!");
		}

	}

	public void isValidField(String email) throws ValidatorException {
		
		String regex = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(email);
		if (!m.find()){
			throw new ValidatorException("!!!!Invalid EmailId !!!!");
		}
	}
	
	public void isAlreadyRegistered(String email) throws ValidatorException{
		
		if (userdao.find(email)){
			throw new ValidatorException("!!!!You're Already Registered to us!!!!");
		}
	}

}
