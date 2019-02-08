CREATE SCHEMA `chef` ;

CREATE TABLE `chef`.`catalog_item` (
  `catalog_item_id` VARCHAR(200) NOT NULL,
  `item_id` BIGINT(45) NOT NULL,
  `name_item` VARCHAR(200) NULL,
  `description` VARCHAR(300) NULL,
  `bar_code` VARCHAR(300) NULL,
  `catalog_item_type` VARCHAR(200) NULL,
  `amount` INT NULL,
  `kg` DOUBLE NULL,
  `level` INT NOT NULL,
  `channel_catalog_item_id` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`catalog_item_id`));

CREATE TABLE `chef`.`catalog_item_parent` (
  `catalog_item_id` VARCHAR(200) NOT NULL,
  `parent_id` VARCHAR(200) NULL);

CREATE TABLE `chef`.`sales_price` (
  `sales_price_id` VARCHAR(200) NOT NULL,
  `channel_id` VARCHAR(200) NOT NULL,
  `price` DOUBLE NOT NULL,
  `sales_rule_id` VARCHAR(200) NOT NULL,
  `catalog_item_id` VARCHAR(200) NOT NULL,
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
  `sales_rules_id` VARCHAR(200) NOT NULL,
  `day` VARCHAR(200) NOT NULL,
  `description` VARCHAR(200) NULL,
  PRIMARY KEY (`sales_rules_id`));

CREATE TABLE `chef`.`channel_catalog_item` (
  `sales_price_catalog_item_id` VARCHAR(200) NOT NULL,
  `channel_id` VARCHAR(200) NOT NULL,
  `catalog_item_id` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`sales_price_catalog_item_id`));



-- ORDER


CREATE TABLE `chef`.`purchase_order` (
  `purchase_order_id` VARCHAR(200) NOT NULL,
  `employee_id` VARCHAR(200) NOT NULL,
  `purchase_order_type` VARCHAR(200) NOT NULL,
  `channel_id` VARCHAR(200) NOT NULL,
  `channel` VARCHAR(200) NOT NULL,
  `purchase_order_state` VARCHAR(200) NOT NULL,
  `total_price` DOUBLE NOT NULL,
  PRIMARY KEY (`purchase_order_id`));

CREATE TABLE `chef`.`purchase_order_item` (
  `purchase_order_item_id` VARCHAR(200) NOT NULL,
  `catalog_item_id` VARCHAR(200) NOT NULL,
  `purchase_order_id` VARCHAR(200) NOT NULL,
  `purchase_order_item_state` VARCHAR(200) NOT NULL,
  `purchase_order_item_type` VARCHAR(200) NOT NULL,
  `purchase_order_item_parent_id` VARCHAR(200) NULL,
  `price` DOUBLE NOT NULL,
  `amount` INT NULL,
  `kg` DOUBLE NULL,
  PRIMARY KEY (`purchase_order_item_id`));


-- PAYMENT

CREATE TABLE `chef`.`payment_order` (
  `payment_order_id` VARCHAR(200) NOT NULL,
  `purchase_order_id` VARCHAR(200) NOT NULL,
  `payment_order_state` VARCHAR(200) NOT NULL,
  `total_value` DOUBLE NOT NULL,
  `reduce_value` DOUBLE NOT NULL,
  `increment_value` DOUBLE NOT NULL,
  `tax` DOUBLE NOT NULL,
  PRIMARY KEY (`payment_order_id`));

CREATE TABLE `chef`.`payment` (
  `payment_id` VARCHAR(200) NOT NULL,
  `payment_method` VARCHAR(200) NOT NULL,
  `value` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`payment_id`));
