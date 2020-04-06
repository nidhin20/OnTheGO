-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: onthegodev.cejfldd25qcf.us-west-2.rds.amazonaws.com    Database: dbo
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `PeakTime`
--

DROP TABLE IF EXISTS `PeakTime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PeakTime` (
  `Peak_Time_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Curr_Date` date DEFAULT NULL,
  `Day` varchar(45) DEFAULT NULL,
  `First_Peak_Hour` int(10) DEFAULT NULL,
  `Second_Peak_Hour` int(10) DEFAULT NULL,
  PRIMARY KEY (`Peak_Time_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PeakTime`
--

LOCK TABLES `PeakTime` WRITE;
/*!40000 ALTER TABLE `PeakTime` DISABLE KEYS */;
INSERT INTO `PeakTime` VALUES (1,NULL,'Tuesday',21,5),(2,NULL,'Tuesday',21,5),(3,'2019-11-19','Tuesday',21,5),(4,'2019-11-19','Tuesday',21,5),(5,'2019-11-23','Saturday',19,0),(6,'2019-11-25','Monday',0,0),(7,'2019-11-25','Monday',0,0),(8,'2019-12-04','Wednesday',0,0),(9,'2019-12-05','Thursday',0,0),(10,'2019-12-06','Friday',0,0),(11,'2019-12-07','Saturday',17,13);
/*!40000 ALTER TABLE `PeakTime` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-07 18:17:19
