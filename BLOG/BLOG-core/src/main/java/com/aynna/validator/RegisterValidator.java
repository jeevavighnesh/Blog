package com.aynna.validator;

import com.aynna.exception.ValidatorException;
import com.aynna.model.User;
import com.aynna.util.GeneralValidations;

public class RegisterValidator {
	public void registerValidator(User user) throws ValidatorException{
		
		GeneralValidations genvalid = new GeneralValidations();
		genvalid.isValidField(user.getName(),"Name");
		genvalid.isValidField(user.getEmailId());
		genvalid.isAlreadyRegistered(user.getEmailId());
		genvalid.isValidField(user.getPassword(),"Password");
	}
	
}
