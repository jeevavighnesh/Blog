package com.aynna.util;

import com.aynna.exception.ValidatorException;

public class TestGeneralValidations {
	public static void main(String[] args) throws ValidatorException {
		
		GeneralValidations genVal = new GeneralValidations();
		String email = "jeevavignesh@gmail.com";
		genVal.isValidField(email);
		genVal.isAlreadyRegistered(email, "kkakak");
		System.out.println("Its valid all rite");
		
	}
}
