-- create table users (
--                        user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
--                        email VARCHAR(255) NOT NULL,
--                        name VARCHAR(30) NOT NULL,
--                        password VARCHAR(255) NOT NULL,
--                        phone VARCHAR(20) NOT NULL,
--                        role VARCHAR(10) NOT NULL,
--                        created_at DATETIME,
--                        modified_at DATETIME,
--                        UNIQUE INDEX ux_email (email)
-- ) engine=InnoDB default character set = utf8;