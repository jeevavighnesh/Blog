package com.aynna.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aynna.dao.ArticleDAO;
import com.aynna.dao.CategoryDAO;
import com.aynna.dao.CategoryMapDAO;
import com.aynna.dao.JoinsDAO;
import com.aynna.dao.UserDAO;
import com.aynna.exception.ServiceException;
import com.aynna.exception.ValidatorException;
import com.aynna.model.Article;
import com.aynna.model.Category;
import com.aynna.model.CategoryMap;
import com.aynna.model.User;
import com.aynna.validator.LoginValidator;
import com.aynna.validator.PostValidator;
import com.aynna.validator.RegisterValidator;

public class UserService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
	public void registerService(User user) throws ServiceException{
		
		UserDAO userDao = new UserDAO();
		
		RegisterValidator regval = new RegisterValidator();
		
		try {

			regval.registerValidator(user);
			userDao.save(user);

		} catch (ValidatorException e) {

			throw new ServiceException("!!!!Could not Add the new user!!!!",e);
			
		}

	}
	
	public void login(User user) throws ServiceException {
		
		LoginValidator loginValidator = new LoginValidator();
		try {
			
			loginValidator.loginValidator(user);
			LOGGER.setLevel(Level.INFO);
			LOGGER.info("Loged In SUCESSFULLY :-)\nWELCOME");
			
		} catch (ValidatorException e) {
			
			throw new ServiceException("!!!!Could Not Log You in!!!!",e);
			
		}
		
	}
	
	public void postService (User user, Article article, List<String> categoryList) throws ServiceException{
		
		ArticleDAO articleDao = new ArticleDAO();
		
		article.setUser(user);
		
		UserDAO userDao = new UserDAO();
		CategoryDAO categoryDao = new CategoryDAO();
		
		user.setId(userDao.resolveEmailId(user.getEmailId()));
		article.setUser(user);
		
		Category category = new Category();
		
		JoinsDAO joinsDao = new JoinsDAO();
		
		CategoryMapDAO categoryMapDAO = new CategoryMapDAO();
		
		PostValidator postvalid = new PostValidator();
		try {
			
			postvalid.validPost(user,article,categoryList);
			category.setTagList(categoryList);
			category.setUser(user);
			articleDao.save(article);			
			categoryDao.save(category);
			List<CategoryMap> articleCategoryJoin = joinsDao.articleCategoryJoinForArticleId(article.getId());
			for (CategoryMap categoryMap : articleCategoryJoin) {
				categoryMapDAO.save(categoryMap);
			}
			
		} catch (ValidatorException e) {
				
			throw new ServiceException("Could not Post the Provided Content", e);
			
		}
		
	}
}
