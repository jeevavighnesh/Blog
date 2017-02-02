package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Article;
import com.aynna.model.Ratting;
import com.aynna.model.User;
import com.aynna.util.ConnectionUtil;

public class RattingDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	private static final Logger LOGGER = Logger.getLogger(RattingDAO.class.getName());
	
	public void save(Ratting object) {
		
		String sql = "INSERT INTO RATTINGS (USER_ID, ARTICLE_ID, RATTING) VALUES (?,?,?)";
		Object[] params = { object.getUser().getId(), object.getArticle().getId(), object.getRattings() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows INSERTED: " + rows);
		
	}
	
	public void updateArticleId(Ratting object) {
		
		String sql = "UPDATE RATTINGS SET ARTICLE_ID = ? WHERE ID = ?";
		Object[] params = { object.getArticle().getId(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void updateUserId(Ratting object) {
		
		String sql = "UPDATE RATTINGS SET USER_ID = ? WHERE ID = ?";
		Object[] params = { object.getUser().getId(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void updateRattings(Ratting object) {
		
		String sql = "UPDATE RATTINGS SET RATTING = ? WHERE ID = ?";
		Object[] params = { object.getRattings(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void delete(int id) {
		
		String sql = "DELETE FROM RATTINGS WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows DELETED: " + rows);
		
	}
	
	public List<Ratting> list() {//Select All
		
		String sql = "SELECT ID, USER_ID, ARTICLE_ID, RATTING FROM RATTINGS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});
		
	}
	
	static Ratting convert(ResultSet rs) throws SQLException {
		Ratting object = new Ratting();
		User user = new User();
		user.setId(rs.getLong("USER_ID"));
		Article article = new Article();
		article.setId(rs.getLong("ARTICLE_ID"));
		object.setId(rs.getInt("ID"));
		object.setUser(user);
		object.setArticle(article);
		object.setRattings(rs.getInt("RATTING"));
		return object;
	}
}
