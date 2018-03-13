create user court identified by 'qaz123';
grant all privileges on *.* to 'court'@'%'identified by 'qaz123' with grant option;
flush privileges;
create database court DEFAULT CHARSET utf8 COLLATE utf8_general_ci;


/*用户表*/
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `judge_grade` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `sub_department` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT 1,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


