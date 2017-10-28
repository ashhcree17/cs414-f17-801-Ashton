-- MySQL dump 10.13  Distrib 5.7.20, for osx10.13 (x86_64)
--
-- Host: localhost    Database: globo_gym_db
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Address` (
  `addressId` int(11) NOT NULL,
  `street1` varchar(45) DEFAULT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zipCode` int(11) DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `customerId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `insurance` varchar(45) DEFAULT NULL,
  `membership` enum('ACTIVE','INACTIVE') DEFAULT NULL,
  `customerAddressId` int(11) DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  KEY `addressId_idx` (`customerAddressId`),
  CONSTRAINT `customerAddressId` FOREIGN KEY (`customerAddressId`) REFERENCES `Address` (`addressId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer_Routine`
--

DROP TABLE IF EXISTS `Customer_Routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer_Routine` (
  `customerId` int(11) NOT NULL,
  `routineId` int(11) NOT NULL,
  PRIMARY KEY (`customerId`,`routineId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer_Routine`
--

LOCK TABLES `Customer_Routine` WRITE;
/*!40000 ALTER TABLE `Customer_Routine` DISABLE KEYS */;
/*!40000 ALTER TABLE `Customer_Routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipment`
--

DROP TABLE IF EXISTS `Equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Equipment` (
  `equipmentId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `picture` longblob,
  `quantity` int(11) DEFAULT NULL,
  `equipmentExerciseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`equipmentId`),
  KEY `exerciseId_idx` (`equipmentExerciseId`),
  CONSTRAINT `equipmentExerciseId` FOREIGN KEY (`equipmentExerciseId`) REFERENCES `Exercise` (`exerciseId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipment`
--

LOCK TABLES `Equipment` WRITE;
/*!40000 ALTER TABLE `Equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Exercise`
--

DROP TABLE IF EXISTS `Exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Exercise` (
  `exerciseId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `duration` time(6) DEFAULT NULL,
  `numberOfSets` int(11) DEFAULT NULL,
  `repetitionsPerSet` int(11) DEFAULT NULL,
  PRIMARY KEY (`exerciseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Exercise`
--

LOCK TABLES `Exercise` WRITE;
/*!40000 ALTER TABLE `Exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `Exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Exercise_Equipment`
--

DROP TABLE IF EXISTS `Exercise_Equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Exercise_Equipment` (
  `equipmentId` int(11) NOT NULL,
  `exerciseId` int(11) NOT NULL,
  PRIMARY KEY (`equipmentId`,`exerciseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Exercise_Equipment`
--

LOCK TABLES `Exercise_Equipment` WRITE;
/*!40000 ALTER TABLE `Exercise_Equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Exercise_Equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Exercise_Routine`
--

DROP TABLE IF EXISTS `Exercise_Routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Exercise_Routine` (
  `routineId` int(11) NOT NULL,
  `exerciseId` int(11) NOT NULL,
  PRIMARY KEY (`routineId`,`exerciseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Exercise_Routine`
--

LOCK TABLES `Exercise_Routine` WRITE;
/*!40000 ALTER TABLE `Exercise_Routine` DISABLE KEYS */;
/*!40000 ALTER TABLE `Exercise_Routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Manager`
--

DROP TABLE IF EXISTS `Manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Manager` (
  `managerId` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `managerAddressId` int(11) DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `insurance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`managerId`),
  KEY `addressId_idx` (`managerAddressId`),
  CONSTRAINT `managerAddressId` FOREIGN KEY (`managerAddressId`) REFERENCES `Address` (`addressId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Manager`
--

LOCK TABLES `Manager` WRITE;
/*!40000 ALTER TABLE `Manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `Manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Qualification`
--

DROP TABLE IF EXISTS `Qualification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Qualification` (
  `qualId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`qualId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Qualification`
--

LOCK TABLES `Qualification` WRITE;
/*!40000 ALTER TABLE `Qualification` DISABLE KEYS */;
/*!40000 ALTER TABLE `Qualification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Routine`
--

DROP TABLE IF EXISTS `Routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Routine` (
  `routineId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`routineId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Routine`
--

LOCK TABLES `Routine` WRITE;
/*!40000 ALTER TABLE `Routine` DISABLE KEYS */;
/*!40000 ALTER TABLE `Routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Trainer`
--

DROP TABLE IF EXISTS `Trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Trainer` (
  `trainerId` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `trainerAddressId` int(11) DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `insurance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trainerId`),
  KEY `addressId_idx` (`trainerAddressId`),
  CONSTRAINT `trainerAddressId` FOREIGN KEY (`trainerAddressId`) REFERENCES `Address` (`addressId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Trainer`
--

LOCK TABLES `Trainer` WRITE;
/*!40000 ALTER TABLE `Trainer` DISABLE KEYS */;
/*!40000 ALTER TABLE `Trainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Trainer_Qualification`
--

DROP TABLE IF EXISTS `Trainer_Qualification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Trainer_Qualification` (
  `trainerId` int(11) NOT NULL,
  `qualId` int(11) NOT NULL,
  PRIMARY KEY (`trainerId`,`qualId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Trainer_Qualification`
--

LOCK TABLES `Trainer_Qualification` WRITE;
/*!40000 ALTER TABLE `Trainer_Qualification` DISABLE KEYS */;
/*!40000 ALTER TABLE `Trainer_Qualification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WorkSchedule`
--

DROP TABLE IF EXISTS `WorkSchedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WorkSchedule` (
  `workScheduleId` int(11) NOT NULL,
  `day` varchar(45) DEFAULT NULL,
  `startTime` time(6) DEFAULT NULL,
  `endTime` time(6) DEFAULT NULL,
  `workScheduleTrainerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`workScheduleId`),
  KEY `trainerId_idx` (`workScheduleTrainerId`),
  CONSTRAINT `workScheduleTrainerId` FOREIGN KEY (`workScheduleTrainerId`) REFERENCES `Trainer` (`trainerId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WorkSchedule`
--

LOCK TABLES `WorkSchedule` WRITE;
/*!40000 ALTER TABLE `WorkSchedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `WorkSchedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-27 21:30:19
