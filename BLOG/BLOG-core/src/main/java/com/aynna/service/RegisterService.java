package com.aynna.service;

import com.aynna.dao.UserDAO;
import com.aynna.exception.ServiceException;
import com.aynna.exception.ValidatorException;
import com.aynna.model.User;
import com.aynna.validator.RegisterValidator;

public class RegisterService {
	public void registerService(String name, String emailId, String password) throws ServiceException{
		
		User user = new User();
		user.setName(name);
		user.setEmailId(emailId);
		user.setPassword(password);
		
		UserDAO userDao = new UserDAO();
		
		RegisterValidator regval = new RegisterValidator();
		
		try {

			regval.registerValidator(user);
			userDao.save(user);

		} catch (ValidatorException e) {

			throw new ServiceException("!!!!Could not Add the new user!!!!",e);
			
		}

	}
}
