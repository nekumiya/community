-- CREATE TABLE USER
-- (
--     ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     ACCOUNT_ID VARCHAR(100),
--     NAME VARCHAR(50),
--     TOKEN VARCHAR(36),
--     GMT_CREATE BIGINT,
--     GMT_MODIFIED BIGINT,
-- );
--

CREATE TABLE `community`.`Untitled`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` bigint(255) NULL DEFAULT NULL,
  `gmt_modified` bigint(255) NULL DEFAULT NULL,
  `bio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;