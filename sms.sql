CREATE TABLE `stu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `class` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `num` (`num`)
)