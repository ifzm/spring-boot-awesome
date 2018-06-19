CREATE TABLE IF NOT EXISTS `USER` (
  `id` VARCHAR(32) NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO USER(id, username, email) VALUES ('1', 'ifzm', '214123975@qq.com');
INSERT INTO USER(id, username, email) VALUES ('2', 'iguoguo', 'devfzm@gmail.com');