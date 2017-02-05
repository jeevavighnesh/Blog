package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Article;
import com.aynna.model.User;
import com.aynna.util.ConnectionUtil;

public class ArticleDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	private static final Logger LOGGER = Logger.getLogger(ArticleDAO.class.getName());
	
	public void save(Article object) {
		
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
	
	public List<Article> list() {//Select All
		
		String sql = "SELECT ID, USER_ID, TITLE, CONTENT, CREATION_DATE, UPDATED_DATE, ACTIVE  FROM ARTICLES";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});
		
	}
	
	static Article convert(ResultSet rs) throws SQLException {
		Article object = new Article();
		User user = new User();
		user.setId(rs.getLong("USER_ID"));
		object.setId(rs.getLong("ID"));
		object.setTitle(rs.getString("TITLE"));
		object.setContent(rs.getString("CONTENT"));
		object.setCreationTimestamp(rs.getTimestamp("CREATION_DATE").toLocalDateTime());
		object.setUpdatedTimestamp(rs.getTimestamp("UPDATED_DATE").toLocalDateTime());
		object.setActive(rs.getBoolean("ACTIVE"));
		object.setUser(user);
		return object;
	}
}
