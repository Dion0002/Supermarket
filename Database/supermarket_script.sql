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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_item`
--

LOCK TABLES `add_item` WRITE;
/*!40000 ALTER TABLE `add_item` DISABLE KEYS */;
INSERT INTO `add_item` VALUES (1,'Bananas',4,200,'Fruits','Fruits-bananas'),(2,'Apples',5,200,'Fruits','Fruits-apples'),(3,'Oranges',3,200,'Fruits','Fruits-Oranges'),(4,'Potatoes',7,200,'Vegetables','Vegetables-Potatoes'),(5,'Tomatoes',6,200,'Vegetables','Vegetables-Tomatoes'),(6,'Carrots',8,200,'Vegetables','Vegetables-Carrots'),(7,'Fish',20,200,'Frozen Foods','Frozen Foods-Fish'),(8,'Ice cream',12,200,'Frozen Foods','Frozen Foods-Ice cream'),(9,'Pizza',30,200,'Frozen Foods','Frozen Foods-Pizza'),(10,'Chicken',40,200,'Meat','Meat-Chicken'),(11,'Beef',50,200,'Meat','Meat-Beef'),(12,'Pork',35,200,'Meats','Meat-Pork'),(13,'Chips',10,200,'Snacks ','Snacks -Chips'),(14,'Popcorn',15,200,'Snacks ','Snacks -Popcorn'),(15,'Candy',20,200,'Snacks ','Snacks -Candy'),(16,'Water',5,200,'Drinks ','Drinks -Water'),(17,'Cola',7,200,'Drinks ','Drinks -Cola'),(18,'Coffee',10,200,'Drinks ','Drinks -Coffee'),(19,'Shampoo',5,200,'Personal Care ','Personal Care-Shampoo'),(20,'Soap',7,200,'Personal Care ','Personal Care-Soap'),(21,'Toothpaste',10,200,'Personal Care ','Personal Care-Toothpaste');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Philbert','Cabrer','5/12/1985','Male','1518 Mallory Center','7328617678','pcabrer0','Mvcx1oGsHDlp','Cashier',868),(2,'Othilia','Papa','10/1/1994','Female','56752 Lake View Crossing','2026651047','opapa1','4NRKixhG','Admin',70689),(3,'Dorisa','Vatini','7/4/1974','Female','582 Erie Center','3874770479','dvatini2','yLyrtXnxzOfs','Admin',4471),(4,'Wadsworth','Bariball','12/15/1981','Male','3521 Cottonwood Court','7589690860','wbariball3','ji3MG2sRpPCS','Cashier',1796),(5,'Frankie','Howbrook','6/27/1984','Female','5634 Sutteridge Parkway','5731520986','fhowbrook4','1JtT3yqKE','Cashier',1246),(6,'Kaycee','Motherwell','10/12/1994','Female','109 Green Lane','8295966482','kmotherwell5','BlzGu10lt7MS','Cashier',17929),(7,'Gerrie','Simenot','2/25/1976','Male','86 Warner Way','9673334342','gsimenot6','A8Mpily','Admin',60451),(9,'Rad','Prince','12/20/1977','Male','4 Di Loreto Alley','1352757242','rprince8','3PMUXep9','Cashier',8),(10,'Powell','Petrol','2/12/1986','Male','44 Kropf Court','6004495772','ppetrol9','lQ2eHhhw','Cashier',7791),(11,'Jonathan','Kohneke','8/19/1979','Male','38 Mcguire Center','4635302706','jkohnekea','hcCftD','Admin',63173),(12,'Whittaker','Ringer','12/14/1987','Male','82 Chive Park','1031699563','wringerb','PVz7gh','Admin',7),(13,'Archie','Giacomi','4/22/1976','Male','29033 Anthes Plaza','4198909202','agiacomic','5mfAntFl7','Admin',9),(14,'Niki','Maffini','4/15/1978','Male','274 Maple Wood Hill','1367618208','nmaffinid','kmJ7FTNbVG','Admin',52083),(15,'Audi','Mabee','12/28/1975','Female','379 Maple Pass','3869836874','amabeee','x16riM','Cashier',9),(16,'Sherwynd','Moss','9/22/1992','Male','3 Oneill Park','7659647727','smossf','xxpwA5L3vE','Cashier',5),(17,'Tracie','Robard','10/29/1976','Male','8012 Dakota Circle','5175456553','trobardg','pjddbUu8HAPY','Admin',65),(18,'Zacharias','Strothers','3/20/1989','Male','05179 Bunker Hill Way','5437134788','zstrothersh','D4BSkeZ5','Admin',841),(19,'Cori','Glyde','9/25/1991','Male','3462 Redwing Pass','9581253981','cglydei','t5JH4BZjKQk','Cashier',6),(20,'Brandtr','Coventry','3/16/1982','Male','4 Hermina Street','7044144982','bcoventryj','gIAsP8NuQr7','Cashier',22593),(21,'Bailie','Fechnie','1/17/1993','Male','3822 Comanche Court','1755956128','bfechniek','Kfcg5ck','Cashier',505),(22,'Phineas','Geddes','10/23/1984','Male','7539 Jenifer Point','5983574064','pgeddesl','ajJvoRzjjz','Admin',47925),(23,'Basil','Doddemeede','4/20/1973','Male','9590 Nobel Plaza','6206012030','bdoddemeedem','VIfeBHDlJt','Cashier',35507),(24,'Alphonso','Wyld','11/7/1986','Male','13 Lakeland Point','1347145008','awyldn','p9A5AbJzjtZG','Cashier',6065),(25,'Benedicto','Langdale','5/27/1997','Male','42941 Old Gate Junction','7468972116','blangdaleo','QVP5wh4QrS','Admin',47),(26,'Rakel','Trenbey','1/23/1988','Female','15 Mifflin Drive','7089625368','rtrenbeyp','e9mdJka9','Cashier',971),(27,'Julissa','Croll','12/15/1988','Female','8254 Donald Park','8851876152','jcrollq','rmQdxHpFic','Admin',3),(28,'Cariotta','Anstee','3/23/1985','Female','535 Mesta Way','6685220222','cansteer','ImW87RT','Admin',68),(29,'Northrup','Longlands','9/20/1982','Male','90 Ryan Junction','6621356419','nlonglandss','KPXqHQfT0','Cashier',208),(30,'Gilbertina','Durant','11/20/1998','Female','05 Westend Alley','7612461785','gdurantt','fItfpr','Cashier',85459),(31,'Brunhilda','Eastby','9/6/1979','Female','1 Lotheville Street','2203805700','beastbyu','FZkvpgttkjD','Admin',8),(32,'Harry','Gergher','10/17/1995','Male','56142 Delladonna Drive','6392532637','hgergherv','o6e31vKZ9','Cashier',91739),(33,'Fanya','Horney','8/25/1995','Female','9972 Brown Circle','3677498881','fhorneyw','K7xNFrDOEDbp','Cashier',52530),(34,'Tova','Delue','11/2/1998','Female','7842 Bay Court','3653639091','tdeluex','99XSz6IdY','Cashier',5),(35,'Creight','Potte','2/26/1984','Male','013 Pine View Park','7572307009','cpottey','8n5deK','Admin',57),(36,'Symon','Miles','8/4/1992','Male','2 Cordelia Trail','2925819384','smilesz','KIdMUvTZZu','Admin',51571),(37,'Reg','Domegan','2/16/1997','Male','85 Anniversary Circle','4623356424','rdomegan10','Ud2ErZA7J4f','Cashier',94052),(38,'Derk','Scay','3/30/1986','Male','5 Bunker Hill Alley','6264213808','dscay11','VS0l5F','Admin',34689),(39,'Sheilah','Bevans','9/27/1985','Female','179 Westport Lane','3961678954','sbevans12','VVKQF64hV','Cashier',4),(40,'Trescha','Tattersfield','7/9/1993','Female','25909 Calypso Park','1038725894','ttattersfield13','0gO0nR','Admin',7450),(41,'Nerte','McDermott','9/29/1974','Female','2293 Packers Crossing','3217656462','nmcdermott14','pmuQXUmng','Cashier',72),(42,'Felizio','Kinch','8/14/1997','Male','7570 Center Parkway','8002435858','fkinch15','fRU9YqY0maK','Admin',567),(43,'Jaquenette','Cabotto','6/9/1986','Female','08140 Independence Road','3737622998','jcabotto16','K1wAMzBx7','Admin',927),(44,'Bryanty','Nowlan','5/12/1981','Male','1753 Green Lane','7664170940','bnowlan17','xhVbLtqk','Admin',8),(45,'Clerkclaude','Howland','10/19/1986','Male','3294 Rowland Way','9487697923','chowland18','c39WTSeVdOLF','Cashier',6),(46,'Lennie','Reinhardt','5/17/1998','Male','13 Thackeray Place','2413561111','lreinhardt19','IXBNM547h','Admin',236),(47,'Tricia','Cockerill','12/12/1995','Female','0 Paget Parkway','9933604085','tcockerill1a','QCUNDBcTyy','Cashier',954),(48,'Silvester','De Rechter','11/1/1976','Male','47896 Ruskin Trail','7677906744','sderechter1b','BxqJrUk8j','Admin',54505),(49,'Mame','Bedminster','11/27/1981','Female','48871 Waywood Center','9379267142','mbedminster1c','iYzPO1K','Admin',99),(50,'Janel','Bolton','2/7/1993','Female','19639 Towne Avenue','8223472742','jbolton1d','tvt8pjC','Admin',40611);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_category`
--

