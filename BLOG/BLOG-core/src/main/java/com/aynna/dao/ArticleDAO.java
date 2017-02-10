package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.exception.PersistenceException;
import com.aynna.model.Article;
import com.aynna.model.Category;
import com.aynna.model.CategoryMap;
import com.aynna.model.User;
import com.aynna.util.ConnectionUtil;

public class ArticleDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	private static final Logger LOGGER = Logger.getLogger(ArticleDAO.class.getName());
	
	public void save(Article object) {
		
		System.out.println(object.getUser().getId());
		object.setUpdatedTimestamp(LocalDateTime.now());
		String sql = "INSERT INTO ARTICLES (USER_ID, TITLE, CONTENT, CREATION_DATE) VALUES (?,?,?,?)";
		Object[] params = { object.getUser().getId(), object.getTitle(), object.getContent(), LocalDateTime.now()};
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows INSERTED: " + rows);
		
	}
	
	public void updateTitle(Article object) {
		
		String sql = "UPDATE ARTICLES SET TITLE = ? WHERE ID = ?";
		Object[] params = { object.getTitle(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void updateContent(Article object) {
		
		String sql = "UPDATE ARTICLES SET CONTENT = ? WHERE ID = ?";
		Object[] params = { object.getContent(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void delete(int id) {
		
		String sql = "DELETE FROM ARTICLES WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows DELETED: " + rows);
		
	}
	
	public List<Article> list() throws PersistenceException {//Select All
		
		String sql = "SELECT TITLE, CONTENT, UPDATED_DATE AS 'LAST UPDATED', USERS.NAME AS AUTHOR FROM ARTICLES JOIN USERS WHERE USERS.ID = ARTICLES.USER_ID";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			try {
			return convert(rs);
			}
			catch(SQLException e) {
				throw new PersistenceException("No articles available", e);
			}
		});
		
	}
	
	static Article convert(ResultSet rs) throws SQLException {
		Article object = new Article();
		User user = new User();
		user.setName(rs.getString("AUTHOR"));
		object.setTitle(rs.getString("TITLE"));
		object.setContent(rs.getString("CONTENT"));
		object.setUpdatedTimestamp(rs.getTimestamp("LAST UPDATED").toLocalDateTime());
		object.setUser(user);
		return object;
	}
	
	public Integer lastIdFromArticles() throws PersistenceException{
		
		String sql = "SELECT MAX(ID) AS ID FROM ARTICLES";
		Integer id = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			
			return rs.getInt("ID");
					
		});
		if(id == null) {
			throw new PersistenceException("There Is no DATA INserted into the articles");
		}
		else return id;
		
	}
	
	public List<CategoryMap> articleCategoryJoinForArticleId(long articleId) {

		String sql = "SELECT ARTICLES.ID AS ARTICLE_ID, CATEGORY.ID AS CATEGORY_ID FROM CATEGORY JOIN ARTICLES WHERE ARTICLES.USER_ID = CATEGORY.USER_ID AND ARTICLES.ID = ?";
		Object[] params = { articleId };
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
			return convertjoin(rs);
		});

	}
	
	static CategoryMap convertjoin(ResultSet rs) throws SQLException {

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
