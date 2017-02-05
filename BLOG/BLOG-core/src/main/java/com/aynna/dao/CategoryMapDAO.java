package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Article;
import com.aynna.model.Category;
import com.aynna.model.CategoryMap;
import com.aynna.util.ConnectionUtil;

public class CategoryMapDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	private static final Logger LOGGER = Logger.getLogger(CategoryMap.class.getName());
	
	public void save(CategoryMap object) {
		
		String sql = "INSERT INTO CATEGORY_MAP (ARTICLE_ID, CATEGORY_ID) VALUES (?,?)";
		Object[] params = { object.getArticle().getId(), object.getCategory().getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows INSERTED: " + rows);
		
	}
	
	public void updateCategoryId(CategoryMap object) {
		
		String sql = "UPDATE CATEGORY_MAP SET CATEGORY_ID = ? WHERE ID = ?";
		Object[] params = { object.getCategory().getId(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void updateArticleId(CategoryMap object) {
		
		String sql = "UPDATE CATEGORY_MAP SET ARTICLE_ID = ? WHERE ID = ?";
		Object[] params = { object.getArticle().getId(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void delete(int id) {
		
		String sql = "DELETE FROM CATEGORY_MAP WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows DELETED: " + rows);
		
	}
	
	public List<CategoryMap> list() {//Select All
		
		String sql = "SELECT , , ,  FROM TABLENAME";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});
		
	}
	
	static CategoryMap convert(ResultSet rs) throws SQLException {
		CategoryMap object = new CategoryMap();
		Article article = new Article();
		article.setId(rs.getLong("ARTICLE_ID"));
		Category category = new Category();
		category.setId(rs.getLong("CATEGORY_ID"));
		
		object.setId(rs.getLong("ID"));
		object.setArticle(article);
		object.setCategory(category);
		return object;
	}
}
