DROP PROCEDURE IF EXISTS PR_REGISTER;
DELIMITER !
CREATE PROCEDURE PR_REGISTER (NAME_PARAM VARCHAR(30),EMAIL_ID_PARAM VARCHAR(50),PASSWORD_PARAM VARCHAR (50), OUT REGISTER_COMMENTS VARCHAR(1000))
BEGIN
	IF (SELECT FN_IS_VALID_NAME(NAME_PARAM)) AND (SELECT FN_IS_VALID_NAME(EMAIL_ID_PARAM)) AND (SELECT FN_IS_VALID_NAME(PASSWORD_PARAM))
	THEN
		IF NOT (SELECT FN_IS_ALREADY_REGISTERED(EMAIL_ID_PARAM))
		THEN
			START TRANSACTION;
			SET AUTOCOMMIT = FALSE;
				INSERT INTO USERS (NAME, EMAIL_ID, PASSWORD) VALUES (NAME_PARAM, UPPER(EMAIL_ID_PARAM), PASSWORD_PARAM);
			COMMIT;
			SET REGISTER_COMMENTS  = "REGISTRATION SUCCESS :-)";
		ELSE
			SET REGISTER_COMMENTS = "YOU'RE ALREADY REGISTERED TO US";
		END IF;
	ELSE
		SET REGISTER_COMMENTS = "PLEASE FILL ALL THE FEILDS TO PROCEED";
	END IF;
END !
DELIMITER ;

CALL  PR_REGISTER("VIKKI","","HOLA",@REGISTER_COMMENTS);
SELECT @REGISTER_COMMENTS;


DROP PROCEDURE IF EXISTS PR_POST_ARTICLE;
DELIMITER !
CREATE PROCEDURE PR_POST_ARTICLE ( EMAIL_ID_PARAM VARCHAR(50), TITLE_PARAM VARCHAR(100), CONTENT_PARAM TEXT, OUT POST_ARTICLE_COMMENTS VARCHAR(1000))
BEGIN
DECLARE THIS_USER_ID BIGINT UNSIGNED;
SET THIS_USER_ID=  (SELECT ID FROM USERS WHERE EMAIL_ID = EMAIL_ID_PARAM);
	IF ((SELECT FN_IS_VALID_NAME(TITLE_PARAM)) AND (SELECT FN_IS_VALID_NAME(CONTENT_PARAM)) AND (SELECT FN_IS_VALID_NAME(EMAIL_ID_PARAM)))
	THEN
		IF (SELECT FN_IS_ALREADY_REGISTERED(EMAIL_ID_PARAM))
		THEN
			START TRANSACTION;
			SET AUTOCOMMIT = FALSE;
				INSERT INTO ARTICLES (USER_ID, TITLE, CONTENT, UPDATED_DATE) VALUES (THIS_USER_ID, TITLE_PARAM, CONTENT_PARAM,NOW());
			COMMIT;
			SET POST_ARTICLE_COMMENTS  = "POSTED SUCCESSFULLY :-)";
		ELSE
			SET POST_ARTICLE_COMMENTS  = "!!!!wHO aRE u?!!!!uR nOT iN oUR cOMMUNITY!!!!";
		END IF;
	ELSE
		SET POST_ARTICLE_COMMENTS= "PLEASE FILL ALL THE FEILDS TO PROCEED";
	END IF;
END !
DELIMITER ;

CALL  PR_POST_ARTICLE("JEEVAVIGNEH@GMAIL.COM","THIS IS ME","HAI PPL THIS IS VIGHNESH YOU CAN ALL ALSO CALL ME AYNNA. HOW ARE YOU ALL?? iM MF AWESOME!!!!",@REGISTER_COMMENTS);
SELECT @REGISTER_COMMENTS;
