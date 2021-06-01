USE
    test;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- 稿件
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `user0`;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
CREATE TABLE `user0`
(
    `id`     bigint NOT NULL,
    `name`   varchar(255) DEFAULT NULL,
    `age`    int          DEFAULT NULL,
    `gender` int          DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
DROP TABLE IF EXISTS `user1`;
CREATE TABLE `user1` LIKE `user0`;
DROP TABLE IF EXISTS `user2`;
CREATE TABLE `user2` LIKE `user0`;
DROP TABLE IF EXISTS `user3`;
CREATE TABLE `user3` LIKE `user0`;
DROP TABLE IF EXISTS `user4`;
CREATE TABLE `user4` LIKE `user0`;
DROP TABLE IF EXISTS `user5`;
CREATE TABLE `user5` LIKE `user0`;
DROP TABLE IF EXISTS `user6`;
CREATE TABLE `user6` LIKE `user0`;
DROP TABLE IF EXISTS `user7`;
CREATE TABLE `user7` LIKE `user0`;
DROP TABLE IF EXISTS `user8`;
CREATE TABLE `user8` LIKE `user0`;
DROP TABLE IF EXISTS `user9`;
CREATE TABLE `user9` LIKE `user0`;
DROP VIEW IF EXISTS `user`;
CREATE VIEW `user` AS
SELECT *
FROM `user0`
UNION ALL
SELECT *
FROM `user1`
UNION ALL
SELECT *
FROM `user2`
UNION ALL
SELECT *
FROM `user3`
UNION ALL
SELECT *
FROM `user4`
UNION ALL
SELECT *
FROM `user5`
UNION ALL
SELECT *
FROM `user6`
UNION ALL
SELECT *
FROM `user7`
UNION ALL
SELECT *
FROM `user8`
UNION ALL
SELECT *
FROM `user9`;