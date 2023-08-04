create database dbrouter_01;
create database dbrouter_02;

create table if not exists user_01
(
    `id`          bigint(0)    NOT NULL AUTO_INCREMENT,
    `user_id`     bigint(0)    NULL DEFAULT NULL,
    `nickname`    varchar(100) NULL DEFAULT '' COMMENT '昵称',
    `name`        varchar(100) NOT NULL COMMENT '账号',
    `age`         int(0)       NULL DEFAULT NULL,
    `password`    varchar(255) NULL DEFAULT NULL COMMENT '密码',
    `create_time` datetime(0)  NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime(0)  NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `idx_username` (`name`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1011
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci
    ROW_FORMAT = Dynamic;

create table if not exists user_02
(
    `id`          bigint(0)    NOT NULL AUTO_INCREMENT,
    `user_id`     bigint(0)    NULL DEFAULT NULL,
    `nickname`    varchar(100) NULL DEFAULT '' COMMENT '昵称',
    `name`        varchar(100) NOT NULL COMMENT '账号',
    `age`         int(0)       NULL DEFAULT NULL,
    `password`    varchar(255) NULL DEFAULT NULL COMMENT '密码',
    `create_time` datetime(0)  NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime(0)  NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `idx_username` (`name`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1011
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci
    ROW_FORMAT = Dynamic;

create table if not exists user_00
(
    `id`          bigint(0)    NOT NULL AUTO_INCREMENT,
    `user_id`     bigint(0)    NULL DEFAULT NULL,
    `nickname`    varchar(100) NULL DEFAULT '' COMMENT '昵称',
    `name`        varchar(100) NOT NULL COMMENT '账号',
    `age`         int(0)       NULL DEFAULT NULL,
    `password`    varchar(255) NULL DEFAULT NULL COMMENT '密码',
    `create_time` datetime(0)  NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime(0)  NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `idx_username` (`name`) USING BTREE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1011
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_general_ci
    ROW_FORMAT = Dynamic;
