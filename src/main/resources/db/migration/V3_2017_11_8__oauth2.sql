/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : workkits

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-11-08 14:33:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for check_in
-- ----------------------------
DROP TABLE IF EXISTS `check_in`;
CREATE TABLE `check_in` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `check_in_time` datetime DEFAULT NULL,
  `check_out_time` datetime DEFAULT NULL,
  `left_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check_in
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
    user_id INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(128) DEFAULT NULL,
    password VARCHAR(256) DEFAULT NULL,
    enabled INT(1) DEFAULT 1,
    PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO users (user_id, username, password, enabled) VALUES
	('1', 'peter@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 1),
	('2', 'john@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 1),
	('3', 'katie@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 1);


drop table if exists oauth_client_details;
drop table if exists oauth_access_token;
drop table if exists oauth_refresh_token;
drop table if exists oauth_code;

create table oauth_client_details (
  client_id VARCHAR(50) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256)
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token blob,
  authentication_id VARCHAR(256),
  authentication blob,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token blob,
  authentication blob
);

create table oauth_code (
  code VARCHAR(256),
  authentication blob
);

insert into oauth_client_details(client_id,resource_ids,client_secret,scope,authorized_grant_types,authorities)
values('client','sparklr','secret','read,write','authorization_code','ROLE_CLIENT');