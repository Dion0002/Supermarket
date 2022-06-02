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
INSERT INTO `add_item` VALUES (1,'Kola ',3,50,'Drinks','Kola fesfsfsf sfsfdsfd'),(2,'zxcxczxcz',2,20,'Fruits','zxczxcz'),(4,'adada',23,423,'Fruits','zxczxczxc'),(5,'sdasd',234,42,'zsdasd','xzczxczc'),(6,'sdfsd',343,233,'chips',''),(7,'asds',22,22,'Drinks',''),(8,'xczdffdc',423,1212,'Bulmet','');
/*!40000 ALTER TABLE `add_item` ENABLE KEYS */;
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
  `Role` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Dion','Berberi','Dion','1234','Male','adasdasd','2022-05-01','Customer');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'aa','aa','5/1/2022','Female','aa','1221','aa','1234','Cashier',222),(2,'asdasdasd','sadasda','5/2/2022','Female','asdasdasd','123123','asdasda','2e123','Admin',23),(3,'dssdf','awdsasd','5/29/2022','Female','sdfsdfsdfsdfsdf','25455452','afddfgdfg','sads','Cashier',42542),(4,'sdfsdfs','sdfsdfsdf','5/29/2022','Male','asdasdasd','4553520','sdasdasda','asdasdaa','Admin',42542),(5,'zxczxczxcz','zxczxc','5/29/2022','Female','zxczxcz','123123','czxzxc','xczxczx','Cashier',42542),(6,'dfgdfgdfg','czxczxc','5/30/2022','Male','sdfsdfsdfsdf','321312313','zxcxxvdfbdfgdsfg','zcxzcx','Admin',42542),(7,'sdfsdfs','sdfsdfsdf','5/31/2022','Female','dfsdfsdfsdf','13242434','dfsdf','sddfs','Cashier',42542),(8,'sdfsdcdsfsdf','sdfsdfs','5/29/2022','Male','sdfsdfsdf','234342','wfdsvfsfsd','sdfsdfsdf','Admin',42542),(9,'fsdfsdf','sfdsdf','6/5/2022','Female','sdfsdfsdfsdf','3243423','fsddddd','sdfsdfsfs','Admin',42542),(10,'fdsdfsd','fsdfsdf','5/29/2022','Female','sdfsfdsdf','42542232','sdfsdf','sdfsdf','Admin',42542232),(11,'sfdsdfsd','fsdfs','5/29/2022','Male','sdfsdfsdf','3242342','sdfvcvbvvv','sdfsdf','Admin',42542232),(12,'sdfsdsdf','werwerwer','5/29/2022','Female','fsfdsdfdf fsdfsf','1232321','dsdv btrgsds','sdfs','Admin',42542232);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogin`
--

LOCK TABLES `userlogin` WRITE;
/*!40000 ALTER TABLE `userlogin` DISABLE KEYS */;
INSERT INTO `userlogin` VALUES (1,'Admin','Admin','Admin'),(2,'Dion','1234','Customer'),(3,'aa','1234','Cashier'),(4,'asdasda','2e123','Admin'),(5,'afddfgdfg','sads','Cashier'),(6,'sdasdasda','asdasdaa','Admin'),(7,'czxzxc','xczxczx','Cashier'),(8,'zxcxxvdfbdfgdsfg','zcxzcx','Admin'),(9,'dfsdf','sddfs','Cashier'),(10,'wfdsvfsfsd','sdfsdfsdf','Admin'),(11,'fsddddd','sdfsdfsfs','Admin'),(12,'sdfsdf','sdfsdf','Admin'),(13,'sdfvcvbvvv','sdfsdf','Admin'),(14,'dsdv btrgsds','sdfs','Admin');
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

-- Dump completed on 2022-06-02 18:23:42
