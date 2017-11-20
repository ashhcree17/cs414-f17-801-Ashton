-- MySQL dump 10.13  Distrib 5.7.20, for osx10.13 (x86_64)
--
-- Host: localhost    Database: globogym
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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `addressid` int(11) NOT NULL,
  `street1` varchar(45) DEFAULT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zipcode` int(11) DEFAULT NULL,
  PRIMARY KEY (`addressid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (0,'123 Main St','Apt 123','Denver','CO',12345),(1,'123 Main St','Apt 123','Denver','CO',12345),(2,'123 Main St','Apt 123','Denver','CO',12345),(3,'123 Main St','Apt 123','Denver','CO',12345),(4,'123 Main St','Apt 123','Denver','CO',12345),(5,'123 Main St','Apt 123','Denver','CO',12345),(45,'123 Main St','Apt 123','Denver','CO',12345),(46,'123 Main St','Apt 123','Denver','CO',12345),(47,'123 Main St','Apt 123','Denver','CO',12345),(48,'123 Main St','Apt 123','Denver','CO',12345),(49,'123 Main St','Apt 123','Denver','CO',12345),(2214,'123 Main St','Apt 123','Denver','CO',12345),(4704,'123 Main St','Apt 123','Denver','CO',12345),(12345,'123 Main St','Apt 123','Denver','CO',12345),(12355,'123 Main St','Apt 123','Denver','CO',12345),(12365,'123 Main St','Apt 123','Denver','CO',12345),(12375,'123 Main St','Apt 123','Denver','CO',12345),(12385,'123 Main St','Apt 123','Denver','CO',12345),(12395,'123 Main St','Apt 123','Denver','CO',12345),(12405,'123 Main St','Apt 123','Denver','CO',12345),(12415,'123 Main St','Apt 123','Denver','CO',12345),(12425,'123 Main St','Apt 123','Denver','CO',12345),(12435,'123 Main St','Apt 123','Denver','CO',12345),(12585,'123 Main St','Apt 123','Denver','CO',12345),(12595,'123 Main St','Apt 123','Denver','CO',12345),(12605,'123 Main St','Apt 123','Denver','CO',12345),(12615,'123 Main St','Apt 123','Denver','CO',12345),(12625,'123 Main St','Apt 123','Denver','CO',12345),(12635,'123 Main St','Apt 123','Denver','CO',12345),(12645,'123 Main St','Apt 123','Denver','CO',12345),(12655,'123 Main St','Apt 123','Denver','CO',12345),(12665,'123 Main St','Apt 123','Denver','CO',12345),(12675,'123 Main St','Apt 123','Denver','CO',12345),(12685,'123 Main St','Apt 123','Denver','CO',12345),(12695,'123 Main St','Apt 123','Denver','CO',12345),(12705,'123 Main St','Apt 123','Denver','CO',12345),(470434,'123 Main St','Apt 123','Denver','CO',12345),(470454,'123 Main St','Apt 123','Denver','CO',12345),(470474,'123 Main St','Apt 123','Denver','CO',12345),(74589745,'123 Main St','Apt 123','Denver','CO',12345);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `phonenumber` int(11) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `insurance` varchar(45) DEFAULT NULL,
  `membership` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(3,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(45,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(46,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(47,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(48,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(49,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2234,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2244,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2254,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2264,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2274,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2284,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2294,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2304,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2314,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2324,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2334,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2344,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2354,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2504,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2514,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2524,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2534,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2544,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2554,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2564,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2574,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2584,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2594,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2604,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2614,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE'),(2624,'Joe','Smith',1234567890,'joesmith@email.com','Aetna','ACTIVE');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `equipmentid` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`equipmentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (1,'Barbell',12),(3,'Barbell',12),(4,'Barbell',12),(5,'Barbell',12),(6,'Barbell',12),(7,'Barbell',12),(8,'Barbell',12),(9,'Barbell',12),(10,'Barbell',12),(111,'Barbell',12),(2234,'Barbell',12),(90046,'Barbell',12),(90056,'Barbell',12),(90076,'Barbell',12),(90086,'Barbell',12),(90096,'Barbell',12),(90106,'Barbell',12),(90116,'Barbell',12),(90126,'Barbell',12),(90136,'Barbell',12),(90146,'Barbell',12),(90156,'Barbell',12),(90166,'Barbell',12),(90176,'Barbell',12),(98756,'Barbell',12),(98766,'Barbell',12),(98796,'Barbell',12),(98806,'Barbell',12),(98816,'Barbell',12),(98826,'Barbell',12),(98836,'Barbell',12),(98846,'Barbell',12),(98856,'Barbell',12),(98866,'Barbell',12),(98876,'Barbell',12),(98886,'Barbell',12),(98896,'Barbell',12),(98906,'Barbell',12);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise` (
  `exerciseid` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `numberOfSets` int(11) DEFAULT NULL,
  `repsPerSet` int(11) DEFAULT NULL,
  PRIMARY KEY (`exerciseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'Barbell Exercise',360,NULL,NULL),(2,'Dumbbell Exercise',NULL,3,12),(3,'Barbell Exercise',360,NULL,NULL),(4,'Dumbbell Exercise',NULL,3,12),(5,'Barbell Exercise',360,NULL,NULL),(6,'Dumbbell Exercise',NULL,3,12),(45,'Barbell Exercise',360,NULL,NULL),(46,'Dumbbell Exercise',NULL,3,12),(47,'Barbell Exercise',360,NULL,NULL),(48,'Dumbbell Exercise',NULL,3,12),(49,'Barbell Exercise',360,NULL,NULL),(50,'Dumbbell Exercise',NULL,3,12),(51,'Barbell Exercise',360,NULL,NULL),(52,'Dumbbell Exercise',NULL,3,12),(53,'Barbell Exercise',360,NULL,NULL),(54,'Dumbbell Exercise',NULL,3,12),(2572,'Dumbbell Exercise',NULL,3,12),(2582,'Dumbbell Exercise',NULL,3,12),(2592,'Dumbbell Exercise',NULL,3,12),(2602,'Dumbbell Exercise',NULL,3,12),(2612,'Dumbbell Exercise',NULL,3,12),(2622,'Dumbbell Exercise',NULL,3,12),(2632,'Dumbbell Exercise',NULL,3,12),(2642,'Dumbbell Exercise',NULL,3,12),(2652,'Dumbbell Exercise',NULL,3,12),(2662,'Dumbbell Exercise',NULL,3,12),(2672,'Dumbbell Exercise',NULL,3,12),(2832,'Dumbbell Exercise',NULL,3,12),(2842,'Dumbbell Exercise',NULL,3,12),(2852,'Dumbbell Exercise',NULL,3,12),(2862,'Dumbbell Exercise',NULL,3,12),(2872,'Dumbbell Exercise',NULL,3,12),(2882,'Dumbbell Exercise',NULL,3,12),(2892,'Dumbbell Exercise',NULL,3,12),(2902,'Dumbbell Exercise',NULL,3,12),(2912,'Dumbbell Exercise',NULL,3,12),(2922,'Dumbbell Exercise',NULL,3,12),(2932,'Dumbbell Exercise',NULL,3,12),(2942,'Dumbbell Exercise',NULL,3,12),(2952,'Dumbbell Exercise',NULL,3,12),(4704,'Barbell Exercise',360,NULL,NULL),(4714,'Barbell Exercise',360,NULL,NULL),(4724,'Barbell Exercise',360,NULL,NULL),(4734,'Barbell Exercise',360,NULL,NULL),(4744,'Barbell Exercise',360,NULL,NULL),(4754,'Barbell Exercise',360,NULL,NULL),(4764,'Barbell Exercise',360,NULL,NULL),(4774,'Barbell Exercise',360,NULL,NULL),(4784,'Barbell Exercise',360,NULL,NULL),(4794,'Barbell Exercise',360,NULL,NULL),(4804,'Barbell Exercise',360,NULL,NULL),(4814,'Barbell Exercise',360,NULL,NULL),(4824,'Barbell Exercise',360,NULL,NULL),(4834,'Barbell Exercise',360,NULL,NULL),(4974,'Barbell Exercise',360,NULL,NULL),(4984,'Barbell Exercise',360,NULL,NULL),(4994,'Barbell Exercise',360,NULL,NULL),(5004,'Barbell Exercise',360,NULL,NULL),(5014,'Barbell Exercise',360,NULL,NULL),(5024,'Barbell Exercise',360,NULL,NULL),(5034,'Barbell Exercise',360,NULL,NULL),(5044,'Barbell Exercise',360,NULL,NULL),(5054,'Barbell Exercise',360,NULL,NULL),(5064,'Barbell Exercise',360,NULL,NULL),(5074,'Barbell Exercise',360,NULL,NULL),(5084,'Barbell Exercise',360,NULL,NULL),(5094,'Barbell Exercise',360,NULL,NULL);
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `managerid` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `phonenumber` int(11) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `insurance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`managerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(2,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(3,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(45,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(46,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(47,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(48,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(49,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5517,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5527,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5537,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5547,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5557,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5567,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5577,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5587,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5597,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5607,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5617,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5627,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5637,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5787,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5797,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5807,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5817,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5827,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5837,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5847,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5857,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5867,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5877,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5887,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5897,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5907,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(5917,'joesmith','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qualification`
--

DROP TABLE IF EXISTS `qualification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qualification` (
  `qualificationid` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`qualificationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qualification`
--

LOCK TABLES `qualification` WRITE;
/*!40000 ALTER TABLE `qualification` DISABLE KEYS */;
INSERT INTO `qualification` VALUES (1,'CPR Certified'),(2,'CPR Certified'),(3,'CPR Certified'),(45,'CPR Certified'),(46,'CPR Certified'),(47,'CPR Certified'),(48,'CPR Certified'),(49,'CPR Certified'),(2194,'CPR Certified'),(2204,'CPR Certified'),(2214,'CPR Certified'),(2224,'CPR Certified'),(2234,'CPR Certified'),(2244,'CPR Certified'),(2254,'CPR Certified'),(2264,'CPR Certified'),(2274,'CPR Certified'),(2284,'CPR Certified'),(2294,'CPR Certified'),(2304,'CPR Certified'),(2314,'CPR Certified'),(2324,'CPR Certified'),(2464,'CPR Certified'),(2474,'CPR Certified'),(2484,'CPR Certified'),(2494,'CPR Certified'),(2504,'CPR Certified'),(2514,'CPR Certified'),(2524,'CPR Certified'),(2534,'CPR Certified'),(2544,'CPR Certified'),(2554,'CPR Certified'),(2564,'CPR Certified'),(2574,'CPR Certified'),(2584,'CPR Certified');
/*!40000 ALTER TABLE `qualification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routine`
--

DROP TABLE IF EXISTS `routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `routine` (
  `routineid` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`routineid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routine`
--

LOCK TABLES `routine` WRITE;
/*!40000 ALTER TABLE `routine` DISABLE KEYS */;
INSERT INTO `routine` VALUES (1,'Example'),(2,'Example'),(3,'Example'),(45,'Example'),(46,'Example'),(47,'Example'),(48,'Example'),(49,'Example'),(2224,'Example'),(2234,'Example'),(2244,'Example'),(2254,'Example'),(2264,'Example'),(2274,'Example'),(2284,'Example'),(2294,'Example'),(2304,'Example'),(2314,'Example'),(2324,'Example'),(2334,'Example'),(2344,'Example'),(2354,'Example'),(2494,'Example'),(2504,'Example'),(2514,'Example'),(2524,'Example'),(2534,'Example'),(2544,'Example'),(2554,'Example'),(2564,'Example'),(2574,'Example'),(2584,'Example'),(2594,'Example'),(2604,'Example'),(2614,'Example');
/*!40000 ALTER TABLE `routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer`
--

DROP TABLE IF EXISTS `trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainer` (
  `trainerid` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `phonenumber` int(11) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `insurance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trainerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer`
--

LOCK TABLES `trainer` WRITE;
/*!40000 ALTER TABLE `trainer` DISABLE KEYS */;
INSERT INTO `trainer` VALUES (6789884,NULL,NULL,'Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(6789894,NULL,NULL,'Joe','Smith',1234567890,'joesmith@email.com','Aetna'),(6789904,'joesmith12','iLOVEtheGYM21','Joe','Smith',1234567890,'joesmith@email.com','Aetna');
/*!40000 ALTER TABLE `trainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workSchedule`
--

DROP TABLE IF EXISTS `workSchedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workSchedule` (
  `workScheduleid` int(11) NOT NULL,
  `day` date DEFAULT NULL,
  `startTime` varchar(45) DEFAULT NULL,
  `endTime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`workScheduleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workSchedule`
--

LOCK TABLES `workSchedule` WRITE;
/*!40000 ALTER TABLE `workSchedule` DISABLE KEYS */;
INSERT INTO `workSchedule` VALUES (1,'2017-11-20','10:30 AM','06:30 PM'),(2,'2017-11-20','10:30 AM','06:30 PM'),(3,'2017-11-20','10:30 AM','06:30 PM'),(45,'2017-11-20','10:30 AM','06:30 PM'),(46,'2017-11-20','10:30 AM','06:30 PM'),(47,'2017-11-20','10:30 AM','06:30 PM'),(48,'2017-11-20','10:30 AM','06:30 PM'),(49,'2017-11-20','10:30 AM','06:30 PM'),(2294,'2017-11-20','10:30 AM','06:30 PM'),(2304,'2017-11-20','10:30 AM','06:30 PM'),(2314,'2017-11-20','10:30 AM','06:30 PM'),(2324,'2017-11-20','10:30 AM','06:30 PM'),(2334,'2017-11-20','10:30 AM','06:30 PM'),(2344,'2017-11-20','10:30 AM','06:30 PM'),(2354,'2017-11-20','10:30 AM','06:30 PM'),(2364,'2017-11-20','10:30 AM','06:30 PM'),(2374,'2017-11-20','10:30 AM','06:30 PM'),(2384,'2017-11-20','10:30 AM','06:30 PM'),(2394,'2017-11-20','10:30 AM','06:30 PM'),(2404,'2017-11-20','10:30 AM','06:30 PM'),(2414,'2017-11-20','10:30 AM','06:30 PM'),(2424,'2017-11-20','10:30 AM','06:30 PM'),(2464,'2017-11-20','10:30 AM','06:30 PM'),(2474,'2017-11-20','10:30 AM','06:30 PM'),(2484,'2017-11-20','10:30 AM','06:30 PM'),(2494,'2017-11-20','10:30 AM','06:30 PM'),(2504,'2017-11-20','10:30 AM','06:30 PM'),(2514,'2017-11-20','10:30 AM','06:30 PM'),(2524,'2017-11-20','10:30 AM','06:30 PM'),(2534,'2017-11-20','10:30 AM','06:30 PM'),(2544,'2017-11-20','10:30 AM','06:30 PM'),(2554,'2017-11-20','10:30 AM','06:30 PM'),(2564,'2017-11-20','10:30 AM','06:30 PM'),(2574,'2017-11-20','10:30 AM','06:30 PM'),(2584,'2017-11-20','10:30 AM','06:30 PM');
/*!40000 ALTER TABLE `workSchedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-20 12:46:42
