package com.aynna.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aynna.dao.ArticleDAO;
import com.aynna.model.Article;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
	private List<Article> articleList = articleDao.list();
	private ArticleDAO articleDao = new ArticleDAO();

	@GetMapping
	public String listArticles(ModelMap modelMap) {

		("home->");
		modelMap.addAttribute("ARTICLE_LIST", articleList);
		return "userpage.jsp";
		
	}

}
