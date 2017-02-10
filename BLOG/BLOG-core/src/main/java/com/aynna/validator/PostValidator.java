package com.aynna.validator;

import java.util.List;

import com.aynna.exception.ValidatorException;
import com.aynna.model.Article;
import com.aynna.model.User;
import com.aynna.util.GeneralValidations;

public class PostValidator {
	public void validPost(User user, Article article, List<String> categoryList) throws ValidatorException {

		GeneralValidations genval = new GeneralValidations();

		for (String c : categoryList) {

			genval.isValidField(c, "Category");
			
		}
		
		genval.isValidField(article.getContent(), "Content");
		genval.isValidField(article.getTitle(), "Title");

	}
}
