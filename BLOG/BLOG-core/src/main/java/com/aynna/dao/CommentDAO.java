package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Article;
import com.aynna.model.Comment;
import com.aynna.model.User;
import com.aynna.util.ConnectionUtil;

public class CommentDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	private static final Logger LOGGER = Logger.getLogger(Comment.class.getName());
	
	public void save(Comment object) {
		
		String sql = "INSERT INTO COMMENTS (ARTICLE_ID, USER_ID, COMMENTS) VALUES (?,?,?)";
		Object[] params = { object.getArticle().getId(), object.getUser().getId(), object.getComments() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows INSERTED: " + rows);
		
	}
	
	public void updateUserId(Comment object) {
		
		String sql = "UPDATE COMMENTS SET USER_ID = ? WHERE ID = ?";
		Object[] params = { object.getUser().getId(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void updateArticleId(Comment object) {
		
		String sql = "UPDATE COMMENTS SET ARTICLE_ID = ? WHERE ID = ?";
		Object[] params = { object.getArticle().getId(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void updateComments(Comment object) {
		
		String sql = "UPDATE COMMENTS SET COMMENTS = ? WHERE ID = ?";
		Object[] params = { object.getComments(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void delete(int id) {
		
		String sql = "DELETE FROM COMMENTS WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows DELETED: " + rows);
		
	}
	
	public List<Comment> list() {//Select All
		
		String sql = "SELECT , , ,  FROM TABLENAME";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});
		
	}
	
	static Comment convert(ResultSet rs) throws SQLException {
		Comment object = new Comment();
		Article article = new Article();
		article.setId(rs.getLong("ARTICLE_ID"));
		object.setId(rs.getLong("ID"));
		User user = new User();
		user.setId(rs.getLong("USER_ID"));
		object.setArticle(article);
		object.setUser(user);
		object.setComments(rs.getString("COMMENTS"));
		return object;
	}
	
}
