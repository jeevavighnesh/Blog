SELECT NOW();

SELECT ARTICLES.ID, CATEGORY.ID
FROM CATEGORY
JOIN ARTICLES
WHERE
ARTICLES.USER_ID = CATEGORY.USER_ID
AND
ARTICLES.ID = 7;

SELECT IFNULL((SELECT 1 FROM USERS WHERE EMAIL_ID = "jeevavignesh@gmail.com" AND PASSWORD = "qweasdzx1qaz2wsx3edc"),0)