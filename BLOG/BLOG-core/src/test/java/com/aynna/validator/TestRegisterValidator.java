package com.aynna.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aynna.exception.ValidatorException;

public class TestRegisterValidator {
	public static void main(String[] args) throws ValidatorException {
//		User user = new User();
//		user.setName("");
//		user.setEmailId("jeevavigneshgmailcom".trim());
//		user.setPassword("quarkkki");
//		RegisterValidator regvalid = new RegisterValidator();
//		regvalid.registerValidator(user);

		      // String to be scanned to find the pattern.
		      String line = "jeevavignesh@gmail.com";
		      String pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

		      // Create a Pattern object
		      Pattern r = Pattern.compile(pattern);

		      // Now create matcher object.
		      Matcher m = r.matcher(line);
		      if (m.find( )) {
		         System.out.println("Found value: " + m.group(0) );
		         System.out.println("Found value: " + m.group(1) );
		         System.out.println("Found value: " + m.group(2) );
		      }else {
		         System.out.println("NO MATCH");
		      }
		   
		
	}

}
