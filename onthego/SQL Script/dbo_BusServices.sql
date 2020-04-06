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
-- Table structure for table `BusServices`
--

DROP TABLE IF EXISTS `BusServices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BusServices` (
  `Bus_Srvc_Id` int(11) NOT NULL,
  `Bus_Route_Id` int(11) DEFAULT NULL,
  `Bus_Type_Id` int(11) DEFAULT NULL,
  `Servc_Prvdr_Id` int(11) DEFAULT NULL,
  `Bus_Start_Time` time DEFAULT NULL,
  `Created_By` int(11) DEFAULT NULL,
  `Created_Date` datetime DEFAULT NULL,
  `Updated_By` int(11) DEFAULT NULL,
  `Updated_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`Bus_Srvc_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BusServices`
--

LOCK TABLES `BusServices` WRITE;
/*!40000 ALTER TABLE `BusServices` DISABLE KEYS */;
INSERT INTO `BusServices` VALUES (1,304,1,1,'07:40:00',0,'2019-11-12 00:00:00',0,'2019-11-12 00:00:00');
/*!40000 ALTER TABLE `BusServices` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-07 18:17:10
