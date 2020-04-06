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
-- Table structure for table `CardHistory`
--

DROP TABLE IF EXISTS `CardHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CardHistory` (
  `Card_History_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Card_Id` int(11) DEFAULT NULL,
  `Is_Debit` bit(1) DEFAULT NULL,
  `Amount` float DEFAULT NULL,
  `Bus_Servce_Id` int(11) DEFAULT NULL,
  `Check_In_BusStop` int(11) DEFAULT NULL,
  `Check_In` datetime DEFAULT NULL,
  `Day_Of_Week` varchar(45) DEFAULT NULL,
  `Check_Out_BusStop` int(11) DEFAULT NULL,
  `Check_Out` datetime DEFAULT NULL,
  `Reference` varchar(45) DEFAULT NULL,
  `Created_By` int(11) DEFAULT NULL,
  `Created_Date` datetime DEFAULT NULL,
  `Updated_By` int(11) DEFAULT NULL,
  `Updated_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`Card_History_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CardHistory`
--

LOCK TABLES `CardHistory` WRITE;
/*!40000 ALTER TABLE `CardHistory` DISABLE KEYS */;
INSERT INTO `CardHistory` VALUES (1,1,_binary '',0,1,1,'2019-11-16 19:32:01','Saturday',0,NULL,NULL,0,NULL,0,NULL),(2,1,_binary '',0,1,1,'2019-11-16 19:33:19','Saturday',0,NULL,NULL,0,NULL,0,NULL),(3,1,_binary '',0.014,1,1,'2019-11-17 13:02:45','Sunday',2,'2019-11-17 19:47:48',NULL,0,NULL,0,NULL),(5,1,_binary '',0,1,1,'2019-11-18 21:31:22','Tuesday',0,NULL,NULL,0,NULL,0,NULL),(6,1,_binary '',0.014,1,1,'2019-11-18 21:31:30','Tuesday',2,'2019-11-18 21:31:54',NULL,0,NULL,0,NULL),(7,1,NULL,NULL,NULL,NULL,'2019-11-18 05:31:31','Tuesday',0,NULL,NULL,0,NULL,0,NULL),(8,NULL,NULL,NULL,NULL,NULL,'2019-11-18 05:33:33','Tuesday',0,NULL,NULL,0,NULL,0,NULL),(9,1,_binary '',0,1,1,'2019-11-19 10:55:50',NULL,0,NULL,NULL,0,NULL,0,NULL),(10,1,_binary '',0,1,1,'2019-11-19 11:16:33',NULL,0,NULL,NULL,0,NULL,0,NULL),(11,1,_binary '',0,1,1,'2019-11-19 11:20:34',NULL,0,NULL,NULL,0,NULL,0,NULL),(12,1,_binary '',0,1,1,'2019-11-19 11:25:48',NULL,0,NULL,NULL,0,NULL,0,NULL),(13,1,_binary '',0,1,2,'2019-11-30 13:22:56',NULL,0,NULL,NULL,10,'2019-11-30 13:22:56',10,'2019-11-30 13:22:56'),(14,1,_binary '',0,1,2,'2019-11-30 13:27:38',NULL,0,NULL,NULL,10,'2019-11-30 13:27:38',10,'2019-11-30 13:27:38'),(15,1,_binary '',0,1,2,'2019-11-30 13:30:08',NULL,0,NULL,NULL,10,'2019-11-30 13:30:08',10,'2019-11-30 13:30:08'),(16,1,_binary '',0,1,2,'2019-11-30 13:31:46',NULL,0,NULL,NULL,10,'2019-11-30 13:31:46',10,'2019-11-30 13:31:46'),(17,1,_binary '',0,1,2,'2019-11-30 13:32:31',NULL,0,NULL,NULL,10,'2019-11-30 13:32:31',10,'2019-11-30 13:32:31'),(18,1,_binary '',0,1,2,'2019-11-30 13:34:46','Saturday',0,NULL,NULL,10,'2019-11-30 13:34:46',10,'2019-11-30 13:34:46'),(19,1,_binary '',0,1,2,'2019-11-30 13:34:46','Saturday',2,'2019-11-30 13:37:15',NULL,10,'2019-11-30 13:34:46',10,'2019-11-30 13:34:46'),(20,1,_binary '',0,1,2,'2019-11-30 13:34:46','Saturday',2,'2019-11-30 13:37:18',NULL,10,'2019-11-30 13:34:46',10,'2019-11-30 13:34:46'),(21,1,_binary '',0,1,2,'2019-11-30 13:34:46','Saturday',3,'2019-11-30 13:40:38',NULL,10,'2019-11-30 13:34:46',10,'2019-11-30 13:34:46'),(22,1,_binary '',0,1,1,'2019-11-30 17:58:58','Saturday',0,NULL,NULL,10,'2019-11-30 17:58:58',10,'2019-11-30 17:58:58'),(23,1,_binary '',0,1,1,'2019-11-30 17:58:58','Saturday',3,'2019-11-30 18:10:59',NULL,10,'2019-11-30 17:58:58',10,'2019-11-30 17:58:58'),(24,1,_binary '',0,1,1,'2019-11-30 17:58:58','Saturday',3,'2019-11-30 18:12:44',NULL,10,'2019-11-30 17:58:58',10,'2019-11-30 17:58:58'),(25,1,_binary '',0.0196,1,1,'2019-11-30 17:58:58','Saturday',3,'2019-11-30 18:41:44',NULL,10,'2019-11-30 17:58:58',10,'2019-11-30 17:58:58'),(26,1,_binary '',0.0196,1,1,'2019-11-30 17:58:58','Saturday',3,'2019-11-30 18:53:45',NULL,10,'2019-11-30 17:58:58',10,'2019-11-30 17:58:58'),(27,1,_binary '',0.0196,1,1,'2019-11-30 17:58:58','Saturday',3,'2019-11-30 18:57:12',NULL,10,'2019-11-30 17:58:58',10,'2019-11-30 17:58:58'),(28,1,_binary '',0.0196,1,1,'2019-11-30 17:58:58','Saturday',3,'2019-11-30 18:59:20',NULL,10,'2019-11-30 17:58:58',10,'2019-11-30 17:58:58'),(29,1,_binary '',0.0196,1,1,'2019-11-30 17:58:58','Saturday',3,'2019-11-30 19:01:35',NULL,10,'2019-11-30 17:58:58',10,'2019-11-30 17:58:58'),(30,1,_binary '',0.0196,1,1,'2019-11-30 17:58:58','Saturday',3,'2019-11-30 19:17:45',NULL,10,'2019-11-30 17:58:58',10,'2019-11-30 17:58:58'),(31,1,_binary '',0,1,1,'2019-12-01 00:15:10','Sunday',0,NULL,NULL,10,'2019-12-01 00:15:10',10,'2019-12-01 00:15:10'),(32,1,_binary '',0.0196,1,1,'2019-12-01 00:30:37','Sunday',3,'2019-12-01 00:34:23',NULL,10,'2019-12-01 00:30:37',10,'2019-12-01 00:34:23'),(33,1,_binary '',0,1,1,'2019-12-01 12:39:25','Sunday',0,NULL,NULL,10,'2019-12-01 12:39:25',10,'2019-12-01 12:39:25'),(34,1,_binary '',0,1,1,'2019-12-01 14:22:26','Sunday',0,NULL,NULL,10,'2019-12-01 14:22:26',10,'2019-12-01 14:22:26'),(35,1,_binary '',0,1,1,'2019-12-01 18:18:29','Sunday',0,NULL,NULL,10,'2019-12-01 18:18:29',10,'2019-12-01 18:18:29'),(36,1,_binary '',0,1,1,'2019-12-01 18:45:04','Sunday',0,NULL,NULL,10,'2019-12-01 18:45:04',10,'2019-12-01 18:45:04'),(37,1,_binary '',0,1,1,'2019-12-02 03:32:04','Monday',0,NULL,NULL,10,'2019-12-02 03:32:04',10,'2019-12-02 03:32:04'),(38,3,_binary '',0,1,1,'2019-12-07 11:04:04','Saturday',0,NULL,NULL,10,'2019-12-07 11:04:04',10,'2019-12-07 11:04:04');
/*!40000 ALTER TABLE `CardHistory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-07 18:17:58