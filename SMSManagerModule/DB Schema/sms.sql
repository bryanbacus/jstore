# SQL Manager 2007 for MySQL 4.1.2.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : sms


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `sms`;

CREATE DATABASE `sms`
    CHARACTER SET 'big5'
    COLLATE 'big5_chinese_ci';

USE `sms`;

#
# Structure for the `sm_tb_vip_account` table : 
#

DROP TABLE IF EXISTS `sm_tb_vip_account`;

CREATE TABLE `sm_tb_vip_account` (
  `user_id` int(11) NOT NULL,
  `vip_cht_name` varchar(50) NOT NULL default '',
  `vip_eng_name` varchar(50) NOT NULL,
  `birthday` datetime default NULL,
  `sex` varchar(10) default NULL,
  `blood` varchar(10) default NULL,
  `marrage` varchar(10) default NULL,
  `address` varchar(100) default NULL,
  `phone` varchar(20) default NULL,
  `mobile` varchar(20) default NULL,
  `mail_addr` varchar(100) NOT NULL,
  `fovarite` varchar(200) default NULL,
  `job` varchar(100) default NULL,
  `cr_date` datetime NOT NULL,
  `buy_sum` decimal(22,0) NOT NULL,
  `is_valid_vip` char(1) NOT NULL default 'N',
  `is_account_active` char(1) NOT NULL default 'Y',
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `error_cnt` int(2) default NULL,
  `owner` int(11) default NULL COMMENT 'The group of user',
  `sid` varchar(10) default NULL,
  `store` varchar(50) default NULL,
  `store_employee_name` varchar(50) default NULL,
  `vip_level` varchar(5) default NULL,
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `username_2` (`username`),
  KEY `owner` (`owner`),
  KEY `username` (`username`),
  CONSTRAINT `sm_tb_vip_account_fk` FOREIGN KEY (`owner`) REFERENCES `sm_tb_vip_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_account_group` table : 
#

DROP TABLE IF EXISTS `sm_tb_account_group`;

CREATE TABLE `sm_tb_account_group` (
  `idx` int(11) NOT NULL auto_increment,
  `role_type` varchar(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `description` varchar(200) default NULL,
  PRIMARY KEY  (`idx`),
  UNIQUE KEY `user_id` (`user_id`),
  KEY `sm_tb_account_group_fk` (`user_id`),
  CONSTRAINT `sm_tb_account_group_fk` FOREIGN KEY (`user_id`) REFERENCES `sm_tb_vip_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5 COMMENT='For user role distination';

#
# Structure for the `sm_tb_account_prepay` table : 
#

DROP TABLE IF EXISTS `sm_tb_account_prepay`;

CREATE TABLE `sm_tb_account_prepay` (
  `index` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL COMMENT 'The payed user id.',
  `prepayed` int(11) NOT NULL COMMENT 'The payed money',
  `create_date` datetime default NULL COMMENT 'The record create date',
  `create_user` int(11) NOT NULL COMMENT 'The record create user',
  `modify_date` datetime default NULL COMMENT 'The record modify date',
  `modify_user` int(11) default NULL COMMENT 'The record modify user',
  PRIMARY KEY  (`index`),
  KEY `user_id` (`user_id`),
  KEY `create_user` (`create_user`),
  KEY `modify_user` (`modify_user`),
  CONSTRAINT `sm_tb_account_pay_fk` FOREIGN KEY (`user_id`) REFERENCES `sm_tb_vip_account` (`user_id`),
  CONSTRAINT `sm_tb_account_pay_fk1` FOREIGN KEY (`create_user`) REFERENCES `sm_tb_vip_account` (`user_id`),
  CONSTRAINT `sm_tb_account_pay_fk2` FOREIGN KEY (`modify_user`) REFERENCES `sm_tb_vip_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_flower_intor` table : 
#

DROP TABLE IF EXISTS `sm_tb_flower_intor`;

CREATE TABLE `sm_tb_flower_intor` (
  `item_seq` int(11) NOT NULL auto_increment,
  `title` varchar(50) default NULL,
  `item_character` varchar(50) default NULL,
  `usages` varchar(50) default NULL,
  `description` varchar(500) default NULL,
  `item_pics` varchar(200) default NULL,
  `is_show` varchar(10) default NULL,
  PRIMARY KEY  (`item_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_holiday_configure` table : 
#

DROP TABLE IF EXISTS `sm_tb_holiday_configure`;

CREATE TABLE `sm_tb_holiday_configure` (
  `idx` int(11) NOT NULL,
  `holiday_name` varchar(20) default NULL,
  `holiday_cht_name` varchar(20) default NULL,
  `holiday_description` varchar(400) default NULL,
  `holiday_date` date default NULL,
  `is_enable` tinyint(1) default NULL,
  PRIMARY KEY  (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_message_context` table : 
#

DROP TABLE IF EXISTS `sm_tb_message_context`;

CREATE TABLE `sm_tb_message_context` (
  `sms_id` int(11) NOT NULL auto_increment,
  `sms_title` varchar(100) NOT NULL,
  `sms_context` varchar(400) NOT NULL,
  `create_date` datetime default NULL,
  `create_user_id` int(11) default NULL,
  PRIMARY KEY  (`sms_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_message_queue` table : 
#

DROP TABLE IF EXISTS `sm_tb_message_queue`;

CREATE TABLE `sm_tb_message_queue` (
  `idx` int(11) NOT NULL auto_increment,
  `recipient_id` int(11) default NULL,
  `mobile` varchar(20) NOT NULL,
  `sms_id` int(11) default NULL,
  `create_user_id` int(11) default NULL,
  `create_date` datetime NOT NULL,
  `send_date` datetime default NULL,
  `status` varchar(20) NOT NULL COMMENT 'I: initail; P: processing; S: success; X: cancel',
  PRIMARY KEY  (`idx`),
  KEY `sms_id` (`sms_id`),
  CONSTRAINT `sm_tb_message_queue_fk` FOREIGN KEY (`sms_id`) REFERENCES `sm_tb_message_context` (`sms_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_message_log` table : 
#

DROP TABLE IF EXISTS `sm_tb_message_log`;

CREATE TABLE `sm_tb_message_log` (
  `idx` int(11) NOT NULL auto_increment,
  `msg_idx` int(11) default NULL,
  `log` varchar(400) default NULL,
  `create_user_id` int(11) default NULL,
  `create_user_name` varchar(20) default NULL,
  `create_date` datetime default NULL,
  PRIMARY KEY  (`idx`),
  KEY `msg_idx` (`msg_idx`),
  CONSTRAINT `sm_tb_message_log_fk` FOREIGN KEY (`msg_idx`) REFERENCES `sm_tb_message_queue` (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_product_group` table : 
#

DROP TABLE IF EXISTS `sm_tb_product_group`;

CREATE TABLE `sm_tb_product_group` (
  `prd_group_id` int(11) NOT NULL auto_increment COMMENT '....',
  `prd_group_name` varchar(50) default NULL,
  `prd_group_desc` varchar(150) default NULL,
  `prd_group_discount` float default NULL,
  `type_status` varchar(2) default NULL COMMENT '....',
  `owner` int(11) default NULL COMMENT 'For group by manager',
  PRIMARY KEY  (`prd_group_id`),
  KEY `owner` (`owner`),
  CONSTRAINT `sm_tb_product_grp_fk` FOREIGN KEY (`owner`) REFERENCES `sm_tb_vip_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_product` table : 
#

DROP TABLE IF EXISTS `sm_tb_product`;

CREATE TABLE `sm_tb_product` (
  `prd_id` int(11) NOT NULL auto_increment,
  `prd_group_id` int(11) NOT NULL,
  `name` varchar(50) default NULL,
  `price` decimal(22,0) default NULL,
  `price_vip` decimal(22,0) default NULL,
  `suply_status` varchar(2) NOT NULL default '',
  `format_desc` varchar(150) default NULL,
  `detail_desc` varchar(200) default NULL,
  `send_area` varchar(50) default NULL,
  `send_desc` varchar(200) default NULL,
  `prd_pic_file` varchar(200) default NULL,
  `owner` int(11) default NULL,
  PRIMARY KEY  (`prd_id`),
  KEY `prd_group_id` (`prd_group_id`),
  KEY `owner` (`owner`),
  CONSTRAINT `sm_tb_product_fk` FOREIGN KEY (`prd_group_id`) REFERENCES `sm_tb_product_group` (`prd_group_id`),
  CONSTRAINT `sm_tb_product_fk1` FOREIGN KEY (`owner`) REFERENCES `sm_tb_vip_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_sale_record` table : 
#

DROP TABLE IF EXISTS `sm_tb_sale_record`;

CREATE TABLE `sm_tb_sale_record` (
  `sale_seq` int(11) NOT NULL auto_increment,
  `sale_total` decimal(22,0) default NULL,
  `sale_date` datetime default NULL,
  `vip_id` int(11) default NULL,
  `sales_id` int(11) default NULL,
  PRIMARY KEY  (`sale_seq`),
  KEY `vip_id` (`vip_id`),
  KEY `sales_id` (`sales_id`),
  CONSTRAINT `sm_tb_sale_record_fk` FOREIGN KEY (`vip_id`) REFERENCES `sm_tb_vip_account` (`user_id`),
  CONSTRAINT `sm_tb_sale_record_fk1` FOREIGN KEY (`sales_id`) REFERENCES `sm_tb_vip_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5 COMMENT='InnoDB free: 17408 kB\r\nFor Sales sale record. When sales sal';

#
# Structure for the `sm_tb_sale_item` table : 
#

DROP TABLE IF EXISTS `sm_tb_sale_item`;

CREATE TABLE `sm_tb_sale_item` (
  `item_seq` int(11) NOT NULL auto_increment,
  `prd_id` int(11) NOT NULL,
  `count` decimal(22,0) NOT NULL,
  `prd_unit_price` decimal(22,0) default NULL,
  `prd_discount_price` decimal(22,0) default NULL,
  `vip_id` int(11) default NULL,
  `sale_id` int(11) default NULL,
  `cr_date` datetime default NULL,
  `sale_seq` int(11) NOT NULL,
  `is_close` char(2) default NULL,
  `upd_date` datetime default NULL,
  `log` varchar(200) default NULL,
  PRIMARY KEY  (`item_seq`),
  KEY `prd_id` (`prd_id`),
  KEY `sale_id` (`sale_id`),
  KEY `vip_id` (`vip_id`),
  KEY `sale_seq` (`sale_seq`),
  CONSTRAINT `sm_tb_sale_item_fk` FOREIGN KEY (`prd_id`) REFERENCES `sm_tb_product` (`prd_id`),
  CONSTRAINT `sm_tb_sale_item_fk1` FOREIGN KEY (`sale_id`) REFERENCES `sm_tb_vip_account` (`user_id`),
  CONSTRAINT `sm_tb_sale_item_fk2` FOREIGN KEY (`vip_id`) REFERENCES `sm_tb_vip_account` (`user_id`),
  CONSTRAINT `sm_tb_sale_item_fk3` FOREIGN KEY (`sale_seq`) REFERENCES `sm_tb_sale_record` (`sale_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_sql_rule` table : 
#

DROP TABLE IF EXISTS `sm_tb_sql_rule`;

CREATE TABLE `sm_tb_sql_rule` (
  `idx` int(11) NOT NULL auto_increment,
  `rule_module` varchar(20) default NULL,
  `rule_name` varchar(20) default NULL,
  `rule_idx` int(11) NOT NULL,
  `rule_sql` varchar(4000) NOT NULL,
  `rule_description` varchar(200) default NULL,
  `is_transaction` tinyint(1) default NULL,
  `next_rule_idx` int(11) default NULL,
  PRIMARY KEY  (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_vip_account_detail` table : 
#

DROP TABLE IF EXISTS `sm_tb_vip_account_detail`;

CREATE TABLE `sm_tb_vip_account_detail` (
  `idx` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `vip_child_name` varchar(20) NOT NULL,
  `vip_child_birthday` date NOT NULL,
  `vip_child_sex` char(5) default NULL,
  PRIMARY KEY  (`idx`),
  UNIQUE KEY `userId_vipChildName` (`user_id`,`vip_child_name`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `sm_tb_vip_account_detail_fk` FOREIGN KEY (`user_id`) REFERENCES `sm_tb_vip_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_vip_account_detail_his` table : 
#

DROP TABLE IF EXISTS `sm_tb_vip_account_detail_his`;

CREATE TABLE `sm_tb_vip_account_detail_his` (
  `idx` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `vip_child_name` varchar(20) NOT NULL,
  `vip_child_birthday` date NOT NULL,
  `vip_child_sex` char(5) default NULL,
  PRIMARY KEY  (`idx`),
  UNIQUE KEY `userId_vipChildName` (`user_id`,`vip_child_name`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sm_tb_week_discount` table : 
#

DROP TABLE IF EXISTS `sm_tb_week_discount`;

CREATE TABLE `sm_tb_week_discount` (
  `dis_seq` int(11) NOT NULL auto_increment,
  `prd_id` int(11) default NULL,
  `dis_price` decimal(22,0) default NULL,
  `prd_total` decimal(22,0) default NULL,
  `prd_current_total` decimal(22,0) default NULL,
  `start_date` datetime default NULL,
  `end_date` datetime default NULL,
  PRIMARY KEY  (`dis_seq`),
  KEY `prd_id` (`prd_id`),
  CONSTRAINT `sm_tb_week_discount_fk` FOREIGN KEY (`prd_id`) REFERENCES `sm_tb_product` (`prd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;

#
# Structure for the `sys_tb_properties` table : 
#

DROP TABLE IF EXISTS `sys_tb_properties`;

CREATE TABLE `sys_tb_properties` (
  `idx` int(11) NOT NULL auto_increment,
  `key_name` varchar(50) NOT NULL,
  `key_value` varchar(200) default NULL,
  `key_group` varchar(20) default NULL,
  `description` varchar(200) default NULL,
  `modify_date` date default NULL,
  PRIMARY KEY  (`idx`),
  UNIQUE KEY `key_name` (`key_name`,`key_group`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;