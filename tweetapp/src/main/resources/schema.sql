CREATE TABLE USER (ID IDENTITY PRIMARY KEY, FIRST_NAME VARCHAR(50),
 LAST_NAME VARCHAR(50), GENDER VARCHAR(20), DOB VARCHAR (50), EMAIL VARCHAR(100), PASSWORD VARCHAR(100));
 
CREATE TABLE TWEETS 
 ( ID IDENTITY PRIMARY KEY, USER_ID INT , TWEET  VARCHAR ( 200) ,  INSERT_DTS TIMESTAMP (6) DEFAULT SYSTIMESTAMP);
