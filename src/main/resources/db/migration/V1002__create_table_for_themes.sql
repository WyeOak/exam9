use `forum`;

CREATE TABLE `themes` (
                         `id` INT auto_increment NOT NULL,
                         `title` varchar(225) NOT NULL,
                         `text` varchar(500) NOT NULL,
                         `user_id` INT NOT NULL,
                         `theme_ldt` DATETIME NOT NULL,
                         PRIMARY KEY (`id`),
                         CONSTRAINT `fk_theme_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);