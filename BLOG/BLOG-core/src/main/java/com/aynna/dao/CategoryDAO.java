package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Category;
import com.aynna.model.User;
import com.aynna.util.ConnectionUtil;

public class CategoryDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	private static final Logger LOGGER = Logger.getLogger(CategoryDAO.class.getName());
	
	public void save(Category object) {
		
		String sql = "INSERT INTO TABLENAME (USERID, NAME) VALUES (?,?)";
		Object[] params = { object.getUser().getId(), object.getName()};
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows INSERTED: " + rows);
		
	}
	
	public void updateCategory(Category object) {
		
		String sql = "UPDATE CATEGORY SET NAME = ? WHERE ID = ?";
		Object[] params = { object.getName(), object.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void delete(int id) {
		
		String sql = "DELETE FROM CATEGORY WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows DELETED: " + rows);
		
	}
	
	public List<Category> list() {//Select All
		
		String sql = "SELECT ID, USER_ID, NAME FROM CATEGORY";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});
		
	}
	
	static Category convert(ResultSet rs) throws SQLException {
		Category object = new Category();
		User user = new User();
		user.setId(rs.getLong("USER_ID"));
		object.setId(rs.getLong("ID"));
		object.setUser(user);
		object.setName(rs.getString(""));
		return object;
	}
}
