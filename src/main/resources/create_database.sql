CREATE SCHEMA `chef` ;

CREATE TABLE `chef`.`catalog_item` (
  `catalog_item_id` VARCHAR(45) NOT NULL,
  `item_id` BIGINT(45) NOT NULL,
  `name_item` VARCHAR(45) NULL,
  `description` VARCHAR(300) NULL,
  `bar_code` VARCHAR(300) NULL,
  `catalog_item_type` VARCHAR(45) NULL,
  `amount` INT NULL,
  `kg` DOUBLE NULL,
  `sales_model_catalog_item_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`catalog_item_id`));

CREATE TABLE `chef`.`catalog_item_parent` (
  `catalog_item_id` VARCHAR(45) NOT NULL,
  `parent_id` VARCHAR(45) NULL);

CREATE TABLE `chef`.`sales_price` (
  `sales_price_id` VARCHAR(45) NOT NULL,
  `sales_model_id` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  `sales_rule_id` VARCHAR(45) NOT NULL,
  `catalog_item_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sales_price_id`));

ALTER TABLE `chef`.`sales_price`
ADD INDEX `fk_sales_price_id_catalog_item_id_idx` (`catalog_item_id` ASC);
ALTER TABLE `chef`.`sales_price`
ADD CONSTRAINT `fk_sales_price_id_catalog_item_id`
  FOREIGN KEY (`catalog_item_id`)
  REFERENCES `chef`.`catalog_item` (`catalog_item_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `chef`.`sales_rules` (
  `sales_rules_id` VARCHAR(45) NOT NULL,
  `day` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`sales_rules_id`));

CREATE TABLE `chef`.`sales_model_catalog_item` (
  `sales_price_catalog_item_id` VARCHAR(45) NOT NULL,
  `sales_model_id` VARCHAR(45) NOT NULL,
  `catalog_item_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sales_price_catalog_item_id`));