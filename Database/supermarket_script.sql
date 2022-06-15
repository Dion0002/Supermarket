-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: supermarket
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `add_item`
--

DROP TABLE IF EXISTS `add_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `add_item` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Item_Name` varchar(45) NOT NULL,
  `Price` int NOT NULL,
  `Quantity` int NOT NULL,
  `Category` varchar(45) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_item`
--

LOCK TABLES `add_item` WRITE;
/*!40000 ALTER TABLE `add_item` DISABLE KEYS */;
INSERT INTO `add_item` VALUES (1,'Kola ',3,33,'Drinks','Kola fesfsfsf sfsfdsfd'),(2,'zxcxczxcz',2,17,'Fruits','zxczxcz'),(4,'adada',23,373,'Fruits','zxczxczxc'),(5,'sdasd',234,42,'zsdasd','xzczxczc'),(6,'sdfsd',343,233,'chips',''),(7,'asds',22,22,'Drinks',''),(8,'xczdffdc',423,1212,'Bulmet','');
/*!40000 ALTER TABLE `add_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cashierorder_table`
--

DROP TABLE IF EXISTS `cashierorder_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cashierorder_table` (
  `OrderID` varchar(45) NOT NULL,
  `CashierUsername` varchar(45) NOT NULL,
  `OrderDate` varchar(45) NOT NULL,
  `OrderTime` varchar(45) NOT NULL,
  `CustomerUsername` varchar(45) DEFAULT NULL,
  `Total` int NOT NULL,
  `Total_With_Discount` int NOT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashierorder_table`
--

