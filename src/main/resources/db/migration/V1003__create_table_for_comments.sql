use `forum`;


CREATE TABLE `Comments` (
                          `id` INT auto_increment NOT NULL,
                          `text` varchar(255) NOT NULL,
                          `user_id` INT NOT NULL,
                          `theme_id` INT NOT NULL,
                          `comment_ldt` DATETIME NOT NULL,
                          PRIMARY KEY (`id`),
                          CONSTRAINT `fk_comment_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
                          CONSTRAINT `fk_comment_theme` FOREIGN KEY (`theme_id`) REFERENCES `themes` (`id`)
);