USE
    test;
SET NAMES utf8mb4;
SET
    FOREIGN_KEY_CHECKS = 0;
-- 稿件
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `orders0`;
CREATE TABLE `orders0`
(
    `id`          bigint NOT NULL,
    `item_name`   varchar(255)  DEFAULT NULL,
    `price`       double(10, 2) DEFAULT NULL,
    `user_id`     bigint        DEFAULT NULL,
    `create_time` datetime      DEFAULT NULL,
    `modify_time` datetime      DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
SET
    FOREIGN_KEY_CHECKS = 1;
DROP TABLE IF EXISTS `orders1`;
CREATE TABLE `orders1` LIKE `orders0`;
DROP TABLE IF EXISTS `orders2`;
CREATE TABLE `orders2` LIKE `orders0`;
DROP TABLE IF EXISTS `orders3`;
CREATE TABLE `orders3` LIKE `orders0`;
DROP TABLE IF EXISTS `orders4`;
CREATE TABLE `orders4` LIKE `orders0`;
DROP TABLE IF EXISTS `orders5`;
CREATE TABLE `orders5` LIKE `orders0`;
DROP TABLE IF EXISTS `orders6`;
CREATE TABLE `orders6` LIKE `orders0`;
DROP TABLE IF EXISTS `orders7`;
CREATE TABLE `orders7` LIKE `orders0`;
DROP TABLE IF EXISTS `orders8`;
CREATE TABLE `orders8` LIKE `orders0`;
DROP TABLE IF EXISTS `orders9`;
CREATE TABLE `orders9` LIKE `orders0`;
DROP VIEW IF EXISTS `orders`;
CREATE VIEW `orders` AS
SELECT *
FROM `orders0`
UNION ALL
SELECT *
FROM `orders1`
UNION ALL
SELECT *
FROM `orders2`
UNION ALL
SELECT *
FROM `orders3`
UNION ALL
SELECT *
FROM `orders4`
UNION ALL
SELECT *
FROM `orders5`
UNION ALL
SELECT *
FROM `orders6`
UNION ALL
SELECT *
FROM `orders7`
UNION ALL
SELECT *
FROM `orders8`
UNION ALL
SELECT *
FROM `orders9`;