-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: teachsync
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `countryId` bigint NOT NULL,
                           `provinceId` bigint NOT NULL,
                           `cityId` bigint NOT NULL,
                           `districtId` bigint NOT NULL,
                           `wardId` bigint NOT NULL,
                           `areaId` bigint DEFAULT NULL,
                           `street` varchar(255) NOT NULL,
                           `addressNo` varchar(255) DEFAULT NULL,
                           `status` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `fk_address_country_idx` (`countryId`),
                           KEY `fk_address_province_idx` (`provinceId`),
                           KEY `fk_address_city_idx` (`cityId`),
                           KEY `fk_address_district_idx` (`districtId`),
                           KEY `fk_address_ward_idx` (`wardId`),
                           KEY `fk_address_area_idx` (`areaId`),
                           CONSTRAINT `fk_address_area` FOREIGN KEY (`areaId`) REFERENCES `area` (`id`),
                           CONSTRAINT `fk_address_city` FOREIGN KEY (`cityId`) REFERENCES `city` (`id`),
                           CONSTRAINT `fk_address_country` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`),
                           CONSTRAINT `fk_address_district` FOREIGN KEY (`districtId`) REFERENCES `district` (`id`),
                           CONSTRAINT `fk_address_province` FOREIGN KEY (`provinceId`) REFERENCES `province` (`id`),
                           CONSTRAINT `fk_address_ward` FOREIGN KEY (`wardId`) REFERENCES `ward` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `wardId` bigint NOT NULL,
                        `areaName` varchar(255) NOT NULL,
                        `status` varchar(45) NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_area_ward_idx` (`wardId`),
                        CONSTRAINT `fk_area_ward` FOREIGN KEY (`wardId`) REFERENCES `ward` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `provinceId` bigint NOT NULL,
                        `cityName` varchar(255) NOT NULL,
                        `status` varchar(45) NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_city_province_idx` (`provinceId`),
                        CONSTRAINT `fk_city_province` FOREIGN KEY (`provinceId`) REFERENCES `province` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `courseId` bigint NOT NULL,
                             `className` varchar(45) NOT NULL,
                             `classDesc` tinytext,
                             `status` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `fk_class_course1_idx` (`courseId`),
                             CONSTRAINT `fk_class_course1` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,1,'khóa học demo 1','khóa học demo 1','CREATED'),(2,2,'khóa học demo 2','khóa học demo 1','CREATED'),(3,1,'khóa học demo 3','khóa học demo 1','CREATED'),(4,1,'khóa học 4','khóa học demo 1','CREATED'),(5,1,'3',NULL,'DELETED'),(6,1,'demo duong',NULL,'DELETED'),(7,1,'desc',NULL,'DELETED'),(8,1,'Mr D 12344','Mr D 123','DELETED'),(9,2,'dđ','dđ','CREATED');
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `countryName` varchar(255) NOT NULL,
                           `status` varchar(45) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `courseName` varchar(45) NOT NULL,
                          `courseDesc` tinytext,
                          `status` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'demo1','demo1','CREATED'),(2,'demo2','demo1','CREATED'),(3,'couse3','demo1','CREATED');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `district` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `cityId` bigint NOT NULL,
                            `districtName` varchar(255) NOT NULL,
                            `status` varchar(45) NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fk_district_city_idx` (`cityId`),
                            CONSTRAINT `fk_district_city` FOREIGN KEY (`cityId`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homework`
--

DROP TABLE IF EXISTS `homework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homework` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `classId` bigint NOT NULL,
                            `homeworkName` varchar(45) NOT NULL,
                            `homeworkDesc` tinytext,
                            `status` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fk_homework_class1_idx` (`classId`),
                            CONSTRAINT `fk_homework_class1` FOREIGN KEY (`classId`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homework`
--

LOCK TABLES `homework` WRITE;
/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homework_user_pair`
--

DROP TABLE IF EXISTS `homework_user_pair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homework_user_pair` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `homeworkId` bigint NOT NULL,
                                      `userId` bigint NOT NULL,
                                      `score` float DEFAULT NULL,
                                      `status` varchar(45) NOT NULL,
                                      PRIMARY KEY (`id`),
                                      KEY `fk_homework_user_pair_user1_idx` (`userId`),
                                      KEY `fk_homework_user_pair_homework1_idx` (`homeworkId`),
                                      CONSTRAINT `fk_homework_user_pair_homework1` FOREIGN KEY (`homeworkId`) REFERENCES `homework` (`id`),
                                      CONSTRAINT `fk_homework_user_pair_user1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homework_user_pair`
--

LOCK TABLES `homework_user_pair` WRITE;
/*!40000 ALTER TABLE `homework_user_pair` DISABLE KEYS */;
/*!40000 ALTER TABLE `homework_user_pair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `courseId` bigint DEFAULT NULL,
                            `materialLink` longtext NOT NULL,
                            `status` varchar(45) NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fk_Material_course1_idx` (`courseId`),
                            CONSTRAINT `fk_Material_course1` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `newsTitle` varchar(45) NOT NULL,
                        `newsDesc` longtext,
                        `newsLink` longtext NOT NULL,
                        `authorId` bigint NOT NULL,
                        `status` varchar(45) NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_news_user1_idx` (`authorId`),
                        CONSTRAINT `fk_news_user1` FOREIGN KEY (`authorId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_log`
--

DROP TABLE IF EXISTS `price_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price_log` (
                             `id` bigint NOT NULL,
                             `courseId` bigint NOT NULL,
                             `price` double NOT NULL,
                             `isCurrent` bit(1) DEFAULT NULL,
                             `isPromotion` bit(1) DEFAULT NULL,
                             `promotionType` varchar(45) DEFAULT NULL,
                             `promotionAmount` double DEFAULT NULL,
                             `promotionDesc` longtext,
                             `validFrom` datetime DEFAULT NULL,
                             `validTo` datetime DEFAULT NULL,
                             `status` varchar(45) NOT NULL,
                             PRIMARY KEY (`id`),
                             KEY `fk_promotion_course1_idx` (`courseId`),
                             CONSTRAINT `fk_promotion_course1` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_log`
--

LOCK TABLES `price_log` WRITE;
/*!40000 ALTER TABLE `price_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `price_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `province` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `countryId` bigint NOT NULL,
                            `provinceName` varchar(255) NOT NULL,
                            `status` varchar(45) NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fk_province_country_idx` (`countryId`),
                            CONSTRAINT `fk_province_country` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `requesterId` bigint NOT NULL,
                           `requestName` varchar(45) NOT NULL,
                           `requestType` varchar(45) NOT NULL,
                           `requestDesc` longtext,
                           `resolverId` bigint DEFAULT NULL,
                           `status` varchar(45) NOT NULL,
                           PRIMARY KEY (`id`),
                           KEY `fk_request_user1_idx` (`requesterId`),
                           KEY `fk_request_user2_idx` (`resolverId`),
                           CONSTRAINT `fk_request_user1_requester` FOREIGN KEY (`requesterId`) REFERENCES `user` (`id`),
                           CONSTRAINT `fk_request_user2_resolver` FOREIGN KEY (`resolverId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `roleName` varchar(45) NOT NULL,
                        `roleDesc` longtext,
                        `status` varchar(45) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'user','user','CREATED');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `classId` bigint NOT NULL,
                            `date` date NOT NULL,
                            `slot` int NOT NULL,
                            `scheduleDesc` longtext,
                            `status` varchar(45) NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fk_schedule_class1_idx` (`classId`),
                            CONSTRAINT `fk_schedule_class1` FOREIGN KEY (`classId`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_user_pair`
--

DROP TABLE IF EXISTS `schedule_user_pair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule_user_pair` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `scheduleId` bigint NOT NULL,
                                      `userId` bigint NOT NULL,
                                      `status` varchar(45) NOT NULL,
                                      PRIMARY KEY (`id`),
                                      KEY `fk_schedule_user_pair_user1_idx` (`userId`),
                                      KEY `fk_schedule_user_pair_schedule1_idx` (`scheduleId`),
                                      CONSTRAINT `fk_schedule_user_pair_schedule1` FOREIGN KEY (`scheduleId`) REFERENCES `schedule` (`id`),
                                      CONSTRAINT `fk_schedule_user_pair_user1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_user_pair`
--

LOCK TABLES `schedule_user_pair` WRITE;
/*!40000 ALTER TABLE `schedule_user_pair` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_user_pair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_request`
--

DROP TABLE IF EXISTS `teacher_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_request` (
                                   `Id` int NOT NULL AUTO_INCREMENT,
                                   `userId` bigint NOT NULL,
                                   `requestName` varchar(100) DEFAULT NULL,
                                   `requestType` varchar(100) DEFAULT NULL,
                                   `requestContent` varchar(100) DEFAULT NULL,
                                   `contentLink` varchar(100) DEFAULT NULL,
                                   `requestDesc` varchar(100) DEFAULT NULL,
                                   `status` varchar(100) DEFAULT NULL,
                                   PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_request`
--

LOCK TABLES `teacher_request` WRITE;
/*!40000 ALTER TABLE `teacher_request` DISABLE KEYS */;
INSERT INTO `teacher_request` VALUES (1,2,'Request apply Teacher2023-06-18-135121841_736','APPLICATION',NULL,NULL,NULL,'CREATED'),(2,2,'Request apply Teacher 2023-06-18-13-54-14_912','APPLICATION',NULL,NULL,'a','CREATED'),(3,2,'Request apply Teacher 18-06-2023:13-59-02','APPLICATION',NULL,NULL,'a','CREATED'),(4,2,'Request apply Teacher 18-06-2023:13-59-38','APPLICATION',NULL,NULL,'v','CREATED'),(5,2,'Request apply Teacher 18-06-2023:14-00-07','APPLICATION',NULL,NULL,'v','CREATED'),(6,2,'Request apply Teacher 18-06-2023:14-00-22','APPLICATION','v',NULL,'v','CREATED');
/*!40000 ALTER TABLE `teacher_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `classId` bigint NOT NULL,
                        `testName` varchar(45) NOT NULL,
                        `testDesc` longtext,
                        `status` varchar(45) NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_test_class1_idx` (`classId`),
                        CONSTRAINT `fk_test_class1` FOREIGN KEY (`classId`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_user_pair`
--

DROP TABLE IF EXISTS `test_user_pair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test_user_pair` (
                                  `id` bigint NOT NULL AUTO_INCREMENT,
                                  `testId` bigint NOT NULL,
                                  `userId` bigint NOT NULL,
                                  `score` float DEFAULT NULL,
                                  `status` varchar(45) NOT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `fk_test_user_pair_user1_idx` (`userId`),
                                  KEY `fk_test_user_pair_test1_idx` (`testId`),
                                  CONSTRAINT `fk_test_user_pair_test1` FOREIGN KEY (`testId`) REFERENCES `test` (`id`),
                                  CONSTRAINT `fk_test_user_pair_user1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_user_pair`
--

LOCK TABLES `test_user_pair` WRITE;
/*!40000 ALTER TABLE `test_user_pair` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_user_pair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `roleId` bigint NOT NULL,
                        `parentId` bigint DEFAULT NULL,
                        `username` varchar(45) NOT NULL,
                        `password` varchar(255) NOT NULL,
                        `fullName` varchar(255) NOT NULL,
                        `email` varchar(255) DEFAULT NULL,
                        `phone` varchar(10) DEFAULT NULL,
                        `addressId` bigint DEFAULT NULL,
                        `status` varchar(45) NOT NULL,
                        `reset_password_token` varchar(100) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_user_role_idx` (`roleId`),
                        KEY `fk_user_user1_idx` (`parentId`),
                        KEY `fk_user_address_idx` (`addressId`),
                        CONSTRAINT `fk_user_address` FOREIGN KEY (`addressId`) REFERENCES `address` (`id`),
                        CONSTRAINT `fk_user_role` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`),
                        CONSTRAINT `fk_user_user_parent_child` FOREIGN KEY (`parentId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,NULL,'mrd','mrd','mrd','mrd','123',NULL,'CREATED',NULL),(2,1,NULL,'duong123','duong123','duong123','duong123@gmail.com',NULL,NULL,'CREATED',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_class_pair`
--

DROP TABLE IF EXISTS `user_class_pair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_class_pair` (
                                   `id` bigint NOT NULL AUTO_INCREMENT,
                                   `userId` bigint NOT NULL,
                                   `classId` bigint NOT NULL,
                                   `status` varchar(45) NOT NULL,
                                   PRIMARY KEY (`id`),
                                   KEY `fk_user_has_class_class1_idx` (`classId`),
                                   KEY `fk_user_has_class_user1_idx` (`userId`),
                                   CONSTRAINT `fk_user_class_pair_class1` FOREIGN KEY (`classId`) REFERENCES `classroom` (`id`),
                                   CONSTRAINT `fk_user_class_pair_user1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_class_pair`
--

LOCK TABLES `user_class_pair` WRITE;
/*!40000 ALTER TABLE `user_class_pair` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_class_pair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_course_pair`
--

DROP TABLE IF EXISTS `user_course_pair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_course_pair` (
                                    `id` bigint NOT NULL AUTO_INCREMENT,
                                    `userId` bigint NOT NULL,
                                    `courseId` bigint NOT NULL,
                                    `status` varchar(45) NOT NULL,
                                    PRIMARY KEY (`id`),
                                    KEY `fk_user_has_course_course1_idx` (`courseId`),
                                    KEY `fk_user_has_course_user1_idx` (`userId`),
                                    CONSTRAINT `fk_user_course_pair_course1` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`),
                                    CONSTRAINT `fk_user_course_pair_user1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_course_pair`
--

LOCK TABLES `user_course_pair` WRITE;
/*!40000 ALTER TABLE `user_course_pair` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_course_pair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ward`
--

DROP TABLE IF EXISTS `ward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ward` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `districtId` bigint NOT NULL,
                        `wardName` varchar(255) NOT NULL,
                        `status` varchar(45) NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_ward_district_idx` (`districtId`),
                        CONSTRAINT `fk_ward_district` FOREIGN KEY (`districtId`) REFERENCES `district` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ward`
--

LOCK TABLES `ward` WRITE;
/*!40000 ALTER TABLE `ward` DISABLE KEYS */;
/*!40000 ALTER TABLE `ward` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-18 14:02:38
