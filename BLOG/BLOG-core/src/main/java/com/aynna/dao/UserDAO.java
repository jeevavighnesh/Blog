package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.User;
import com.aynna.util.ConnectionUtil;

public class UserDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

	public void save(User user) {

		String sql = "INSERT INTO USERS (NAME, EMAIL_ID, PASSWORD) values(?,?,?)";
		Object[] params = { user.getName(), user.getEmailId(), user.getPassword() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows INSERTED: " + rows);

	}

	public void updateName(User user) {

		String sql = "UPDATE USERS SET NAME = ? WHERE ID = ?";
		Object[] params = { user.getName(), user.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);
		
	}
	
	public void updateEmailId(User user) {

		String sql = "UPDATE USERS SET EMAIL_ID = ? WHERE ID = ?";
		Object[] params = { user.getEmailId(), user.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);

	}

	public void updatePassword(User user) {

		String sql = "UPDATE USERS SET PASSWORD = ? WHERE ID = ?";
		Object[] params = { user.getPassword(), user.getId() };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows UPDATED: " + rows);

	}
	
	public void delete(int id) {

		String sql = "DELETE FROM USERS WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		LOGGER.setLevel(Level.INFO);
		LOGGER.info("No of rows DELETED: " + rows);

	}
	
	public List<User> list() {//Select All

		String sql = "SELECT ID,NAME,EMAIL_ID,PASSWORD FROM USERS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});

	}
	
	static User convert(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setName(rs.getString("NAME"));
		user.setEmailId(rs.getString("EMAIL_ID"));
		user.setPassword(rs.getString("PASSWORD"));
		return user;
	}
	
	public Boolean find(String emailId) {//Select All

		String sql = "SELECT IFNULL((SELECT 1 FROM USERS WHERE EMAIL_ID = ?),FALSE) AS RESULT";
		Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params,(rs, rowNum) -> {
			return rs.getBoolean("RESULT");
		});

	}
}
