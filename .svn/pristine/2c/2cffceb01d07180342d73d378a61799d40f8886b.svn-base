-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema headphonesdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema headphonesdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `headphonesdb` DEFAULT CHARACTER SET utf8 ;
USE `headphonesdb` ;

-- -----------------------------------------------------
-- Table `headphonesdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `headphonesdb`.`user` (
  `userID` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(30) NOT NULL,
  `lastName` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `last_failed_login` MEDIUMTEXT NULL DEFAULT NULL,
  `failed_login_attempts` INT(11) NULL DEFAULT NULL,
  `admin` INT(11) NULL DEFAULT NULL,
  `active` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`userID`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `headphonesdb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `headphonesdb`.`order` (
  `orderID` INT(11) NOT NULL AUTO_INCREMENT,
  `userID` INT(11) NOT NULL,
  `orderDate` DATE NOT NULL,
  `shipDate` DATETIME NULL DEFAULT NULL,
  `active` INT(11) NULL DEFAULT NULL,
  `shipped` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `userID` (`userID` ASC),
  CONSTRAINT `order_ibfk_1`
    FOREIGN KEY (`userID`)
    REFERENCES `headphonesdb`.`user` (`userID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `headphonesdb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `headphonesdb`.`product` (
  `productID` INT(11) NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(30) NOT NULL,
  `model` VARCHAR(30) NULL DEFAULT NULL,
  `style` VARCHAR(30) NOT NULL,
  `wireless` TINYINT(1) NULL DEFAULT NULL,
  `price` DOUBLE(9,2) NULL DEFAULT NULL,
  `description` VARCHAR(400) NULL DEFAULT NULL,
  `active` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`productID`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `headphonesdb`.`line_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `headphonesdb`.`line_item` (
  `orderID` INT(11) NOT NULL,
  `productID` INT(11) NOT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`orderID`, `productID`),
  INDEX `productID` (`productID` ASC),
  CONSTRAINT `line_item_ibfk_1`
    FOREIGN KEY (`orderID`)
    REFERENCES `headphonesdb`.`order` (`orderID`),
  CONSTRAINT `line_item_ibfk_2`
    FOREIGN KEY (`productID`)
    REFERENCES `headphonesdb`.`product` (`productID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
