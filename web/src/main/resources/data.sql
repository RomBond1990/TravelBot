-- -----------------------------------------------------
-- Schema travel_bot
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `travel_bot`;
USE `travel_bot` ;

-- -----------------------------------------------------
-- Table `travel_bot`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `travel_bot`.`country` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `travel_bot`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `travel_bot`.`city` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `fk_country_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKkt8hheblcg2ikasul80xwcy42`
    FOREIGN KEY (`fk_country_id`)
    REFERENCES `travel_bot`.`country` (`id`));


-- -----------------------------------------------------
-- Table `travel_bot`.`attraction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `travel_bot`.`attraction` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `text` VARCHAR(255) NULL DEFAULT NULL,
  `fk_city_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKgou220mwp34n9a6uefsojlwxf`
    FOREIGN KEY (`fk_city_id`)
    REFERENCES `travel_bot`.`city` (`id`));


-- -----------------------------------------------------
-- Table `travel_bot`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `travel_bot`.`address` (
  `id` BIGINT(20) NOT NULL,
  `building_number` VARCHAR(255) NULL DEFAULT NULL,
  `latitude` DOUBLE NULL DEFAULT NULL,
  `longitude` DOUBLE NULL DEFAULT NULL,
  `street` VARCHAR(255) NULL DEFAULT NULL,
  `street_type` VARCHAR(255) NULL DEFAULT NULL,
  `fk_attraction_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKl4fyfm66osluehol3kl0iwhoj`
    FOREIGN KEY (`fk_attraction_id`)
    REFERENCES `travel_bot`.`attraction` (`id`));


-- -----------------------------------------------------
-- Table `travel_bot`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `travel_bot`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL);



-- DROP SCHEMA IF EXISTS `travelBotDB`;
--
-- CREATE SCHEMA IF NOT EXISTS `travelBotDB`;
--
-- USE `travelBotDB` ;
--
-- CREATE TABLE `country` (
--   `id` BIGINT NOT NULL PRIMARY KEY,
--   `group_name` VARCHAR(255)
--   );
--
--
INSERT INTO `country` (`id`,`name`) VALUES ('1','Беларусь');
INSERT INTO `country` (`id`,`name`) VALUES ('2','США');

INSERT INTO `city` (`id`,`name`, `fk_country_id`) VALUES ('1','Минск', '1');
INSERT INTO `city` (`id`,`name`, `fk_country_id`) VALUES ('2','Брест', '2');
INSERT INTO `city` (`id`,`name`, `fk_country_id`) VALUES ('3','Гродно', '1');
INSERT INTO `attraction` (`id`,`name`,`text`, `fk_city_id`) VALUES ('1','Площадь Перемен', 'Легендарный минский двор "Площадь Перемен" в Минске на Червякова. Здесь закрашивают мурал с диджеями, а жители его восстанавливают', '1');
INSERT INTO `attraction` (`id`,`name`,`text`, `fk_city_id`) VALUES ('2','Озеро Надежды', 'Здесь происходили ожесточенные морские бои между ЖЭС и флагом свободы', '1');
INSERT INTO `attraction` (`id`,`name`,`text`, `fk_city_id`) VALUES ('3','Брестская Крепость', 'Крепость в черте города Бреста, у впадения реки Мухавец в Западный Буг, а также Тереспольской гмины Польши. Крепость I класса. Крепость-герой', '2');
INSERT INTO `attraction` (`id`,`name`,`text`, `fk_city_id`) VALUES ('4','Собор Святого Франциска Ксаверия', 'Католический собор в городе Гродно, кафедральный собор Гродненского диоцеза. Один из трёх храмов Белоруссии, носящих титул малая базилика', '3');


--
-- SELECT co.name as country, c.name as city, a.name as attraction, a.text FROM country co
-- 						INNER JOIN city c ON co.id = c.fk_country_id and c.name='Minsk'
-- 						INNER JOIN attraction a ON c.id = a.fk_city_id;
--
--
-- SELECT * FROM city;
-- SELECT a.name, a.text FROM attraction a INNER JOIN city c ON c.name = 'Minsk' ;
