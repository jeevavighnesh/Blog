package com.aynna.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Article {
	
	long id;
	User user;
	String title;
	String content;
	LocalDateTime creationDate;
	LocalDateTime updatedTime;
	boolean active;
	
}
