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
		
		object.setUpdatedTime(LocalDateTime.now());
		String sql = "INSERT INTO ARTICLE (USER_ID, TITLE, CONTENT, UPDATED_DATE) VALUES (?,?,?,?)";
		Object[] params = { object.getUser().getId(), object.getTitle(), object.getContent(), object.getUpdatedTime() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows INSERTED: " + rows);
		
	}
	
	public void updateTitle(Article object) {
		
		String sql = "UPDATE ARTICLE SET TITLE = ? WHERE ID = ?";
		Object[] params = { object.getTitle(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void updateContent(Article object) {
		
		String sql = "UPDATE ARTICLE SET CONTENT = ? WHERE ID = ?";
		Object[] params = { object.getContent(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void delete(int id) {
		
		String sql = "DELETE FROM ARTICLE WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows DELETED: " + rows);
		
	}
	
	public List<Article> list() {//Select All
		
		String sql = "SELECT , , ,  FROM TABLENAME";
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
		object.setUser(user);
		return object;
	}
}
