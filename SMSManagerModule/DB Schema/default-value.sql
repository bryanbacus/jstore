INSERT INTO `sm_tb_vip_account` 
	(`user_id`, `vip_cht_name`, `vip_eng_name`, `birthday`, `sex`, `blood`, `marrage`, `address`, `phone`, `mobile`, `mail_addr`, `fovarite`, `job`, `cr_date`, `buy_sum`, `is_valid_vip`, `is_account_active`, `username`, `password`, `error_cnt`, `owner`, `sid`, `store`, `store_employee_name`, `vip_level`) 
VALUES 
  (0, 'Administrator', 'Simon', '1978-08-01 00:28:23', 'M', NULL, NULL, '114臺北市內湖區成功路二段四號', '0953609275', '0953609275', 'simonsu.mail@gmail.com', NULL, 'Engineer', '2007-12-21 00:28:23', 0, 'Y', 'Y', 'admin', 'smsadmin', 0, 0, 'N123456789', '士林店', '', 'A');
  
  
INSERT INTO `sm_tb_account_group` 
	(`idx`, `role_type`, `user_id`, `description`) 
VALUES 
  (51, 'ADMIN', 0, '管理者');