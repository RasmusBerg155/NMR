CREATE DATABASE IF NOT EXISTS `nordic-motorhome`;

CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`motorhome_details` (
  `motorhome_detail_id` INT(5) UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `km` DECIMAL(7,1) UNSIGNED NULL DEFAULT NULL,
  `passengers` INT(2) UNSIGNED NULL DEFAULT NULL,
  `price_per_day` VARCHAR(10) NULL DEFAULT NULL,
  `extra` VARCHAR(150) NULL DEFAULT NULL);
  
  CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`motorhomes` (
  `motorhome_id` INT(5) UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `brand` VARCHAR(20) NULL DEFAULT NULL,
  `model` VARCHAR(20) NULL DEFAULT NULL,
  `motorhome_detail_id` INT(5) UNSIGNED NULL DEFAULT NULL,
  CONSTRAINT `motorhome_detail_id_fk` FOREIGN KEY (`motorhome_detail_id`)
  REFERENCES `nordic-motorhome`.`motorhome_details` (`motorhome_detail_id`) ON UPDATE CASCADE ON DELETE SET NULL);
    
  CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`customer_contacts` (
  `contact_id` INT(5) UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `e_mail` VARCHAR(80) NULL DEFAULT NULL,
  `phone` VARCHAR(25) NULL DEFAULT NULL);
  
  CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`customer_addresses` (
  `address_id` INT(5) UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `street_name` VARCHAR(55) NULL DEFAULT NULL,
  `street_no` INT(6) UNSIGNED NULL DEFAULT NULL,
  `city` VARCHAR(25) NULL DEFAULT NULL,
  `country` VARCHAR(30) NULL DEFAULT NULL,
  `zip` INT(9) UNSIGNED NULL DEFAULT NULL);
  
  CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`customers` (
  `customer_id` INT(5) UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `first_name` VARCHAR(15) NULL DEFAULT NULL,
  `last_name` VARCHAR(15) NULL DEFAULT NULL,
  `contact_id` INT(5) UNSIGNED NULL DEFAULT NULL,
  `address_id` INT(5) UNSIGNED NULL DEFAULT NULL,
  CONSTRAINT `contact_id_fk` FOREIGN KEY (`contact_id`)
  REFERENCES `nordic-motorhome`.`customer_contacts` (`contact_id`) ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT `address_id_fk` FOREIGN KEY (`address_id`)
  REFERENCES `nordic-motorhome`.`customer_addresses` (`address_id`) ON UPDATE CASCADE ON DELETE SET NULL);
    
    CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`pick_up_and_drop_off` (
  `pd_id` INT(5) UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `pick_up_location` VARCHAR(45) NULL DEFAULT NULL,
  `pick_up_distance` DECIMAL(5,2) UNSIGNED NULL DEFAULT NULL,
  `drop_off location` VARCHAR(45) NULL DEFAULT NULL,
  `drop_off_distance` DECIMAL(5,2) UNSIGNED NULL DEFAULT NULL);
  
  CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`terms_and_conditions` (
  `tc_id` INT(5) UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `season` VARCHAR(15) NULL DEFAULT NULL,
  `rent_days` INT(3) UNSIGNED NULL DEFAULT NULL,
  `km` DECIMAL(7,1) UNSIGNED NULL DEFAULT NULL,
  `fuel_fank` VARCHAR(10) NULL DEFAULT NULL,
  `cancellation` VARCHAR(100) NULL DEFAULT NULL,
  `notes` VARCHAR(100) NULL DEFAULT NULL);
  
  CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`contracts` (
  `contract_id` INT(5) UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT,
  `pd_id` INT(5) UNSIGNED NULL DEFAULT NULL,
  `tc_id` INT(5) UNSIGNED NULL DEFAULT NULL,
  `motorhome_id` INT(5) UNSIGNED NULL DEFAULT NULL,
  `customer_id` INT(5) UNSIGNED NULL DEFAULT NULL,
  CONSTRAINT `pd_id_fk` FOREIGN KEY (`pd_id`)
  REFERENCES `nordic-motorhome`.`pick_up_and_drop_off` (`pd_id`) ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT `tc_id_fk` FOREIGN KEY (`tc_id`)
  REFERENCES `nordic-motorhome`.`terms_and_conditions` (`tc_id`) ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT `motorhome_id_fk` FOREIGN KEY (`motorhome_id`)
  REFERENCES `nordic-motorhome`.`motorhomes` (`motorhome_id`) ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT `customer_id_fk` FOREIGN KEY (`customer_id`)
  REFERENCES `nordic-motorhome`.`customers` (`customer_id`) ON UPDATE CASCADE ON DELETE SET NULL);