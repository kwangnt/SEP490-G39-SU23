SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema teachsync
-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `teachsync` ;

CREATE SCHEMA IF NOT EXISTS `teachsync` DEFAULT CHARACTER SET utf8mb3 ;
USE `teachsync` ;

-- -----------------------------------------------------
-- Table `teachsync`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`role` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `roleName` VARCHAR(45) NOT NULL,
  `roleDesc` LONGTEXT NULL DEFAULT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_role_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_role_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_role_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`user` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `roleId` BIGINT NOT NULL,
  `userAvatar` LONGTEXT NULL,
  `fullName` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(10) NULL DEFAULT NULL,
  `addressId` BIGINT NULL,
  `resetPasswordToken` VARCHAR(255) NULL DEFAULT NULL,
  `parentId` BIGINT NULL DEFAULT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_address_idx` (`addressId` ASC) VISIBLE,
  INDEX `fk_user_user_parentId_idx` (`parentId` ASC) VISIBLE,
  INDEX `fk_user_role_idx` (`roleId` ASC) VISIBLE,
  INDEX `fk_user_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_user_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_user_address`
    FOREIGN KEY (`addressId`)
    REFERENCES `teachsync`.`address` (`id`),
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`roleId`)
    REFERENCES `teachsync`.`role` (`id`),
  CONSTRAINT `fk_user_user_parentId`
    FOREIGN KEY (`parentId`)
    REFERENCES `teachsync`.`user` (`id`),
  CONSTRAINT `fk_user_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`country` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`country` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `countryName` VARCHAR(255) NOT NULL,
  `countryAlias` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_country_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_country_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_country_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_country_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`province`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`province` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`province` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `countryId` BIGINT NOT NULL,
  `provinceName` VARCHAR(255) NOT NULL,
  `provinceAlias` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_province_country_idx` (`countryId` ASC) VISIBLE,
  INDEX `fk_province_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_province_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_province_country`
    FOREIGN KEY (`countryId`)
    REFERENCES `teachsync`.`country` (`id`),
  CONSTRAINT `fk_province_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_province_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`city` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`city` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `provinceId` BIGINT NOT NULL,
  `cityName` VARCHAR(255) NOT NULL,
  `cityAlias` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_province_idx` (`provinceId` ASC) VISIBLE,
  INDEX `fk_city_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_city_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_city_province`
    FOREIGN KEY (`provinceId`)
    REFERENCES `teachsync`.`province` (`id`),
  CONSTRAINT `fk_city_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_city_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`district`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`district` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`district` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cityId` BIGINT NOT NULL,
  `districtName` VARCHAR(255) NOT NULL,
  `districtAlias` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_district_city_idx` (`cityId` ASC) INVISIBLE,
  INDEX `fk_district_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_district_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_district_city`
    FOREIGN KEY (`cityId`)
    REFERENCES `teachsync`.`city` (`id`),
  CONSTRAINT `fk_district_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_district_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`ward`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`ward` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`ward` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `districtId` BIGINT NOT NULL,
  `wardName` VARCHAR(255) NOT NULL,
  `wardAlias` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ward_district_idx` (`districtId` ASC) VISIBLE,
  INDEX `fk_ward_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_ward_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_ward_district`
    FOREIGN KEY (`districtId`)
    REFERENCES `teachsync`.`district` (`id`),
  CONSTRAINT `fk_ward_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ward_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`area` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`area` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `wardId` BIGINT NOT NULL,
  `areaName` VARCHAR(255) NOT NULL,
  `areaAlias` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_area_ward_idx` (`wardId` ASC) VISIBLE,
  INDEX `fk_area_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_area_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  CONSTRAINT `fk_area_ward`
    FOREIGN KEY (`wardId`)
    REFERENCES `teachsync`.`ward` (`id`),
  CONSTRAINT `fk_area_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_area_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`address` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`address` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `countryId` BIGINT NOT NULL,
  `provinceId` BIGINT NOT NULL,
  `cityId` BIGINT NOT NULL,
  `districtId` BIGINT NOT NULL,
  `wardId` BIGINT NOT NULL,
  `areaId` BIGINT NULL DEFAULT NULL,
  `street` VARCHAR(255) NOT NULL,
  `addressNo` VARCHAR(255) NOT NULL,
  `addressString` LONGTEXT NULL COMMENT 'auto generated in code, save on query resource',
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_area_idx` (`areaId` ASC) VISIBLE,
  INDEX `fk_address_city_idx` (`cityId` ASC) VISIBLE,
  INDEX `fk_address_country_idx` (`countryId` ASC) VISIBLE,
  INDEX `fk_address_district_idx` (`districtId` ASC) VISIBLE,
  INDEX `fk_address_province_idx` (`provinceId` ASC) VISIBLE,
  INDEX `fk_address_ward_idx` (`wardId` ASC) VISIBLE,
  INDEX `fk_address_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_address_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_address_area`
    FOREIGN KEY (`areaId`)
    REFERENCES `teachsync`.`area` (`id`),
  CONSTRAINT `fk_address_country`
    FOREIGN KEY (`countryId`)
    REFERENCES `teachsync`.`country` (`id`),
  CONSTRAINT `fk_address_city`
    FOREIGN KEY (`cityId`)
    REFERENCES `teachsync`.`city` (`id`),
  CONSTRAINT `fk_address_province`
    FOREIGN KEY (`provinceId`)
    REFERENCES `teachsync`.`province` (`id`),
  CONSTRAINT `fk_address_ward`
    FOREIGN KEY (`wardId`)
    REFERENCES `teachsync`.`ward` (`id`),
  CONSTRAINT `fk_address_district`
    FOREIGN KEY (`districtId`)
    REFERENCES `teachsync`.`district` (`id`),
  CONSTRAINT `fk_address_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`question` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`question` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `testId` BIGINT NOT NULL,
  `questionType` VARCHAR(255) NOT NULL,
  `questionDesc` LONGTEXT NOT NULL,
  `questionPrompt` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_question_test_idx` (`testId` ASC) VISIBLE,
  INDEX `fk_question_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_question_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_question_test`
    FOREIGN KEY (`testId`)
    REFERENCES `teachsync`.`test` (`id`),
  CONSTRAINT `fk_question_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`answer` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`answer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `questionId` BIGINT NOT NULL,
  `answerDesc` LONGTEXT NOT NULL,
  `isCorrect` BIT(1) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_answer_question_idx` (`questionId` ASC) VISIBLE,
  INDEX `fk_answer_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_answer_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_answer_question`
    FOREIGN KEY (`questionId`)
    REFERENCES `teachsync`.`question` (`id`),
  CONSTRAINT `fk_answer_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_answer_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`center`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`center` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`center` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `addressId` BIGINT NOT NULL,
  `centerName` VARCHAR(45) NOT NULL,
  `centerType` VARCHAR(45) NOT NULL,
  `centerDesc` LONGTEXT NULL DEFAULT NULL,
  `centerSize` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_center_address_idx` (`addressId` ASC) VISIBLE,
  INDEX `fk_center_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_center_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_center_address`
    FOREIGN KEY (`addressId`)
    REFERENCES `teachsync`.`address` (`id`),
  CONSTRAINT `fk_center_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_center_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`room` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`room` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `centerId` BIGINT NOT NULL,
  `roomType` VARCHAR(45) NULL DEFAULT NULL,
  `roomDesc` LONGTEXT NULL DEFAULT NULL,
  `roomName` VARCHAR(45) NULL DEFAULT NULL,
  `roomSize` INT NOT NULL COMMENT 'no of people',
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_room_center_idx` (`centerId` ASC) VISIBLE,
  INDEX `fk_room_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_room_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_room_center`
    FOREIGN KEY (`centerId`)
    REFERENCES `teachsync`.`center` (`id`),
  CONSTRAINT `fk_room_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_room_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`course` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`course` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `courseName` VARCHAR(45) NOT NULL,
  `courseAlias` VARCHAR(10) NOT NULL,
  `courseImg` LONGTEXT NOT NULL,
  `courseDesc` LONGTEXT NULL DEFAULT NULL,
  `numSession` INT NOT NULL,
  `minScore` FLOAT NOT NULL,
  `minAttendant` FLOAT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_course_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_course_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_course_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- -----------------------------------------------------
-- Table `teachsync`.`semester`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`semester` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`semester` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `semesterName` VARCHAR(45) NOT NULL,
  `semesterAlias` VARCHAR(10) NOT NULL,
  `semesterDesc` LONGTEXT NULL DEFAULT NULL,
  `semesterType` VARCHAR(45) NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,

  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_semester_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_semester_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_semester_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_semester_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`course_semester`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`course_semester` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`course_semester` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `courseId` BIGINT NOT NULL,
  `semesterId` BIGINT NOT NULL,
  `centerId` BIGINT NOT NULL,

  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_course_semester_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_course_semester_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_course_semester_semester_idx` (`semesterId` ASC) VISIBLE,
  INDEX `fk_course_semester_center_idx` (`centerId` ASC) VISIBLE,
  INDEX `fk_course_semester_course_idx` (`courseId` ASC) VISIBLE,
  CONSTRAINT `fk_course_semester_semester`
    FOREIGN KEY (`semesterId`)
    REFERENCES `teachsync`.`semester` (`id`),
  CONSTRAINT `fk_course_semester_center`
    FOREIGN KEY (`centerId`)
    REFERENCES `teachsync`.`center` (`id`),
  CONSTRAINT `fk_course_semester_course`
    FOREIGN KEY (`courseId`)
    REFERENCES `teachsync`.`course` (`id`),
  CONSTRAINT `fk_course_semester_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_semester_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`clazz`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`clazz` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`clazz` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `courseSemesterId` BIGINT NOT NULL,
  `clazzName` VARCHAR(45) NOT NULL,
  `clazzDesc` LONGTEXT NULL DEFAULT NULL,
  `clazzSize` INT NOT NULL COMMENT 'no of people',
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_clazz_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_clazz_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_clazz_course_semester_idx` (`courseSemesterId` ASC) VISIBLE,
  CONSTRAINT `fk_clazz_course_semester`
    FOREIGN KEY (`courseSemesterId`)
    REFERENCES `teachsync`.`course_semester` (`id`),
  CONSTRAINT `fk_clazz_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clazz_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`clazz_schedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`clazz_schedule` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`clazz_schedule` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `clazzId` BIGINT NOT NULL,
  `roomId` BIGINT NOT NULL COMMENT 'default room',
  `scheduleType` VARCHAR(45) NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `slot` INT NULL,
  `sessionStart` TIME NOT NULL,
  `sessionEnd` TIME NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_clazz_schedule_clazz_idx` (`clazzId` ASC) INVISIBLE,
  INDEX `fk_clazz_schedule_room_idx` (`roomId` ASC) VISIBLE,
  INDEX `fk_clazz_schedule_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_clazz_schedule_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_clazz_schedule_room`
    FOREIGN KEY (`roomId`)
    REFERENCES `teachsync`.`room` (`id`),
  CONSTRAINT `fk_clazz_schedule_clazz`
    FOREIGN KEY (`clazzId`)
    REFERENCES `teachsync`.`clazz` (`id`),
  CONSTRAINT `fk_clazz_schedule_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clazz_schedule_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`session`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`session` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`session` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `roomId` BIGINT NOT NULL COMMENT 'actual room',
  `scheduleId` BIGINT NOT NULL,
  `teacherId` BIGINT NOT NULL,
  `slot` INT NULL,
  `sessionStart` DATETIME NOT NULL,
  `sessionEnd` DATETIME NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_session_room_idx` (`roomId` ASC) VISIBLE,
  INDEX `fk_session_schedule_idx` (`scheduleId` ASC) VISIBLE,
  INDEX `fk_session_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_session_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_session_user_teacherId_idx` (`teacherId` ASC) VISIBLE,
  CONSTRAINT `fk_session_room`
    FOREIGN KEY (`roomId`)
    REFERENCES `teachsync`.`room` (`id`),
  CONSTRAINT `fk_session_schedule`
    FOREIGN KEY (`scheduleId`)
    REFERENCES `teachsync`.`clazz_schedule` (`id`),
  CONSTRAINT `fk_session_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_session_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_session_user_teacherId`
    FOREIGN KEY (`teacherId`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`clazz_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`clazz_member` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`clazz_member` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `clazzId` BIGINT NOT NULL,
  `userId` BIGINT NOT NULL,
  `memberRole` VARCHAR(45) NOT NULL COMMENT 'teacher/student',
  `score` FLOAT NULL,
  `attendant` FLOAT NULL,
  `isPassed` BIT(1) NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_clazz_member_clazz_idx` (`clazzId` ASC) VISIBLE,
  INDEX `fk_clazz_member_user_idx` (`userId` ASC) VISIBLE,
  INDEX `fk_clazz_member_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_clazz_member_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_clazz_member_clazz`
    FOREIGN KEY (`clazzId`)
    REFERENCES `teachsync`.`clazz` (`id`),
  CONSTRAINT `fk_clazz_member_user`
    FOREIGN KEY (`userId`)
    REFERENCES `teachsync`.`user` (`id`),
  CONSTRAINT `fk_clazz_member_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clazz_member_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`attendant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`attendant` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`attendant` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `sessionId` BIGINT NOT NULL,
  `memberId` BIGINT NOT NULL,
  `isPresent` BIT(1) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_attendant_clazz_member_idx` (`memberId` ASC) VISIBLE,
  INDEX `fk_attendant_session_idx` (`sessionId` ASC) VISIBLE,
  INDEX `fk_attendant_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_attendant_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_attendant_session`
    FOREIGN KEY (`sessionId`)
    REFERENCES `teachsync`.`session` (`id`),
  CONSTRAINT `fk_attendant_clazz_member`
    FOREIGN KEY (`memberId`)
    REFERENCES `teachsync`.`clazz_member` (`id`),
  CONSTRAINT `fk_attendant_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_attendant_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`homework`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`homework` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`homework` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `clazzId` BIGINT NOT NULL,
  `homeworkName` VARCHAR(45) NOT NULL,
  `homeworkDesc` LONGTEXT NULL DEFAULT NULL,
  `homeworkDoc` MEDIUMBLOB NULL,
  `homeworkDocLink` LONGTEXT NULL,
  `openAt` DATETIME NULL,
  `deadline` DATETIME NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_homework_clazz_idx` (`clazzId` ASC) VISIBLE,
  INDEX `fk_homework_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_homework_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_homework_clazz`
    FOREIGN KEY (`clazzId`)
    REFERENCES `teachsync`.`clazz` (`id`),
  CONSTRAINT `fk_homework_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_homework_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`material` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`material` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `courseId` BIGINT NULL,
  `materialName` VARCHAR(45) NOT NULL,
  `materialLink` LONGTEXT NULL,
  `materialContent` MEDIUMBLOB NULL,
  `materialImg` LONGTEXT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_material_course_idx` (`courseId` ASC) VISIBLE,
  INDEX `fk_material_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_material_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_material_course`
    FOREIGN KEY (`courseId`)
    REFERENCES `teachsync`.`course` (`id`),
  CONSTRAINT `fk_material_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_material_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`member_homework_record`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`member_homework_record` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`member_homework_record` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `memberId` BIGINT NOT NULL,
  `homeworkId` BIGINT NOT NULL,
  `submission` MEDIUMBLOB NULL DEFAULT NULL COMMENT 'file, 16.76 Mb',
  `submissionLink` LONGTEXT NULL DEFAULT NULL,
  `score` FLOAT NULL DEFAULT NULL COMMENT 'max 10.00',
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_member_homework_record_clazz_member_idx` (`memberId` ASC) VISIBLE,
  INDEX `fk_member_homework_record_homework_idx` (`homeworkId` ASC) VISIBLE,
  INDEX `fk_member_homework_record_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_member_homework_record_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_member_homework_record_homework`
    FOREIGN KEY (`homeworkId`)
    REFERENCES `teachsync`.`homework` (`id`),
  CONSTRAINT `fk_member_homework_record_clazz_member`
    FOREIGN KEY (`memberId`)
    REFERENCES `teachsync`.`clazz_member` (`id`),
  CONSTRAINT `fk_member_homework_record_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_member_homework_record_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`test`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`test` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`test` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `courseId` BIGINT NULL,
  `testName` VARCHAR(45) NOT NULL,
  `testType` VARCHAR(45) NOT NULL,
  `testImg` LONGTEXT NULL,
  `testDesc` LONGTEXT NULL,
  `timeLimit` INT NOT NULL,
  `numQuestion` INT NOT NULL,
  `minScore` FLOAT NOT NULL,
  `testWeight` INT NOT NULL,
  `totalScore` FLOAT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_test_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_test_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_test_course_idx` (`courseId` ASC) VISIBLE,
  CONSTRAINT `fk_test_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`),
  CONSTRAINT `fk_test_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_test_course`
    FOREIGN KEY (`courseId`)
    REFERENCES `teachsync`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`clazz_test`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`clazz_test` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`clazz_test` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `clazzId` BIGINT NOT NULL,
  `testId` BIGINT NOT NULL,
  `openFrom` DATETIME NULL,
  `openTo` DATETIME NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL,
  `createdBy` BIGINT NULL,
  `updatedAt` DATETIME NULL,
  `updatedBy` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_clazz_test_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_clazz_test_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_clazz_test_test_idx` (`testId` ASC) VISIBLE,
  INDEX `fk_clazz_test_clazz_idx` (`clazzId` ASC) VISIBLE,
  CONSTRAINT `fk_clazz_test_clazz`
    FOREIGN KEY (`clazzId`)
    REFERENCES `teachsync`.`clazz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clazz_test_test`
    FOREIGN KEY (`testId`)
    REFERENCES `teachsync`.`test` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clazz_test_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clazz_test_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teachsync`.`member_test_record`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`member_test_record` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`member_test_record` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `memberId` BIGINT NOT NULL,
  `clazzTestId` BIGINT NOT NULL,
  `score` DOUBLE NULL DEFAULT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_member_test_record_clazz_member_idx` (`memberId` ASC) VISIBLE,
  INDEX `fk_member_test_record_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_member_test_record_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_member_test_record_clazz_test_idx` (`clazzTestId` ASC) VISIBLE,
  CONSTRAINT `fk_member_test_record_clazz_test`
    FOREIGN KEY (`clazzTestId`)
    REFERENCES `teachsync`.`clazz_test` (`id`),
  CONSTRAINT `fk_member_test_record_clazz_member`
    FOREIGN KEY (`memberId`)
    REFERENCES `teachsync`.`clazz_member` (`id`),
  CONSTRAINT `fk_member_test_record_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_member_test_record_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`news`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`news` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`news` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `authorId` BIGINT NOT NULL,
  `newsTitle` VARCHAR(45) NOT NULL,
  `newsContent` MEDIUMBLOB NULL DEFAULT NULL,
  `newsLink` LONGTEXT NULL,
  `newsDesc` LONGTEXT NULL DEFAULT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_news_user_idx` (`authorId` ASC) VISIBLE,
  INDEX `fk_news_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_news_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_news_user`
    FOREIGN KEY (`authorId`)
    REFERENCES `teachsync`.`user` (`id`),
  CONSTRAINT `fk_news_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_news_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`price_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`price_log` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`price_log` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `courseId` BIGINT NOT NULL,
  `price` DOUBLE NOT NULL,
  `isCurrent` BIT(1) NOT NULL,
  `isPromotion` BIT(1) NOT NULL,
  `promotionAmount` DOUBLE NULL DEFAULT NULL,
  `promotionType` VARCHAR(45) NULL DEFAULT NULL,
  `promotionDesc` LONGTEXT NULL DEFAULT NULL,
  `validFrom` DATETIME NOT NULL,
  `validTo` DATETIME NULL DEFAULT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_price_log_course_idx` (`courseId` ASC) VISIBLE,
  INDEX `fk_price_log_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_price_log_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_price_log_course`
    FOREIGN KEY (`courseId`)
    REFERENCES `teachsync`.`course` (`id`),
  CONSTRAINT `fk_price_log_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_price_log_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`request`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`request` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`request` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `requesterId` BIGINT NOT NULL,
  `requestName` VARCHAR(45) NOT NULL,
  `requestDesc` LONGTEXT NOT NULL,
  `requestType` VARCHAR(45) NOT NULL,
  `clazzId` BIGINT NULL,
  `requestContent` MEDIUMBLOB NULL DEFAULT NULL,
  `contentLink` LONGTEXT NULL DEFAULT NULL,
  `resolverId` BIGINT NULL DEFAULT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_request_user_requesterId_idx` (`requesterId` ASC) VISIBLE,
  INDEX `fk_request_user_resolverId_idx` (`resolverId` ASC) VISIBLE,
  INDEX `fk_request_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_request_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_request_clazz_idx` (`clazzId` ASC) VISIBLE,
  CONSTRAINT `fk_request_user_resolverId`
    FOREIGN KEY (`resolverId`)
    REFERENCES `teachsync`.`user` (`id`),
  CONSTRAINT `fk_request_user_requesterId`
    FOREIGN KEY (`requesterId`)
    REFERENCES `teachsync`.`user` (`id`),
  CONSTRAINT `fk_request_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_clazz`
    FOREIGN KEY (`clazzId`)
    REFERENCES `teachsync`.`clazz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`test_record`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`test_record` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`test_record` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `memberTestRecordId` BIGINT NOT NULL,
  `answerId` BIGINT NOT NULL,
  `answerTxt` LONGTEXT NULL,
  `score` FLOAT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_test_record_answer_idx` (`answerId` ASC) VISIBLE,
  INDEX `fk_test_record_member_test_record` (`memberTestRecordId` ASC) VISIBLE,
  INDEX `fk_test_record_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_test_record_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_test_record_answer`
    FOREIGN KEY (`answerId`)
    REFERENCES `teachsync`.`answer` (`id`),
  CONSTRAINT `fk_test_record_member_test_record`
    FOREIGN KEY (`memberTestRecordId`)
    REFERENCES `teachsync`.`member_test_record` (`id`),
  CONSTRAINT `fk_test_record_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_test_record_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`payment` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`payment` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `payerId` BIGINT NOT NULL,
  `requestId` BIGINT NOT NULL,
  `paymentType` VARCHAR(45) NOT NULL,
  `paymentAmount` DOUBLE NOT NULL,
  `paymentAt` DATETIME NOT NULL,
  `paymentDoc` MEDIUMBLOB NULL,
  `paymentDocLink` LONGTEXT NULL,
  `verifierId` BIGINT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL DEFAULT NULL,
  `createdBy` BIGINT NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `updatedBy` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_payment_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_payment_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_payment_user_verifierId_idx` (`verifierId` ASC) VISIBLE,
  INDEX `fk_payment_user_payerId_idx` (`payerId` ASC) VISIBLE,
  INDEX `fk_payment_request1_idx` (`requestId` ASC) VISIBLE,
  CONSTRAINT `fk_payment_user_payerId`
    FOREIGN KEY (`payerId`)
    REFERENCES `teachsync`.`user` (`id`),
  CONSTRAINT `fk_payment_user_verifierId`
    FOREIGN KEY (`verifierId`)
    REFERENCES `teachsync`.`user` (`id`),
  CONSTRAINT `fk_payment_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_payment_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_payment_request1`
    FOREIGN KEY (`requestId`)
    REFERENCES `teachsync`.`request` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `teachsync`.`center_staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`center_staff` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`center_staff` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `centerId` BIGINT NOT NULL,
  `userId` BIGINT NOT NULL,
  `staffType` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL,
  `createdBy` BIGINT NULL,
  `updatedAt` DATETIME NULL,
  `updatedBy` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_center_staff_center_idx` (`centerId` ASC) VISIBLE,
  INDEX `fk_center_staff_user_idx` (`userId` ASC) VISIBLE,
  INDEX `fk_center_staff_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_center_staff_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  CONSTRAINT `fk_center_staff_center`
    FOREIGN KEY (`centerId`)
    REFERENCES `teachsync`.`center` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_center_staff_user`
    FOREIGN KEY (`userId`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_center_staff_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_center_staff_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teachsync`.`certificate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`certificate` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`certificate` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `courseId` BIGINT NOT NULL,
  `certificateName` VARCHAR(45) NOT NULL,
  `certificateDesc` LONGTEXT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL,
  `createdBy` BIGINT NULL,
  `updatedAt` DATETIME NULL,
  `updatedBy` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_certificate_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_certificate_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_certificate_course_idx` (`courseId` ASC) VISIBLE,
  CONSTRAINT `fk_certificate_course`
    FOREIGN KEY (`courseId`)
    REFERENCES `teachsync`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_certificate_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_certificate_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teachsync`.`wallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teachsync`.`wallet` ;

CREATE TABLE IF NOT EXISTS `teachsync`.`wallet` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `userId` BIGINT NOT NULL,
  `paymentId` BIGINT NULL,
  `currentBalance` DOUBLE NOT NULL,
  `note` VARCHAR(255) NULL,
  `amountChange` DOUBLE NOT NULL,
  `changeAt` DATETIME NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NULL,
  `createdBy` BIGINT NULL,
  `updatedAt` DATETIME NULL,
  `updatedBy` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_wallet_user_createdBy_idx` (`createdBy` ASC) VISIBLE,
  INDEX `fk_wallet_user_updatedBy_idx` (`updatedBy` ASC) VISIBLE,
  INDEX `fk_wallet_payment_idx` (`paymentId` ASC) VISIBLE,
  INDEX `fk_wallet_user_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `fk_wallet_payment`
    FOREIGN KEY (`paymentId`)
    REFERENCES `teachsync`.`payment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wallet_user`
    FOREIGN KEY (`userId`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wallet_user_createdBy`
    FOREIGN KEY (`createdBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wallet_user_updatedBy`
    FOREIGN KEY (`updatedBy`)
    REFERENCES `teachsync`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
