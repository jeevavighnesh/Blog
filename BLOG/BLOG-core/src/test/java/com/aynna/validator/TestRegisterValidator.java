package com.aynna.validator;

import com.aynna.exception.ValidatorException;
import com.aynna.model.User;

public class TestRegisterValidator {
	public static void main(String[] args) throws ValidatorException {

		User user = new User();
		user.setName("Ki");
		user.setEmailId("jeevavignesh@gmail.com");
		user.setPassword("quarkkki");
		RegisterValidator regvalid = new RegisterValidator();
		regvalid.registerValidator(user);

	}

}
