CREATE TABLE users
(
    user_id  INTEGER NOT NULL AUTO_INCREMENT,
    username varchar(45) NOT NULL,
    password varchar(64) NOT NULL,
    role     varchar(45) NOT NULL,
    enabled  INTEGER DEFAULT NULL,
    PRIMARY KEY (user_id)
);