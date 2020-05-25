-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema nordic-motorhome
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema nordic-motorhome
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nordic-motorhome` DEFAULT CHARACTER SET utf8 ;
USE `nordic-motorhome` ;

-- -----------------------------------------------------
-- Table `nordic-motorhome`.`motorhome_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`motorhome_details` (
  `motorhome_detail_id` INT NOT NULL,
  `km` DECIMAL(7,1) NOT NULL,
  `passengers` INT NOT NULL,
  `price_per_day` VARCHAR(10) NOT NULL,
  `extra` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`motorhome_detail_id`),
  UNIQUE INDEX `Car_ID_UNIQUE` (`motorhome_detail_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nordic-motorhome`.`motorhomes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`motorhomes` (
  `motorhome_id` INT NOT NULL,
  `brand` VARCHAR(20) NOT NULL,
  `model` VARCHAR(20) NOT NULL,
  `motorhome_detail_id` INT NOT NULL,
  PRIMARY KEY (`motorhome_id`, `motorhome_detail_id`),
  UNIQUE INDEX `Car_ID_UNIQUE` (`motorhome_id` ASC) VISIBLE,
  INDEX `fk_motorhomes_motorhome_details_idx` (`motorhome_detail_id` ASC) VISIBLE,
  CONSTRAINT `fk_motorhomes_motorhome_details`
    FOREIGN KEY (`motorhome_detail_id`)
    REFERENCES `nordic-motorhome`.`motorhome_details` (`motorhome_detail_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nordic-motorhome`.`pick-up_and_drop-off`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`pick-up_and_drop-off` (
  `pd_id` INT NOT NULL,
  `pick-up_location` VARCHAR(45) NULL DEFAULT NULL,
  `pick-up_distance` DECIMAL(5,2) NULL DEFAULT NULL,
  `drop-off location` VARCHAR(45) NULL DEFAULT NULL,
  `drop-off_distance` DECIMAL(5,2) NULL DEFAULT NULL,
  PRIMARY KEY (`pd_id`),
  UNIQUE INDEX `PD_ID_UNIQUE` (`pd_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nordic-motorhome`.`terms_and_conditions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`terms_and_conditions` (
  `tc_id` INT NOT NULL,
  `season` VARCHAR(15) NOT NULL,
  `rent_days` INT NOT NULL,
  `km` DECIMAL(7,1) NOT NULL,
  `fuel_fank` VARCHAR(10) NOT NULL,
  `cancellation` VARCHAR(100) NULL DEFAULT NULL,
  `notes` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`tc_id`),
  UNIQUE INDEX `idTerms & Conditions_UNIQUE` (`tc_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nordic-motorhome`.`customer_contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`customer_contacts` (
  `contact_id` INT NOT NULL,
  `e_mail` VARCHAR(80) NULL DEFAULT NULL,
  `phone` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`contact_id`),
  UNIQUE INDEX `CustContact_ID_UNIQUE` (`contact_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nordic-motorhome`.`customer_addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`customer_addresses` (
  `address_id` INT NOT NULL,
  `street_name` VARCHAR(55) NOT NULL,
  `street_no` INT NOT NULL,
  `city` VARCHAR(25) NOT NULL,
  `country` VARCHAR(30) NOT NULL,
  `zip` INT NOT NULL,
  PRIMARY KEY (`address_id`),
  UNIQUE INDEX `Address_ID_UNIQUE` (`address_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nordic-motorhome`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`customers` (
  `customer_id` INT NOT NULL,
  `first_name` VARCHAR(15) NOT NULL,
  `last_name` VARCHAR(15) NOT NULL,
  `contact_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`customer_id`, `contact_id`, `address_id`),
  UNIQUE INDEX `Customer_ID_UNIQUE` (`customer_id` ASC) VISIBLE,
  INDEX `fk_customers_customer_contacts1_idx` (`contact_id` ASC) VISIBLE,
  INDEX `fk_customers_customer_addresses1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_customers_customer_contacts1`
    FOREIGN KEY (`contact_id`)
    REFERENCES `nordic-motorhome`.`customer_contacts` (`contact_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customers_customer_addresses1`
    FOREIGN KEY (`address_id`)
    REFERENCES `nordic-motorhome`.`customer_addresses` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nordic-motorhome`.`contracts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nordic-motorhome`.`contracts` (
  `contract_id` INT NOT NULL,
  `pd_id` INT NOT NULL,
  `tc_id` INT NOT NULL,
  `motorhome_id` INT NOT NULL,
  `motorhome_detail_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `contact_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`contract_id`, `pd_id`, `tc_id`, `motorhome_id`, `motorhome_detail_id`, `customer_id`, `contact_id`, `address_id`),
  UNIQUE INDEX `Contract_ID_UNIQUE` (`contract_id` ASC) VISIBLE,
  INDEX `fk_contracts_pick-up_and_drop-off1_idx` (`pd_id` ASC) VISIBLE,
  INDEX `fk_contracts_terms_and_conditions1_idx` (`tc_id` ASC) VISIBLE,
  INDEX `fk_contracts_motorhomes1_idx` (`motorhome_id` ASC, `motorhome_detail_id` ASC) VISIBLE,
  INDEX `fk_contracts_customers1_idx` (`customer_id` ASC, `contact_id` ASC, `address_id` ASC) VISIBLE,
  CONSTRAINT `fk_contracts_pick-up_and_drop-off1`
    FOREIGN KEY (`pd_id`)
    REFERENCES `nordic-motorhome`.`pick-up_and_drop-off` (`pd_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contracts_terms_and_conditions1`
    FOREIGN KEY (`tc_id`)
    REFERENCES `nordic-motorhome`.`terms_and_conditions` (`tc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contracts_motorhomes1`
    FOREIGN KEY (`motorhome_id` , `motorhome_detail_id`)
    REFERENCES `nordic-motorhome`.`motorhomes` (`motorhome_id` , `motorhome_detail_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contracts_customers1`
    FOREIGN KEY (`customer_id` , `contact_id` , `address_id`)
    REFERENCES `nordic-motorhome`.`customers` (`customer_id` , `contact_id` , `address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
