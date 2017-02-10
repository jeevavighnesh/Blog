package com.aynna.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.aynna.exception.ServiceException;
import com.aynna.model.Article;
import com.aynna.model.User;
import com.aynna.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	@GetMapping
	public String listArticles(ModelMap articles, ModelMap exceptions) {

		UserService userService = new UserService();
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("user->");

		try {
			System.out.println(userService.articleListService());
			articles.addAttribute("ARTICLE_LIST",userService.articleListService());
		} catch (ServiceException e) {

			LOGGER.log(Level.SEVERE, "Error Most probably There are no Articles in the database", e);
			exceptions.addAttribute("EXCEPTION_LIST",e);
		
		}
		return "userpage.jsp";

	}

	@PostMapping("/post_article")
	public void postArticle(@RequestParam("JSON") String json, HttpSession userId) throws JSONException {

		LOGGER.log(Level.INFO, "User->Post Article");
		
		System.out.println(json);
		System.out.println(userId.getAttribute("UserId"));
		final JSONObject articleJSON = new JSONObject(json);

		User user = new User();
		user.setId((long)userId.getAttribute("UserId"));
		
		System.out.println("User.getid(): "+ user.getId());
		
		Article article =new Article();
		article.setTitle(articleJSON.getString("Title"));
		article.setContent(articleJSON.getString("Content"));
		
		final JSONArray tags = articleJSON.getJSONArray("Tags");
		List<String> categoryList = new ArrayList<String>();  
		
		for (int i = 0; i < tags.length(); i++) {

			JSONObject tagObj = tags.getJSONObject(i);
			categoryList.add(i, (String) tagObj.get("tag"));
		}
		
		System.out.println(user);
		System.out.println(article);
		System.out.println(categoryList);
		
		UserService userService = new UserService();
		try {
			userService.postArticleService(user, article, categoryList);
		} catch (ServiceException e) {

			LOGGER.log(Level.SEVERE, "Could Not Post the article Sry!!!", e);
		
		}

	}
	
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		System.out.println("User->LogOut");
		return "redirect:/";
		
	}

}
