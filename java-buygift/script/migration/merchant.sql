
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Guusto Card','https://staging.guusto.com/guusto2/img/appsmall/guusto card.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Coffee','https://staging.guusto.com/guusto2/img/appsmall/coffee.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Dessert','https://staging.guusto.com/guusto2/img/appsmall/dessert.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Erink','https://staging.guusto.com/guusto2/img/appsmall/drink.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Lunch','https://staging.guusto.com/guusto2/img/appsmall/lunch.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Pint','https://staging.guusto.com/guusto2/img/appsmall/pint.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Appetizer','https://staging.guusto.com/guusto2/img/appsmall/appetizer.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Glass','https://staging.guusto.com/guusto2/img/appsmall/glass.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Dinner','https://staging.guusto.com/guusto2/img/appsmall/dinner.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Round','https://staging.guusto.com/guusto2/img/appsmall/round.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Bottle','https://staging.guusto.com/guusto2/img/appsmall/bottle.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Movie','https://staging.guusto.com/guusto2/img/appsmall/movie.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Spa','https://staging.guusto.com/guusto2/img/appsmall/spa.png');
INSERT INTO `guusto-new`.`merchant_type`( `merchant_type_name`, `merchant_type_picture`) VALUES ('Shopping','https://staging.guusto.com/guusto2/img/appsmall/shopping.png');

INSERT INTO `guusto-new`.`merchant_partner`( `country`, `currency`, `merchant_partner_name`) VALUES ('US', 'USD', 'Partner 01');
INSERT INTO `guusto-new`.`merchant_partner`( `country`, `currency`, `merchant_partner_name`) VALUES ('CA', 'CAD', 'Partner 02');
INSERT INTO `guusto-new`.`merchant_partner`( `country`, `currency`, `merchant_partner_name`) VALUES ('CA', 'CAD', 'Partner 03');
INSERT INTO `guusto-new`.`merchant_partner`( `country`, `currency`, `merchant_partner_name`) VALUES ('CA', 'CAD', 'Partner 04');
INSERT INTO `guusto-new`.`merchant_partner`( `country`, `currency`, `merchant_partner_name`) VALUES ('CA', 'CAD', 'Partner 05');

INSERT INTO `guusto-new`.merchant (id, shopping_option, functionalities, country, currency, active, partner_fk, type_fk, metadata, default_message, merchant_note, merchant_description, min_amount, max_amount, website, merchant_picture, merchant_name)
SELECT
	id,
	(CASE
        WHEN `online` = 1 THEN 'STORE_AND_ONLINE'
        WHEN `online` = 0 THEN 'STORE'
    END) as `shopping_option`,
    (CASE
        WHEN `balance_check` = 1 THEN 'BalanceCheck'
        ELSE null
    END) as `functionalities`,
    (CASE
        WHEN `country_id` = 1 THEN 'CA'
        WHEN `country_id` = 2 THEN 'US'
        ELSE null
    END) as country,
    (CASE
        WHEN `country_id` = 1 THEN 'CAD'
        WHEN `country_id` = 1 THEN 'USD'
        ELSE null
    END) as currency,
    (CASE
        WHEN `status` = 1 THEN true
        ELSE false
    END) as active,
    `channel_partner_id` as partner_fk,
    `type` as type_fk,
    `metadata` as metadata,
    `message_on_giftcard` as default_message,
    `note`as merchant_note,
    `description` as merchant_description,
    `min_gift_amount` as min_amount,
    `max_gift_amount` as max_amount,
    `website`as website,
    CONCAT("http://images.guusto.com/guusto/img/", id, ".png") as merchant_picture, 
    `name`as merchant_name
FROM `guusto`.`merchant` WHERE `channel_partner_id` > 0 ;

INSERT INTO `guusto-new`.`merchant_address`(`merchant_fk`, `street`, `city`, `province`, `zipcode`, `country`, `lattitude`, `longitude`) 
SELECT 
    `merchantid` as merchant_fk, 
    `street`, 
    `city`, 
    `province`, 
    `zipcode`, 
    `country`, 
    `lattitude`, 
    `longitude`
FROM `guusto`.`address` WHERE `merchantid` > 0 ;

INSERT INTO `guusto-new`.`merchant_denomination` (amount, merchant_fk)
SELECT 
	`merchant_denominations`.`denomination` as amount,
    `merchant`.`id` as merchant_fk 
FROM `guusto`.`merchant_denominations` 
INNER JOIN `guusto`.`merchant` on `merchant`.`denomination_type` = `merchant_denominations`.`type_id`;


    
    
    