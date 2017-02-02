package com.aynna.model;

import lombok.Data;

@Data
public class Category {
	long id;
	User user;
	String name;
}
