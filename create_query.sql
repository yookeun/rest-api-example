CREATE DATABASE  TEST_DB;

use TEST_DB;


CREATE TABLE test_user
(
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(70) NOT NULL,
  isadmin CHAR(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY(id),
  UNIQUE KEY(username)
);

INSERT INTO test_user (username, password, isadmin) VALUES('admin', 'admin', 'Y');
INSERT INTO test_user (username, password, isadmin) VALUES('test', 'test', 'N');



CREATE TABLE test_board
(
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  content TEXT NOT NULL,
  PRIMARY KEY(id)
)

INSERT INTO test_board(title, content) VALUES('테스트 제목입니다.', '테스트 내용입니다');