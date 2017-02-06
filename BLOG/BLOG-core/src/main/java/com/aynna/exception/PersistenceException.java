package com.aynna.exception;

import java.sql.SQLException;

public class PersistenceException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceException(String reason, Throwable cause) {
		super(reason, cause);
	}

	public PersistenceException(String reason) {
		super(reason);
	}

}
