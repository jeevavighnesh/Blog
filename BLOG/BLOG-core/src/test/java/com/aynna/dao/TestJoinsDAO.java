package com.aynna.dao;

public class TestJoinsDAO {
	public static void main(String[] args) {
		
		JoinsDAO joinsDao = new JoinsDAO();
		System.out.println(joinsDao.articleCategoryJoinForArticleId(7L));
		
	}

}
