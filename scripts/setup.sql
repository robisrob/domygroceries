CREATE SCHEMA `domygroceries` DEFAULT CHARACTER SET utf8 ;

CREATE USER 'applicationuser'@'localhost' IDENTIFIED BY
'password';
GRANT ALL ON domygroceries.* TO 'applicationuser'@'localhost';

USE domygroceries;

CREATE TABLE `groceryitem` (
  `id` char(36) NOT NULL,
  `description` varchar(140) NOT NULL,
  `owner_id` char(36) NOT NULL,
  `creatiedatum` datetime NOT NULL,
  PRIMARY KEY (`id`)
)