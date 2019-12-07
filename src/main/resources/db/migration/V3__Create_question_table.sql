CREATE TABLE `community`.`question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `gmt_create` bigint(255) NULL DEFAULT NULL,
  `gmt_modify` bigint(255) NULL DEFAULT NULL,
  `creator` int(11) NOT NULL,
  `comment_count` int(255) NULL DEFAULT 0,
  `view_count` int(255) NULL DEFAULT 0,
  `like_count` int(255) NULL DEFAULT 0,
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;