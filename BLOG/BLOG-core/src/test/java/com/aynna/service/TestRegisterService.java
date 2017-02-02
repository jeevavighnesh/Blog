package com.aynna.service;

import com.aynna.exception.ServiceException;

public class TestRegisterService {
	public static void main(String[] args) throws ServiceException {

		RegisterService regserv = new RegisterService();
		regserv.registerService("Vighnesh", "jeevavignesh@gmail.com", "qweasdzxc1qaz2wsx3edc");

	}

}
