package com.aynna.validator;

import com.aynna.exception.ValidatorException;
import com.aynna.model.User;
import com.aynna.util.GeneralValidations;

public class LoginValidator {
	
	public void loginValidator(User user) throws ValidatorException {
		
		GeneralValidations generalValidations = new GeneralValidations();
		generalValidations.isValidField(user.getEmailId());
		generalValidations.isValidField(user.getPassword(), "Password");
		try {
			
			generalValidations.isAlreadyRegistered(user.getEmailId(), "You are Not From our Company");
			throw new ValidatorException("You are not from our Organization");
			
		}catch(ValidatorException e) {
			generalValidations.isEmailIdPasswordMatch(user.getEmailId(), user.getPassword());
			return;
		}
		
	}
	
}
