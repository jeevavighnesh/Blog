package com.aynna.model;

import java.util.List;

import lombok.Data;

@Data
public class Category {
	long id;
	User user;
	List<String> tagList;
}
