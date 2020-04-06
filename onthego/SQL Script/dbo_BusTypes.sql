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
-- Table structure for table `BusTypes`
--

DROP TABLE IF EXISTS `BusTypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BusTypes` (
  `Bus_Type_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Bus_Type_Nm` varchar(255) DEFAULT NULL,
  `Seat_Capacity` int(11) DEFAULT NULL,
  `Standing_Capacity` int(11) DEFAULT NULL,
  `Created_By` varchar(255) DEFAULT NULL,
  `Created_Date` datetime DEFAULT NULL,
  `Updated_By` varchar(255) DEFAULT NULL,
  `Updated_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`Bus_Type_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BusTypes`
--

LOCK TABLES `BusTypes` WRITE;
/*!40000 ALTER TABLE `BusTypes` DISABLE KEYS */;
INSERT INTO `BusTypes` VALUES (1,'alexander dennis enviro 200',36,20,'10','2019-11-12 00:00:00','10','2019-11-12 00:00:00'),(2,'Scania',30,15,'10','2019-11-12 00:00:00','10','2019-11-12 00:00:00'),(3,'Renault',40,25,'10','2019-11-12 00:00:00','10','2019-11-12 00:00:00'),(4,'Mercedez Benz',25,10,'10','2019-11-12 00:00:00','10','2019-11-12 00:00:00'),(5,'Volvo',30,20,'10','2019-11-12 00:00:00','10','2019-11-12 00:00:00'),(6,'Izuzu',35,15,'10','2019-11-12 00:00:00','10','2019-11-12 00:00:00'),(7,'Volvo 2',50,20,'10','2019-12-07 01:57:49','0',NULL);
/*!40000 ALTER TABLE `BusTypes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-07 18:17:14
