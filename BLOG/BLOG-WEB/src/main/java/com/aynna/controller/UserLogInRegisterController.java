package com.aynna.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aynna.exception.ServiceException;
import com.aynna.model.User;
import com.aynna.service.UserService;

@Controller
@RequestMapping("/home")
public class UserLogInRegisterController {

	private static final Logger LOGGER = Logger.getLogger(UserLogInRegisterController.class.getName());

	@GetMapping
	public String listArticles(ModelMap articles, ModelMap exceptions) {

		UserService userService = new UserService();
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("home->");

		try {
			System.out.println(userService.articleListService());
			articles.addAttribute("ARTICLE_LIST",userService.articleListService());
		} catch (ServiceException e) {
		
			LOGGER.log(Level.SEVERE, "Error Most probably There are no Articles in the database", e);
			exceptions.addAttribute("EXCEPTION_LIST", e.getMessage());
		}
		return "index.jsp";

	}

	@PostMapping("/login")
	public String logIn(@RequestParam("EmailId") String emailId, @RequestParam("Password") String password, HttpSession logInSession) {

		LOGGER.setLevel(Level.INFO);
		LOGGER.info("Logging In...");
		User user = new User();
		UserService userService = new UserService();
		user.setEmailId(emailId);
		user.setPassword(password);

		try {

			userService.login(user);
			LOGGER.setLevel(Level.INFO);
			LOGGER.info("Log In Succuss :-)");
			logInSession.removeAttribute("EXCEPTIONS");
			logInSession.setAttribute("UserId", userService.resolveUserService(user));
			return "redirect:/user";

		} catch (ServiceException e) {

			LOGGER.log(Level.SEVERE,
					"!!!!Log In Faild Exception occured!!!\nProbably wrong input by user don't worry its handled for",
					e);
			logInSession.setAttribute("EXCEPTIONS", e.getMessage());
			return "redirect:/";

		}

	}

	@PostMapping("/register")
	public String registerNewUser(@RequestParam("Name") String name, @RequestParam("EmailId") String emailId,
			@RequestParam("Password") String password, ModelMap exceptions) throws ServiceException {

		User user = new User();
		UserService userService = new UserService();
		user.setEmailId(emailId);
		user.setName(name);
		user.setPassword(password);

		try {
			userService.registerService(user);
			LOGGER.setLevel(Level.INFO);
			LOGGER.info("Successfully Registration :-)");
			exceptions.addAttribute("EXCEPTIONS", "Registration Successfull");
			System.out.println(exceptions);
			return "../index.jsp";

		} catch (ServiceException e) {

			LOGGER.log(Level.SEVERE,
					"!!!!Registration Faild Exception Occured!!!\n\nProbably wrong input by user don't worry its handled for",
					e);
			exceptions.addAttribute("EXCEPTION_LIST", e.getMessage());
			return "../register.jsp";

		}

	}

}