LOCK TABLES `item_category` WRITE;
/*!40000 ALTER TABLE `item_category` DISABLE KEYS */;
INSERT INTO `item_category` VALUES (1,'Fruits','Fruits'),(2,'Vegetables ','Vegetables '),(3,'Frozen Foods','Frozen Foods'),(4,'Meat ','Meat '),(5,'Snacks','Snacks'),(6,'Drinks','Drinks'),(7,'Personal Care','Personal Care');
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
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogin`
--

LOCK TABLES `userlogin` WRITE;
/*!40000 ALTER TABLE `userlogin` DISABLE KEYS */;
INSERT INTO `userlogin` VALUES (1,'Admin','Admin','Admin'),(2,'pcabrer0','Mvcx1oGsHDlp','Cashier'),(3,'opapa1','4NRKixhG','Admin'),(4,'dvatini2','yLyrtXnxzOfs','Admin'),(5,'wbariball3','ji3MG2sRpPCS','Cashier'),(6,'fhowbrook4','1JtT3yqKE','Cashier'),(7,'kmotherwell5','BlzGu10lt7MS','Cashier'),(8,'gsimenot6','A8Mpily','Admin'),(9,'nmonahan7','jtXsCvH3','Admin'),(10,'rprince8','3PMUXep9','Cashier'),(11,'ppetrol9','lQ2eHhhw','Cashier'),(12,'jkohnekea','hcCftD','Admin'),(13,'wringerb','PVz7gh','Admin'),(14,'agiacomic','5mfAntFl7','Admin'),(15,'nmaffinid','kmJ7FTNbVG','Admin'),(16,'amabeee','x16riM','Cashier'),(17,'smossf','xxpwA5L3vE','Cashier'),(18,'trobardg','pjddbUu8HAPY','Admin'),(19,'zstrothersh','D4BSkeZ5','Admin'),(20,'cglydei','t5JH4BZjKQk','Cashier'),(21,'bcoventryj','gIAsP8NuQr7','Cashier'),(22,'bfechniek','Kfcg5ck','Cashier'),(23,'pgeddesl','ajJvoRzjjz','Admin'),(24,'bdoddemeedem','VIfeBHDlJt','Cashier'),(25,'awyldn','p9A5AbJzjtZG','Cashier'),(26,'blangdaleo','QVP5wh4QrS','Admin'),(27,'rtrenbeyp','e9mdJka9','Cashier'),(28,'jcrollq','rmQdxHpFic','Admin'),(29,'cansteer','ImW87RT','Admin'),(30,'nlonglandss','KPXqHQfT0','Cashier'),(31,'gdurantt','fItfpr','Cashier'),(32,'beastbyu','FZkvpgttkjD','Admin'),(33,'hgergherv','o6e31vKZ9','Cashier'),(34,'fhorneyw','K7xNFrDOEDbp','Cashier'),(35,'tdeluex','99XSz6IdY','Cashier'),(36,'cpottey','8n5deK','Admin'),(37,'smilesz','KIdMUvTZZu','Admin'),(38,'rdomegan10','Ud2ErZA7J4f','Cashier'),(39,'dscay11','VS0l5F','Admin'),(40,'sbevans12','VVKQF64hV','Cashier'),(41,'ttattersfield13','0gO0nR','Admin'),(42,'nmcdermott14','pmuQXUmng','Cashier'),(43,'fkinch15','fRU9YqY0maK','Admin'),(44,'jcabotto16','K1wAMzBx7','Admin'),(45,'bnowlan17','xhVbLtqk','Admin'),(46,'chowland18','c39WTSeVdOLF','Cashier'),(47,'lreinhardt19','IXBNM547h','Admin'),(48,'tcockerill1a','QCUNDBcTyy','Cashier'),(49,'sderechter1b','BxqJrUk8j','Admin'),(50,'mbedminster1c','iYzPO1K','Admin'),(51,'jbolton1d','tvt8pjC','Admin'),(52,'aaa1234','1234','Customer'),(98,'Dion','1234','Customer'),(99,'adasasdasd','12333','Customer'),(100,'fghfghfgh','1234','Customer'),(101,'ccccc','ccccc','Customer'),(102,'bbbbb','rrr','Customer'),(103,'2022-06-03','Female','Customer'),(104,'dasdsdas','12345','Customer');
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

-- Dump completed on 2022-06-17  1:01:50
