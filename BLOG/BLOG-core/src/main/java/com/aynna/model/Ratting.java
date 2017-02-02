package com.aynna.model;

import lombok.Data;

@Data
public class Ratting {

	long id;
	User user;
	Article article;
	int rattings;

}
