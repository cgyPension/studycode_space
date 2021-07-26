#创建user表
CREATE TABLE USER (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(32),
                      PASSWORD VARCHAR(32)
);
INSERT INTO USER VALUES(NULL,'zhangsan','123');
INSERT INTO USER VALUES(NULL,'lisi','123');
INSERT INTO USER VALUES(NULL,'wangwu','123');

