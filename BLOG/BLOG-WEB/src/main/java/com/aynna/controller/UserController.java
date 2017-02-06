package com.aynna.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aynna.exception.ServiceException;
import com.aynna.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	@GetMapping
	public String listArticles(ModelMap articles, ModelMap exceptions) {

		UserService userService = new UserService();
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("home->");

		try {
			System.out.println(userService.articleListService());
			articles.addAttribute("ARTICLE_LIST", userService.articleListService());
		} catch (ServiceException e) {
			exceptions.addAttribute("EXCEPTION_LIST", e);
		}
		return "userpage.jsp";

	}

}
