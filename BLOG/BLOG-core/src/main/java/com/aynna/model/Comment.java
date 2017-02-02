package com.aynna.model;

import lombok.Data;

@Data
public class Comment {
	long id;
	Article article;
	User user;
	String comments;
}
