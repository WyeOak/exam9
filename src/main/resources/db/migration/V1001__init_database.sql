use `forum`;


CREATE TABLE `Users` (
                       `id` INT auto_increment NOT NULL,
                       `first_name` varchar(128) NOT NULL,
                       `last_name` varchar(128) NOT NULL,
                       `username` varchar(40) NOT NULL,
                       `password` varchar(128) NOT NULL,
                       `enabled` tinyint NOT NULL,
                       `role` varchar(30) NOT NULL,
                       PRIMARY KEY (`id`)
);