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
-- Table structure for table `SubscriptionPlan`
--

DROP TABLE IF EXISTS `SubscriptionPlan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubscriptionPlan` (
  `Plan_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Plan_Nm` varchar(255) DEFAULT NULL,
  `Card_Category` varchar(255) DEFAULT NULL,
  `Default_plan` bit(1) DEFAULT NULL,
  `Sub_Period` int(11) DEFAULT NULL,
  `Discount_rate` float DEFAULT NULL,
  `Is_Subs_Active` bit(1) DEFAULT NULL,
  `Created_By` int(11) DEFAULT NULL,
  `Created_Date` datetime DEFAULT NULL,
  `Updated_By` int(11) DEFAULT NULL,
  `Updated_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`Plan_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubscriptionPlan`
--

LOCK TABLES `SubscriptionPlan` WRITE;
/*!40000 ALTER TABLE `SubscriptionPlan` DISABLE KEYS */;
INSERT INTO `SubscriptionPlan` VALUES (1,'Monthly','STU',_binary '',30,20,_binary '\0',10,'2019-12-06 21:13:50',10,'2019-12-06 21:13:50'),(2,'Monthly','GEN',_binary '\0',30,25,_binary '\0',10,'2019-12-01 12:48:14',10,'2019-12-01 12:48:14'),(3,'Monthly','GEN',_binary '\0',60,50,_binary '',10,'2019-12-01 12:49:29',10,'2019-12-01 12:49:29'),(4,'Monthly','GEN',_binary '\0',45,30,_binary '',10,'2019-12-01 12:57:41',10,'2019-12-01 12:57:41'),(5,'Weekly','STU',_binary '\0',7,20,_binary '\0',10,'2019-12-01 13:00:53',10,'2019-12-01 13:00:53'),(6,'Weekly','STU',_binary '\0',7,15,_binary '',10,'2019-12-01 13:02:17',10,'2019-12-01 13:02:17'),(7,'Monthly','STU',_binary '\0',30,30,_binary '',10,'2019-12-01 13:04:14',10,'2019-12-01 13:04:14'),(8,'Monthly','STU',_binary '\0',45,35,_binary '',10,'2019-12-01 13:06:46',10,'2019-12-01 13:06:46'),(9,'Monthly','STU',_binary '\0',60,40,_binary '',10,'2019-12-01 13:20:19',10,'2019-12-01 13:20:19'),(19,'Monthly','STU',_binary '',50,20,_binary '\0',10,'2019-12-06 22:37:09',10,'2019-12-06 22:37:09'),(20,'Monthly','STU',_binary '',80,20,_binary '\0',10,'2019-12-06 22:38:52',10,'2019-12-06 22:38:52'),(21,'Monthly','STU',_binary '',80,40,_binary '\0',10,'2019-12-06 22:40:54',10,'2019-12-06 22:40:54'),(22,'Monthly','STU',_binary '',80,40,_binary '\0',10,'2019-12-06 22:46:37',10,'2019-12-06 22:46:37');
/*!40000 ALTER TABLE `SubscriptionPlan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-07 18:17:43
