-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_SPTeSIG
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_SPTeSIG
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_SPTeSIG` DEFAULT CHARACTER SET latin1 ;
USE `db_SPTeSIG` ;

-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`hibernate_sequences`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`hibernate_sequences` (
  `sequence_name` VARCHAR(255) NULL DEFAULT NULL,
  `sequence_next_hi_value` INT(11) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_person_employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_person_employee` (
  `id_person` INT(11) NOT NULL,
  `birth` DATE NULL DEFAULT NULL,
  `cpf_cnpj` INT(11) NOT NULL,
  `lastname` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `function` VARCHAR(255) NULL DEFAULT NULL,
  `id_employee` INT(11) NOT NULL,
  `salary` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id_person`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_person_provider`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_person_provider` (
  `id_person` INT(11) NOT NULL,
  `birth` DATE NULL DEFAULT NULL,
  `cpf_cnpj` INT(11) NOT NULL,
  `lastname` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `company` VARCHAR(255) NULL DEFAULT NULL,
  `id_provider` INT(11) NOT NULL,
  PRIMARY KEY (`id_person`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_order_model_purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_order_model_purchase` (
  `id_purchase` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `id_model` INT(11) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `amount` INT(11) NOT NULL,
  `id_employee` INT(11) NULL DEFAULT NULL,
  `id_provider` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_purchase`),
  INDEX `FK_1dehvkkoq64v5ihe9skctcxii` (`id_employee` ASC),
  INDEX `FK_ivbstsoeynaiu6jtakcxav1is` (`id_provider` ASC),
  CONSTRAINT `FK_1dehvkkoq64v5ihe9skctcxii`
    FOREIGN KEY (`id_employee`)
    REFERENCES `db_SPTeSIG`.`tb_person_employee` (`id_person`),
  CONSTRAINT `FK_ivbstsoeynaiu6jtakcxav1is`
    FOREIGN KEY (`id_provider`)
    REFERENCES `db_SPTeSIG`.`tb_person_provider` (`id_person`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_person_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_person_client` (
  `id_person` INT(11) NOT NULL,
  `birth` DATE NULL DEFAULT NULL,
  `cpf_cnpj` INT(11) NOT NULL,
  `lastname` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `id_client` INT(11) NOT NULL,
  PRIMARY KEY (`id_person`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_order_model_sale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_order_model_sale` (
  `id_sale` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `id_model` INT(11) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `amount` INT(11) NOT NULL,
  `id_client` INT(11) NULL DEFAULT NULL,
  `id_employee` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_sale`),
  INDEX `FK_fmirct59q23aw8cb18ugyiyc6` (`id_client` ASC),
  INDEX `FK_2hnshhyjik2523t3h4jody85i` (`id_employee` ASC),
  CONSTRAINT `FK_2hnshhyjik2523t3h4jody85i`
    FOREIGN KEY (`id_employee`)
    REFERENCES `db_SPTeSIG`.`tb_person_employee` (`id_person`),
  CONSTRAINT `FK_fmirct59q23aw8cb18ugyiyc6`
    FOREIGN KEY (`id_client`)
    REFERENCES `db_SPTeSIG`.`tb_person_client` (`id_person`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_person` (
  `id_person` INT(11) NOT NULL,
  `birth` DATE NULL DEFAULT NULL,
  `cpf_cnpj` INT(11) NOT NULL,
  `lastname` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_person`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_product` (
  `id_product` INT(11) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `selected` BIT(1) NULL DEFAULT NULL,
  `url_image` VARCHAR(255) NULL DEFAULT NULL,
  `id_model` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_product_price`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_product_price` (
  `id_price` INT(11) NOT NULL AUTO_INCREMENT,
  `buy_price` DOUBLE NOT NULL,
  `sell_price` DOUBLE NOT NULL,
  `the_date` DATE NULL DEFAULT NULL,
  `id_product` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_price`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_product_exchange`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_product_exchange` (
  `id_product` INT(11) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `selected` BIT(1) NULL DEFAULT NULL,
  `url_image` VARCHAR(255) NULL DEFAULT NULL,
  `id_model` INT(11) NULL DEFAULT NULL,
  `added` BIT(1) NOT NULL,
  `amount` INT(11) NOT NULL,
  `id_price` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  INDEX `FK_gyi43soeefjetna783dv5bcvl` (`id_price` ASC),
  CONSTRAINT `FK_gyi43soeefjetna783dv5bcvl`
    FOREIGN KEY (`id_price`)
    REFERENCES `db_SPTeSIG`.`tb_product_price` (`id_price`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_product_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_product_list` (
  `fk_list` INT(11) NOT NULL,
  `fk_product` INT(11) NOT NULL,
  UNIQUE INDEX `UK_ry0l8s6ib5ck5ypxj93kpbgyp` (`fk_product` ASC),
  INDEX `FK_93q9csvfl1cwtmn2nd5atxrx1` (`fk_list` ASC),
  CONSTRAINT `FK_93q9csvfl1cwtmn2nd5atxrx1`
    FOREIGN KEY (`fk_list`)
    REFERENCES `db_SPTeSIG`.`tb_order_model_sale` (`id_sale`),
  CONSTRAINT `FK_ry0l8s6ib5ck5ypxj93kpbgyp`
    FOREIGN KEY (`fk_product`)
    REFERENCES `db_SPTeSIG`.`tb_product_exchange` (`id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_product_model`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_product_model` (
  `id_model` INT(11) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_model`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_product_model_default`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_product_model_default` (
  `id_model` INT(11) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `height` DOUBLE NOT NULL,
  `id_default` INT(11) NOT NULL,
  PRIMARY KEY (`id_model`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_SPTeSIG`.`tb_product_stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_SPTeSIG`.`tb_product_stock` (
  `id_stock` INT(11) NOT NULL AUTO_INCREMENT,
  `amount` INT(11) NOT NULL,
  `the_date` DATETIME NULL DEFAULT NULL,
  `id_product` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_stock`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
