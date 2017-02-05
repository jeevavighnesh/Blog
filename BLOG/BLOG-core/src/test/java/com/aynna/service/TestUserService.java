package com.aynna.service;

import java.awt.geom.Area;
import java.util.Arrays;
import java.util.List;

import com.aynna.exception.ServiceException;
import com.aynna.model.Article;
import com.aynna.model.Category;
import com.aynna.model.User;

public class TestUserService {
	public static void main(String[] args) throws ServiceException {

		UserService regserv = new UserService();
		User user = new User();
		user.setEmailId("jeevavignesh@gmail.com");
		user.setPassword("qweasdzxc1qaz2wsx3edc");
		// user.setName("VighneshS");
		// regserv.registerService(user);
		
		
		regserv.login(user);
		

		// Article article = new Article();
		// article.setTitle("dbashf djkfdfjkl");
		// article.setContent("dkjdsnfdsds,'f;;'df;dkfkskdfkldfklsffsdkkfsdbfdksn
		// ds;f,s;dlvnsdbksdjfb");

		// Category category = new Category();

		// List<String> categoryList = null;
		// categoryList = Arrays.asList("goo", "g", "le");
		// category.setTagList(categoryList);

		// String str = categoryList.toString();
		// System.out.println(categoryList);
		// categoryList = null;

		// categoryList = Arrays.asList(str.replaceAll("\\[",
		// "").split("[\\[^(.*?)]*[, (.*?)]*\\]"));

		// System.out.println(categoryList);

		// regserv.postService(user, article, categoryList);

	}

}