LOCK TABLES `cashierorder_table` WRITE;
/*!40000 ALTER TABLE `cashierorder_table` DISABLE KEYS */;
INSERT INTO `cashierorder_table` VALUES ('4915','aa','2022-06-13','02:52:03','Dion',2744,2469),('9Y6D','aa','2022-06-13','02:59:26','Dion',1372,1234),('F51X','aa','2022-06-15','12:06:23','',12,12),('G2PV','aa','2022-06-13','03:03:00','Dion',1715,1543),('LC7V','aa','2022-06-15','03:39:48','Dion',1730,1557),('OV10','aa','2022-06-13','02:50:30','',9,9),('YCSN','aa','2022-06-15','03:41:19','Dion',2196,1976),('YRX9','aa','2022-06-15','03:30:58','Dion',118,106);
/*!40000 ALTER TABLE `cashierorder_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(45) NOT NULL,
  `Lastname` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Birthday` varchar(45) NOT NULL,
  `Phone` int NOT NULL,
  `Role` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Dion','Berberi','Dion','1234','Male','adasdasd','2022-05-01',54245,'Customer'),(2,'adasdasd','asdasdasd','adasasdasd','12333','Female','qweqwe','2022-05-30',45454,'Customer'),(3,'asdasdscvdfbdfg','wedfsdvfxcvxcv','fghfghfgh','1234','Female','grtgdfg','2022-05-30',545445,'Customer'),(4,'ccc','xxxxx','ccccc','ccccc','Female','asdasdad','2022-06-01',5454544,'Customer'),(5,'bbbbb','bbbb','bbbbb','rrr','Male','rqwqwrwer','2022-06-01',54545,'Customer'),(6,'sdfsdf','sdfsdf','2022-06-03','Female','wewefsdfs','2323423','sfdfsdf',1234,'Customer'),(7,'vvvvv','vvvvvvvv','dasdsdas','12345','Female','asdasdasd','2022-06-02',369865231,'Customer');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(45) NOT NULL,
  `Lastname` varchar(45) NOT NULL,
  `Birthday` varchar(45) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `PhoneNumber` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Role` varchar(45) NOT NULL,
  `Salary` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'aa','aa','5/1/2022','Female','aa','1221','aa','1234','Cashier',222),(2,'asdasdasd','sadasda','5/2/2022','Female','asdasdasd','123123','asdasda','2e123','Admin',23),(3,'dssdf','awdsasd','5/29/2022','Female','sdfsdfsdfsdfsdf','682365489','afddfgdfg','sads','Cashier',42542),(4,'sdfsdfs','sdfsdfsdf','5/29/2022','Male','asdasdasd','688932684','sdasdasda','asdasdaa','Admin',42542),(5,'zxczxczxcz','zxczxc','5/29/2022','Female','zxczxcz','672365986','czxzxc','xczxczx','Cashier',42542),(6,'dfgdfgdfg','czxczxc','5/30/2022','Male','sdfsdfsdfsdf','321312313','zxcxxvdfbdfgdsfg','zcxzcx','Admin',42542),(7,'sdfsdfs','sdfsdfsdf','5/31/2022','Female','dfsdfsdfsdf','13242434','dfsdf','sddfs','Cashier',42542),(8,'sdfsdcdsfsdf','sdfsdfs','5/29/2022','Male','sdfsdfsdf','234342','wfdsvfsfsd','sdfsdfsdf','Admin',42542),(9,'fsdfsdf','sfdsdf','6/5/2022','Female','sdfsdfsdfsdf','683265897','fsddddd','sdfsdfsfs','Admin',42542),(10,'fdsdfsd','fsdfsdf','5/29/2022','Female','sdfsfdsdf','42542232','sdfsdf','sdfsdf','Admin',42542232),(11,'sfdsdfsd','fsdfs','5/29/2022','Male','sdfsdfsdf','3242342','sdfvcvbvvv','sdfsdf','Admin',42542232),(12,'sdfsdsdf','werwerwer','5/29/2022','Female','fsfdsdfdf fsdfsf','1232321','dsdv btrgsds','sdfs','Admin',42542232),(13,'zczcassda','asdasdad','5/30/2022','Female','sdasdasdasd','1234567891','asdasdaacrgbfg','asdasdad','Admin',1233123),(14,'asdasda','asdasdasd','5/31/2022','Male','cccvcvc','1234567890','dvcvcv','ccvcv','Admin',23123123),(15,'asdf','sdfsdfsdf','5/31/2022','Female','sdfsdfsdf','693262894','fsdfgrgdfg','23424323','Cashier',123123123);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_category`
--

DROP TABLE IF EXISTS `item_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_category` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Item_Category` varchar(45) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_category`
--

LOCK TABLES `item_category` WRITE;
/*!40000 ALTER TABLE `item_category` DISABLE KEYS */;
INSERT INTO `item_category` VALUES (1,'Drinks','Drinks'),(2,'Fruits','Fruits'),(4,'chips','chips'),(5,'Bulmet','Bulmet'),(6,'zsdasd','assdads'),(8,'sdfsdf','sdfsddf'),(9,'xcvcvx12312','cvxcvxvcxcv3123123'),(10,'asdasdasdasdasd','asdasdasd'),(11,'vvvvvvvvvvvvvvvvvv','vvvvvvvvvvvvvvvvvv');
/*!40000 ALTER TABLE `item_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitems`
--

DROP TABLE IF EXISTS `orderitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderitems` (
  `ItemID` int NOT NULL,
  `OrderItemID` varchar(45) NOT NULL,
  `Item_Name` varchar(45) NOT NULL,
  `Item_Dec` varchar(45) NOT NULL,
  `ItemPrice` int NOT NULL,
  `Item_Qty` varchar(45) NOT NULL,
  `Total` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitems`
--

LOCK TABLES `orderitems` WRITE;
/*!40000 ALTER TABLE `orderitems` DISABLE KEYS */;
INSERT INTO `orderitems` VALUES (1,'CDKS','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(1,'CDKS','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(1,'XLYB','Kola ','Kola fesfsfsf sfsfdsfd',3,'5','15'),(1,'XLYB','Kola ','Kola fesfsfsf sfsfdsfd',3,'5','15'),(1,'XLYB','Kola ','Kola fesfsfsf sfsfdsfd',3,'5','15'),(1,'XLYB','Kola ','Kola fesfsfsf sfsfdsfd',3,'5','15'),(1,'XLYB','Kola ','Kola fesfsfsf sfsfdsfd',3,'5','15'),(1,'KSDF','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(1,'VSRE','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(1,'96XN','Kola ','Kola fesfsfsf sfsfdsfd',3,'5','15'),(5,'96XN','sdasd','xzczxczc',234,'5','1170'),(4,'P4CB','adada','zxczxczxc',23,'1','23'),(1,'P4CB','Kola ','Kola fesfsfsf sfsfdsfd',3,'1','3'),(4,'14Y6','adada','zxczxczxc',23,'1','23'),(1,'36BP','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(4,'YRX9','adada','zxczxczxc',23,'5','115'),(1,'YRX9','Kola ','Kola fesfsfsf sfsfdsfd',3,'1','3'),(1,'HKOQ','Kola ','Kola fesfsfsf sfsfdsfd',3,'5','15'),(1,'V3A0','Kola ','Kola fesfsfsf sfsfdsfd',3,'2','6'),(1,'LC7V','Kola ','Kola fesfsfsf sfsfdsfd',3,'5','15'),(6,'LC7V','sdfsd','',343,'5','1715'),(4,'YCSN','adada','zxczxczxc',23,'6','138'),(6,'YCSN','sdfsd','',343,'6','2058'),(1,'380R','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(1,'72VY','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(5,'72VY','sdasd','xzczxczc',234,'4','936'),(4,'ZEY1','adada','zxczxczxc',23,'5','115'),(5,'N3DA','sdasd','xzczxczc',234,'1','234'),(6,'XRHP','sdfsd','',343,'1','343'),(8,'NQTP','xczdffdc','',423,'1','423'),(1,'PS53','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(1,'2TZ0','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(1,'7KY9','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(1,'C574','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(5,'NTFQ','sdasd','xzczxczc',234,'5','1170'),(4,'I9Z1','adada','zxczxczxc',23,'5','115'),(1,'1NS3','Kola ','Kola fesfsfsf sfsfdsfd',3,'4','12'),(4,'SEPC','adada','zxczxczxc',23,'5','115'),(4,'9S2K','adada','zxczxczxc',23,'5','115'),(4,'9S2K','adada','zxczxczxc',23,'5','115'),(4,'9S2K','adada','zxczxczxc',23,'5','115'),(4,'9S2K','adada','zxczxczxc',23,'5','115'),(4,'9S2K','adada','zxczxczxc',23,'5','115'),(4,'9S2K','adada','zxczxczxc',23,'5','115'),(4,'9S2K','adada','zxczxczxc',23,'5','115'),(4,'9S2K','adada','zxczxczxc',23,'5','115');
/*!40000 ALTER TABLE `orderitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlogin`
--

DROP TABLE IF EXISTS `userlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userlogin` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Role` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogin`
--

LOCK TABLES `userlogin` WRITE;
/*!40000 ALTER TABLE `userlogin` DISABLE KEYS */;
INSERT INTO `userlogin` VALUES (1,'Admin','Admin','Admin'),(2,'Dion','1234','Customer'),(3,'aa','1234','Cashier'),(4,'asdasda','2e123','Admin'),(5,'afddfgdfg','sads','Cashier'),(6,'sdasdasda','asdasdaa','Admin'),(7,'czxzxc','xczxczx','Cashier'),(8,'zxcxxvdfbdfgdsfg','zcxzcx','Admin'),(9,'dfsdf','sddfs','Cashier'),(10,'wfdsvfsfsd','sdfsdfsdf','Admin'),(11,'fsddddd','sdfsdfsfs','Admin'),(12,'sdfsdf','sdfsdf','Admin'),(13,'sdfvcvbvvv','sdfsdf','Admin'),(14,'dsdv btrgsds','sdfs','Admin'),(15,'adasasdasd','12333','Customer'),(16,'fghfghfgh','1234','Customer'),(17,'ccccc','ccccc','Customer'),(18,'bbbbb','rrr','Customer'),(19,'asdasdaacrgbfg','asdasdad','Admin'),(20,'dvcvcv','ccvcv','Admin'),(21,'fsdfgrgdfg','23424323','Cashier'),(22,'sfdfsdf','1234','Customer'),(23,'dasdsdas','12345','Customer');
/*!40000 ALTER TABLE `userlogin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-15 17:28:42
