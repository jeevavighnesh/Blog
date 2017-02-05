package com.aynna.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aynna.exception.ServiceException;
import com.aynna.model.User;
import com.aynna.service.UserService;

@Controller
@RequestMapping("/home")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
	
	@PostMapping("/login")
	public String logIn(@RequestParam("EmailId") String emailId, @RequestParam("Password") String password) {

		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Logging In...");
		User user = new User();
		UserService userService = new UserService();
		user.setEmailId(emailId);
		user.setPassword(password);

		try {

			userService.login(user);
			return "userpage.jsp";

		} catch (ServiceException e) {
			
			LOGGER.log(Level.SEVERE, "!!!!Log In Faild Exception occured!!!\nProbably wrong input by user don't worry its handled for", e);
			
			return "index.jsp";

		}

	}

	@PostMapping("/register")
	public String registerNewUser(@RequestParam("Name") String name, @RequestParam("EmailId") String emailId,
			@RequestParam("Password") String password) throws ServiceException {

		User user = new User();
		UserService userService = new UserService();
		user.setEmailId(emailId);
		user.setName(name);
		user.setPassword(password);
		
		try {
			userService.registerService(user);
			return "index.jsp";

		} catch (ServiceException e) {
			
			LOGGER.log(Level.SEVERE, "!!!!Registration Faild Exception Occured!!!\n\nProbably wrong input by user don't worry its handled for", e);
			return "register.jsp";
			
		}

	}
	
}
