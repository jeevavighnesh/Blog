package com.aynna.test;

import com.aynna.dao.UserDAO;

public class TestUserDAO {
	
	public static void main(String[] args) {
		
		UserDAO udao = new UserDAO();
		System.out.println(udao.find("jeevavignesh@gmai.com"));
		
	}

}
