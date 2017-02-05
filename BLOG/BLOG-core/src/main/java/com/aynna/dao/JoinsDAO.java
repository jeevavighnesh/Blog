package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Article;
import com.aynna.model.Category;
import com.aynna.model.CategoryMap;
import com.aynna.util.ConnectionUtil;

public class JoinsDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public List<CategoryMap> articleCategoryJoinForArticleId(long articleId) {

		String sql = "SELECT ARTICLES.ID AS ARTICLE_ID, CATEGORY.ID AS CATEGORY_ID FROM CATEGORY JOIN ARTICLES WHERE ARTICLES.USER_ID = CATEGORY.USER_ID AND ARTICLES.ID = ?";
		Object[] params = { articleId };
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
			return convert(rs);
		});

	}

	static CategoryMap convert(ResultSet rs) throws SQLException {

		CategoryMap categoryMap = new CategoryMap();
		Article article = new Article();
		Category category = new Category();
		article.setId(rs.getLong("ARTICLE_ID"));
		category.setId(rs.getLong("CATEGORY_ID"));
		categoryMap.setArticle(article);
		categoryMap.setCategory(category);
		return categoryMap;

	}
}
