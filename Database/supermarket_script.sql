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
INSERT INTO `cashierorder_table` VALUES ('EFRC','Mattia','2022-06-17','10:06:52','Dion1',12,10),('L3QG','Mattia','2022-06-17','10:24:12','Dion1',33,33);
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
  `Phone` varchar(45) NOT NULL,
  `Role` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Godwin','Goldsmith','ggoldsmith0','sc88t1tSmmp','Male','40995 Gale Drive','12/20/1987','9113159173','Customer'),(2,'Vasilis','Simounet','vsimounet1','c3YvXJXo','Male','11 Birchwood Center','8/14/2013','2229843026','Customer'),(3,'Cirstoforo','Bohman','cbohman2','MBOYykuFPN','Male','8050 Mayer Pass','7/24/1975','9652197086','Customer'),(4,'Zondra','Glenny','zglenny3','yzbns9','Female','27 Jenna Pass','8/11/1999','8222162831','Customer'),(5,'Constanta','Whyte','cwhyte4','Bi8Fit','Female','4 Mayfield Court','2/1/1987','5544741766','Customer'),(6,'Ave','Darke','adarke5','Dyb2Te','Male','61 Arizona Alley','9/15/2007','7167608223','Customer'),(7,'Sidnee','Warman','swarman6','jPrX2h5GX','Male','15 Melvin Place','7/7/2005','4996201765','Customer'),(8,'Sib','Buessen','sbuessen7','qDSuF4yA4C','Female','6308 Elka Point','3/17/1992','7051944650','Customer'),(9,'Amie','Boothebie','aboothebie8','3p5Ag0','Female','223 Norway Maple Alley','11/5/2001','7951005853','Customer'),(10,'Gearalt','Chumley','gchumley9','YHrMoWXn','Male','85064 International Center','6/17/2007','4443025280','Customer'),(11,'Violante','Pragnall','vpragnalla','gq0OGg','Female','5327 Barnett Pass','11/25/1980','2097565040','Customer'),(12,'Urban','Cleeton','ucleetonb','AC4BG0sn','Male','2572 Norway Maple Point','1/21/1997','4953615307','Customer'),(13,'Sonny','Trivett','strivettc','kWrMXlI33Ch','Male','55 Bartillon Terrace','9/4/1987','2673390236','Customer'),(14,'Pincus','Duckit','pduckitd','GFQvWu5gbO','Male','8422 Spenser Circle','12/31/1988','1739576122','Customer'),(15,'Tomasina','Sacher','tsachere','DJO6Y8woM','Female','327 Cambridge Pass','12/2/1992','1744672144','Customer'),(16,'Dougie','Fitzsimon','dfitzsimonf','Q7Aztn3h','Male','0199 Pankratz Crossing','7/17/1978','4485581555','Customer'),(17,'Karrah','Pantin','kpanting','eFvLt4rJ','Female','22 Mandrake Lane','8/25/1986','5382233920','Customer'),(18,'Hillel','Lomis','hlomish','NrIXKGK','Male','56 Starling Avenue','11/14/1976','2355092833','Customer'),(19,'Ax','Shakesby','ashakesbyi','zpUIDIYzGOB','Male','07 Meadow Vale Plaza','7/10/1991','6562788678','Customer'),(20,'Jamil','Eastcourt','jeastcourtj','AV42SiWMRFN','Male','18936 Corry Way','11/14/1993','2424737121','Customer'),(21,'Nessi','Mackison','nmackisonk','ugsaJp5Wt','Female','5582 Main Alley','10/30/1980','9658437914','Customer'),(22,'Susette','Scheu','sscheul','JPGn7NYnP','Female','785 Badeau Way','3/11/2014','2721275272','Customer'),(23,'Karlik','Danks','kdanksm','uEEfd5RuVbx','Male','0385 Hoffman Crossing','9/8/2012','1878238884','Customer'),(24,'Laural','Izzard','lizzardn','h1bq5aJnG','Female','47146 Thompson Court','10/3/2002','4918156403','Customer'),(25,'Blinni','Rustman','brustmano','FkJpnYac9EO','Female','55487 Ruskin Court','9/7/2007','6185403449','Customer'),(26,'Rollie','Blemings','rblemingsp','up0wfpo','Male','5 Spenser Road','2/23/1996','2946384962','Customer'),(27,'Rayner','Baughn','rbaughnq','z6AC40PF8ivF','Male','1552 Vera Road','1/31/1977','1065090539','Customer'),(28,'Esmeralda','Carnie','ecarnier','ybqbW6VlQ','Female','34 Arapahoe Junction','9/29/1988','5641653871','Customer'),(29,'Kassia','Cordelle','kcordelles','pxuz08lydRt','Female','5182 Pierstorff Road','3/13/1983','3643356343','Customer'),(30,'Gabby','Sellar','gsellart','0QJu72EZ','Male','31240 Stoughton Street','1/7/2006','8028427336','Customer'),(31,'Layla','Giercke','lgierckeu','aIOx0KNLm','Female','1 Karstens Circle','4/4/2005','5332360028','Customer'),(32,'Etty','Peart','epeartv','QqYg9GsOPf','Female','47 La Follette Circle','4/10/1997','9601507085','Customer'),(33,'Willis','Ricciardo','wricciardow','Mc4QzjefXIo','Male','6 Charing Cross Hill','6/20/2009','1547489767','Customer'),(34,'Bartolomeo','Legerton','blegertonx','OCeuAnC2','Male','1849 Lukken Plaza','9/4/2003','6638731561','Customer'),(35,'Felike','Willimot','fwillimoty','IwMQdB7OVFdt','Male','85853 Dawn Avenue','9/12/2008','4698220059','Customer'),(36,'Aurilia','Enrigo','aenrigoz','kfQvoK','Female','583 Troy Street','9/19/1970','8148264617','Customer'),(37,'Lorianne','Hawtry','lhawtry10','3FDmrwf','Female','0 Tennessee Crossing','1/16/1995','1115192707','Customer'),(38,'Adolpho','Mulligan','amulligan11','RnCZYBY','Male','186 Prairieview Junction','3/14/2013','5496199421','Customer'),(39,'Katlin','Byas','kbyas12','URQX6rRo1YF2','Female','29 Ludington Alley','11/12/2006','3731034415','Customer'),(40,'Emilio','Hayter','ehayter13','z5Q9WE2O27k','Male','94 Bashford Drive','12/9/1982','6375919109','Customer'),(41,'Shae','Macallam','smacallam14','ZOJSsMD','Male','59 Schiller Circle','4/25/1996','8022867904','Customer'),(42,'Janey','Peppett','jpeppett15','ofuE5iAV2','Female','6723 Chive Park','11/22/1977','2865019217','Customer'),(43,'Hermina','Creboe','hcreboe16','QlA1Ftv','Female','6 Oakridge Hill','10/13/1995','4323874148','Customer'),(44,'Dalt','Round','dround17','9VsnKzMnDDGK','Male','721 Macpherson Center','1/21/1978','4049380764','Customer'),(45,'Mindy','Gibberd','mgibberd18','wzvasfu5Y','Female','1 Porter Park','11/7/1974','2069769390','Customer'),(46,'Aluino','Raynor','araynor19','5hcZmV6Z','Male','343 Saint Paul Avenue','3/1/2013','1414675178','Customer'),(47,'Jud','Buff','jbuff1a','6kL0vO','Male','55 Mariners Cove Point','8/12/2003','3602704935','Customer'),(48,'Joline','Gaisford','jgaisford1b','yaAAO9ac','Female','47683 Lakeland Center','10/11/2010','1457432025','Customer'),(49,'Britni','Bellenger','bbellenger1c','NNLbWSHlEj','Female','4 La Follette Drive','7/6/1981','5317120069','Customer'),(50,'Marti','Stiegers','mstiegers1d','eb3dJZ','Female','759 West Plaza','4/25/2004','4665277281','Customer'),(51,'Michael','Colqueran','mcolqueran1e','O1mvPAjE5','Male','2 Shopko Park','7/13/1986','5643289657','Customer'),(52,'Tobias','Jirus','tjirus1f','13vKbpH6J6Kc','Male','06 Sheridan Parkway','1/3/1978','4065315668','Customer'),(53,'Miranda','Souness','msouness1g','dhvd7EJMZDdv','Female','49562 Banding Road','1/20/2009','2137241839','Customer'),(54,'Burlie','Sheardown','bsheardown1h','kt876Tg','Male','3 North Street','6/9/2006','2489827362','Customer'),(55,'Gipsy','Greenhowe','ggreenhowe1i','sHIeeg','Female','6 Northridge Terrace','9/21/1982','4483353189','Customer'),(56,'Rebe','Klement','rklement1j','wUN11RzrR','Female','396 Saint Paul Point','2/15/1976','3375452343','Customer'),(57,'Lorna','Picard','lpicard1k','xv9QLN6zR4T0','Female','6393 Oak Valley Street','9/3/1973','7013100717','Customer'),(58,'Willabella','Licciardo','wlicciardo1l','eudSJk','Female','15575 Ridge Oak Point','11/12/1971','4671253869','Customer'),(59,'Berrie','Winkless','bwinkless1m','tQbJWvSXIPJ','Female','627 Johnson Parkway','12/28/1976','4239983138','Customer'),(60,'Katharina','Darkins','kdarkins1n','gBXTmfTPrx9I','Female','7 Northland Plaza','11/7/1992','2124182391','Customer'),(61,'Jesselyn','Magson','jmagson1o','Q7c2FFNVo1','Female','41 Sullivan Court','10/7/2008','8379653759','Customer'),(62,'Abigail','St Ange','astange1p','QLjdZb','Female','324 Oak Way','3/25/2001','8912346464','Customer'),(63,'Paten','Dufoure','pdufoure1q','y4YLx4trR','Male','65337 Ryan Park','6/12/2005','4056232548','Customer'),(64,'Danit','Brecken','dbrecken1r','s1JVEt6s6UJ','Female','4163 Judy Circle','6/16/1995','3107748203','Customer'),(65,'Marleen','Windless','mwindless1s','NmlM6m','Female','1652 Monterey Park','5/30/1974','6485860086','Customer'),(66,'Annalise','Bezarra','abezarra1t','4pdAUJS2','Female','927 Porter Center','9/15/1987','6678081319','Customer'),(67,'Rudd','Shreenan','rshreenan1u','lhNpsuyldKk','Male','22 Chive Court','7/12/2014','8886446125','Customer'),(68,'Beatriz','Borrill','bborrill1v','kvM7Ct','Female','122 Bartelt Parkway','9/13/1991','4292741662','Customer'),(69,'Jordana','Ure','jure1w','lRXnblZSqm','Female','6396 Sunbrook Terrace','5/15/2005','5261271583','Customer'),(70,'Lane','Wollen','lwollen1x','VJCL7w','Male','606 Delladonna Park','6/20/1986','5971732541','Customer'),(71,'Keefe','Dwine','kdwine1y','qSw5VeRXWJfO','Male','0 Anhalt Way','8/17/2009','1112939205','Customer'),(72,'Engracia','Adamo','eadamo1z','a7skKS5','Female','0 Haas Alley','4/27/1983','9779891895','Customer'),(73,'Angelita','Eddoes','aeddoes20','1WxRHtj','Female','72123 Pearson Way','2/8/1980','7705930255','Customer'),(74,'Griffin','Kares','gkares21','aAN5UKZIfK','Male','2 Quincy Center','12/10/1995','8151383930','Customer'),(75,'Blakeley','Haddick','bhaddick22','NLETVc2zre7','Female','8368 Ludington Street','4/22/1990','4876745536','Customer'),(76,'Ambros','Arthey','aarthey23','Oix0WpJVfR','Male','74877 Sullivan Junction','11/25/1973','4879549825','Customer'),(77,'Nicolas','Domnick','ndomnick24','kR9hAqEfA','Male','40007 Vermont Crossing','10/5/1994','9595254235','Customer'),(78,'Zacharias','Spilsburie','zspilsburie25','GnM3glNvy','Male','3 Armistice Center','8/13/1997','3866335921','Customer'),(79,'Rutger','Izakovitz','rizakovitz26','vlJOfERN9kA','Male','7124 Randy Pass','12/31/2010','5948408581','Customer'),(80,'Blakeley','Amy','bamy27','e9fLVDGo8B','Female','0554 Everett Hill','2/8/1983','9048004519','Customer'),(81,'Carly','Verrechia','cverrechia28','5ttryh','Female','26 Forest Hill','1/4/1985','3785742686','Customer'),(82,'Francklin','Parsell','fparsell29','NlNEeuhT','Male','73417 Butterfield Pass','3/30/1974','9449031654','Customer'),(83,'Lauren','Ashfold','lashfold2a','EQ8Vf4A','Male','1 Elgar Trail','12/30/2004','5836993542','Customer'),(84,'Ruddie','Claricoates','rclaricoates2b','FvgroZ1s','Male','1613 Wayridge Lane','6/25/2001','3168418691','Customer'),(85,'Jamal','Raeside','jraeside2c','KkAIIRYL','Male','315 Del Mar Trail','10/10/1988','4306788081','Customer'),(86,'Niel','Bewshire','nbewshire2d','of4UcQsALxoL','Male','6390 Thierer Road','4/28/1973','8335764356','Customer'),(87,'Corie','Berrick','cberrick2e','aA9x9PH5','Female','361 Express Park','6/5/2003','1283379109','Customer'),(88,'Jacintha','Guiel','jguiel2f','1pFGZsyN6zLu','Female','79248 Roth Street','2/6/1992','8613126195','Customer'),(89,'Shayla','Marlon','smarlon2g','ydC7F7M0kI','Female','64882 Springview Circle','6/9/2012','4424867146','Customer'),(90,'Amil','Neil','aneil2h','ANXAL7V','Female','31860 Hagan Terrace','3/31/1979','7288317224','Customer'),(91,'Sibbie','Hasnney','shasnney2i','rLxXkPmZOssp','Female','4946 Springview Trail','3/3/1974','2537670676','Customer'),(92,'Lilia','Toombes','ltoombes2j','2q87pkXD','Female','4004 Bultman Circle','8/9/1973','7488820466','Customer'),(93,'Sawyer','Moye','smoye2k','wvjRgz43h9CA','Male','899 Merrick Street','10/22/1990','8647907267','Customer'),(94,'Darcy','O\'Skehan','doskehan2l','TVSOPKpnd9','Male','0 Sycamore Place','9/3/1993','4958756465','Customer'),(95,'Olivier','Ivkovic','oivkovic2m','7wempbA8J','Male','76 Katie Lane','12/27/1980','9256170267','Customer'),(96,'Harp','Statter','hstatter2n','dZdHoLhH8d','Male','298 Larry Way','7/23/1982','9594330780','Customer'),(97,'Lotta','Molineux','lmolineux2o','K1hJ0zE5a','Female','1410 Burning Wood Center','10/9/2004','1865074553','Customer'),(98,'Milicent','Bilston','mbilston2p','rKBeqf','Female','4429 Eagan Pass','5/3/1998','2386391515','Customer'),(99,'Hewett','Heakey','hheakey2q','o6N1NO','Male','0 Roth Road','2/9/2001','4311199739','Customer'),(100,'Casi','Bannister','cbannister2r','Y2AiNSETPT','Female','415 Parkside Road','4/9/1998','9147689540','Customer'),(102,'Dion','Berberi','Dion','1234','Male','asdasdasdasdas','2022-05-31','684523658','Customer'),(103,'Dion','Berberi','Dion1','1234','Male','adsdadasdasda','2022-06-06','693626586','Customer');
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
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Philbert','Cabrer','5/12/1985','Male','1518 Mallory Center','7328617678','pcabrer0','Mvcx1oGsHDlp','Cashier',868),(2,'Othilia','Papa','10/1/1994','Female','56752 Lake View Crossing','2026651047','opapa1','4NRKixhG','Admin',70689),(3,'Dorisa','Vatini','7/4/1974','Female','582 Erie Center','3874770479','dvatini2','yLyrtXnxzOfs','Admin',4471),(4,'Wadsworth','Bariball','12/15/1981','Male','3521 Cottonwood Court','7589690860','wbariball3','ji3MG2sRpPCS','Cashier',1796),(5,'Frankie','Howbrook','6/27/1984','Female','5634 Sutteridge Parkway','5731520986','fhowbrook4','1JtT3yqKE','Cashier',1246),(6,'Kaycee','Motherwell','10/12/1994','Female','109 Green Lane','8295966482','kmotherwell5','BlzGu10lt7MS','Cashier',17929),(7,'Gerrie','Simenot','2/25/1976','Male','86 Warner Way','9673334342','gsimenot6','A8Mpily','Admin',60451),(9,'Rad','Prince','12/20/1977','Male','4 Di Loreto Alley','1352757242','rprince8','3PMUXep9','Cashier',8),(10,'Powell','Petrol','2/12/1986','Male','44 Kropf Court','6004495772','ppetrol9','lQ2eHhhw','Cashier',7791),(11,'Jonathan','Kohneke','8/19/1979','Male','38 Mcguire Center','4635302706','jkohnekea','hcCftD','Admin',63173),(12,'Whittaker','Ringer','12/14/1987','Male','82 Chive Park','1031699563','wringerb','PVz7gh','Admin',7),(13,'Archie','Giacomi','4/22/1976','Male','29033 Anthes Plaza','4198909202','agiacomic','5mfAntFl7','Admin',9),(14,'Niki','Maffini','4/15/1978','Male','274 Maple Wood Hill','1367618208','nmaffinid','kmJ7FTNbVG','Admin',52083),(15,'Audi','Mabee','12/28/1975','Female','379 Maple Pass','3869836874','amabeee','x16riM','Cashier',9),(16,'Sherwynd','Moss','9/22/1992','Male','3 Oneill Park','7659647727','smossf','xxpwA5L3vE','Cashier',5),(17,'Tracie','Robard','10/29/1976','Male','8012 Dakota Circle','5175456553','trobardg','pjddbUu8HAPY','Admin',65),(18,'Zacharias','Strothers','3/20/1989','Male','05179 Bunker Hill Way','5437134788','zstrothersh','D4BSkeZ5','Admin',841),(19,'Cori','Glyde','9/25/1991','Male','3462 Redwing Pass','9581253981','cglydei','t5JH4BZjKQk','Cashier',6),(20,'Brandtr','Coventry','3/16/1982','Male','4 Hermina Street','7044144982','bcoventryj','gIAsP8NuQr7','Cashier',22593),(21,'Bailie','Fechnie','1/17/1993','Male','3822 Comanche Court','1755956128','bfechniek','Kfcg5ck','Cashier',505),(22,'Phineas','Geddes','10/23/1984','Male','7539 Jenifer Point','5983574064','pgeddesl','ajJvoRzjjz','Admin',47925),(23,'Basil','Doddemeede','4/20/1973','Male','9590 Nobel Plaza','6206012030','bdoddemeedem','VIfeBHDlJt','Cashier',35507),(24,'Alphonso','Wyld','11/7/1986','Male','13 Lakeland Point','1347145008','awyldn','p9A5AbJzjtZG','Cashier',6065),(25,'Benedicto','Langdale','5/27/1997','Male','42941 Old Gate Junction','7468972116','blangdaleo','QVP5wh4QrS','Admin',47),(26,'Rakel','Trenbey','1/23/1988','Female','15 Mifflin Drive','7089625368','rtrenbeyp','e9mdJka9','Cashier',971),(27,'Julissa','Croll','12/15/1988','Female','8254 Donald Park','8851876152','jcrollq','rmQdxHpFic','Admin',3),(28,'Cariotta','Anstee','3/23/1985','Female','535 Mesta Way','6685220222','cansteer','ImW87RT','Admin',68),(29,'Northrup','Longlands','9/20/1982','Male','90 Ryan Junction','6621356419','nlonglandss','KPXqHQfT0','Cashier',208),(30,'Gilbertina','Durant','11/20/1998','Female','05 Westend Alley','7612461785','gdurantt','fItfpr','Cashier',85459),(31,'Brunhilda','Eastby','9/6/1979','Female','1 Lotheville Street','2203805700','beastbyu','FZkvpgttkjD','Admin',8),(32,'Harry','Gergher','10/17/1995','Male','56142 Delladonna Drive','6392532637','hgergherv','o6e31vKZ9','Cashier',91739),(33,'Fanya','Horney','8/25/1995','Female','9972 Brown Circle','3677498881','fhorneyw','K7xNFrDOEDbp','Cashier',52530),(34,'Tova','Delue','11/2/1998','Female','7842 Bay Court','3653639091','tdeluex','99XSz6IdY','Cashier',5),(35,'Creight','Potte','2/26/1984','Male','013 Pine View Park','7572307009','cpottey','8n5deK','Admin',57),(36,'Symon','Miles','8/4/1992','Male','2 Cordelia Trail','2925819384','smilesz','KIdMUvTZZu','Admin',51571),(37,'Reg','Domegan','2/16/1997','Male','85 Anniversary Circle','4623356424','rdomegan10','Ud2ErZA7J4f','Cashier',94052),(38,'Derk','Scay','3/30/1986','Male','5 Bunker Hill Alley','6264213808','dscay11','VS0l5F','Admin',34689),(39,'Sheilah','Bevans','9/27/1985','Female','179 Westport Lane','3961678954','sbevans12','VVKQF64hV','Cashier',4),(40,'Trescha','Tattersfield','7/9/1993','Female','25909 Calypso Park','1038725894','ttattersfield13','0gO0nR','Admin',7450),(41,'Nerte','McDermott','9/29/1974','Female','2293 Packers Crossing','3217656462','nmcdermott14','pmuQXUmng','Cashier',72),(42,'Felizio','Kinch','8/14/1997','Male','7570 Center Parkway','8002435858','fkinch15','fRU9YqY0maK','Admin',567),(43,'Jaquenette','Cabotto','6/9/1986','Female','08140 Independence Road','3737622998','jcabotto16','K1wAMzBx7','Admin',927),(44,'Bryanty','Nowlan','5/12/1981','Male','1753 Green Lane','7664170940','bnowlan17','xhVbLtqk','Admin',8),(45,'Clerkclaude','Howland','10/19/1986','Male','3294 Rowland Way','9487697923','chowland18','c39WTSeVdOLF','Cashier',6),(46,'Lennie','Reinhardt','5/17/1998','Male','13 Thackeray Place','2413561111','lreinhardt19','IXBNM547h','Admin',236),(47,'Tricia','Cockerill','12/12/1995','Female','0 Paget Parkway','9933604085','tcockerill1a','QCUNDBcTyy','Cashier',954),(48,'Silvester','De Rechter','11/1/1976','Male','47896 Ruskin Trail','7677906744','sderechter1b','BxqJrUk8j','Admin',54505),(49,'Mame','Bedminster','11/27/1981','Female','48871 Waywood Center','9379267142','mbedminster1c','iYzPO1K','Admin',99),(50,'Janel','Bolton','2/7/1993','Female','19639 Towne Avenue','8223472742','jbolton1d','tvt8pjC','Admin',40611),(51,'asdasdasd','wqeqweqwe','6/6/2022','Female','sdasdasdasd','682365596','dsasdasd','asdasda','Cashier',323434),(52,'Mattia','mm','5/30/2022','Male','aewfadasda','695623486','Mattia','Mattia','Cashier',21312312);
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
INSERT INTO `orderitems` VALUES (1,'EFRC','Bananas','Fruits-bananas',4,'3','12'),(1,'L3QG','Bananas','Fruits-bananas',4,'3','12'),(4,'L3QG','Potatoes','Vegetables-Potatoes',7,'3','21');
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
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogin`
--

LOCK TABLES `userlogin` WRITE;
/*!40000 ALTER TABLE `userlogin` DISABLE KEYS */;
INSERT INTO `userlogin` VALUES (1,'Admin','Admin','Admin'),(2,'pcabrer0','Mvcx1oGsHDlp','Cashier'),(3,'opapa1','4NRKixhG','Admin'),(4,'dvatini2','yLyrtXnxzOfs','Admin'),(5,'wbariball3','ji3MG2sRpPCS','Cashier'),(6,'fhowbrook4','1JtT3yqKE','Cashier'),(7,'kmotherwell5','BlzGu10lt7MS','Cashier'),(8,'gsimenot6','A8Mpily','Admin'),(9,'rprince8','3PMUXep9','Cashier'),(10,'ppetrol9','lQ2eHhhw','Cashier'),(11,'jkohnekea','hcCftD','Admin'),(12,'wringerb','PVz7gh','Admin'),(13,'agiacomic','5mfAntFl7','Admin'),(14,'nmaffinid','kmJ7FTNbVG','Admin'),(15,'amabeee','x16riM','Cashier'),(16,'smossf','xxpwA5L3vE','Cashier'),(17,'trobardg','pjddbUu8HAPY','Admin'),(18,'zstrothersh','D4BSkeZ5','Admin'),(19,'cglydei','t5JH4BZjKQk','Cashier'),(20,'bcoventryj','gIAsP8NuQr7','Cashier'),(21,'bfechniek','Kfcg5ck','Cashier'),(22,'pgeddesl','ajJvoRzjjz','Admin'),(23,'bdoddemeedem','VIfeBHDlJt','Cashier'),(24,'awyldn','p9A5AbJzjtZG','Cashier'),(25,'blangdaleo','QVP5wh4QrS','Admin'),(26,'rtrenbeyp','e9mdJka9','Cashier'),(27,'jcrollq','rmQdxHpFic','Admin'),(28,'cansteer','ImW87RT','Admin'),(29,'nlonglandss','KPXqHQfT0','Cashier'),(30,'gdurantt','fItfpr','Cashier'),(31,'beastbyu','FZkvpgttkjD','Admin'),(32,'hgergherv','o6e31vKZ9','Cashier'),(33,'fhorneyw','K7xNFrDOEDbp','Cashier'),(34,'tdeluex','99XSz6IdY','Cashier'),(35,'cpottey','8n5deK','Admin'),(36,'smilesz','KIdMUvTZZu','Admin'),(37,'rdomegan10','Ud2ErZA7J4f','Cashier'),(38,'dscay11','VS0l5F','Admin'),(39,'sbevans12','VVKQF64hV','Cashier'),(40,'ttattersfield13','0gO0nR','Admin'),(41,'nmcdermott14','pmuQXUmng','Cashier'),(42,'fkinch15','fRU9YqY0maK','Admin'),(43,'jcabotto16','K1wAMzBx7','Admin'),(44,'bnowlan17','xhVbLtqk','Admin'),(45,'chowland18','c39WTSeVdOLF','Cashier'),(46,'lreinhardt19','IXBNM547h','Admin'),(47,'tcockerill1a','QCUNDBcTyy','Cashier'),(48,'sderechter1b','BxqJrUk8j','Admin'),(49,'mbedminster1c','iYzPO1K','Admin'),(50,'jbolton1d','tvt8pjC','Admin'),(65,'Dion','1234','Customer'),(66,'ggoldsmith0','sc88t1tSmmp','Customer'),(67,'vsimounet1','c3YvXJXo','Customer'),(68,'cbohman2','MBOYykuFPN','Customer'),(69,'zglenny3','yzbns9','Customer'),(70,'cwhyte4','Bi8Fit','Customer'),(71,'adarke5','Dyb2Te','Customer'),(72,'swarman6','jPrX2h5GX','Customer'),(73,'sbuessen7','qDSuF4yA4C','Customer'),(74,'aboothebie8','3p5Ag0','Customer'),(75,'gchumley9','YHrMoWXn','Customer'),(76,'vpragnalla','gq0OGg','Customer'),(77,'ucleetonb','AC4BG0sn','Customer'),(78,'strivettc','kWrMXlI33Ch','Customer'),(79,'pduckitd','GFQvWu5gbO','Customer'),(80,'tsachere','DJO6Y8woM','Customer'),(81,'dfitzsimonf','Q7Aztn3h','Customer'),(82,'kpanting','eFvLt4rJ','Customer'),(83,'hlomish','NrIXKGK','Customer'),(84,'ashakesbyi','zpUIDIYzGOB','Customer'),(85,'jeastcourtj','AV42SiWMRFN','Customer'),(86,'nmackisonk','ugsaJp5Wt','Customer'),(87,'sscheul','JPGn7NYnP','Customer'),(88,'kdanksm','uEEfd5RuVbx','Customer'),(89,'lizzardn','h1bq5aJnG','Customer'),(90,'brustmano','FkJpnYac9EO','Customer'),(91,'rblemingsp','up0wfpo','Customer'),(92,'rbaughnq','z6AC40PF8ivF','Customer'),(93,'ecarnier','ybqbW6VlQ','Customer'),(94,'kcordelles','pxuz08lydRt','Customer'),(95,'gsellart','0QJu72EZ','Customer'),(96,'lgierckeu','aIOx0KNLm','Customer'),(97,'epeartv','QqYg9GsOPf','Customer'),(98,'wricciardow','Mc4QzjefXIo','Customer'),(99,'blegertonx','OCeuAnC2','Customer'),(100,'fwillimoty','IwMQdB7OVFdt','Customer'),(101,'aenrigoz','kfQvoK','Customer'),(102,'lhawtry10','3FDmrwf','Customer'),(103,'amulligan11','RnCZYBY','Customer'),(104,'kbyas12','URQX6rRo1YF2','Customer'),(105,'ehayter13','z5Q9WE2O27k','Customer'),(106,'smacallam14','ZOJSsMD','Customer'),(107,'jpeppett15','ofuE5iAV2','Customer'),(108,'hcreboe16','QlA1Ftv','Customer'),(109,'dround17','9VsnKzMnDDGK','Customer'),(110,'mgibberd18','wzvasfu5Y','Customer'),(111,'araynor19','5hcZmV6Z','Customer'),(112,'jbuff1a','6kL0vO','Customer'),(113,'jgaisford1b','yaAAO9ac','Customer'),(114,'bbellenger1c','NNLbWSHlEj','Customer'),(115,'mstiegers1d','eb3dJZ','Customer'),(116,'mcolqueran1e','O1mvPAjE5','Customer'),(117,'tjirus1f','13vKbpH6J6Kc','Customer'),(118,'msouness1g','dhvd7EJMZDdv','Customer'),(119,'bsheardown1h','kt876Tg','Customer'),(120,'ggreenhowe1i','sHIeeg','Customer'),(121,'rklement1j','wUN11RzrR','Customer'),(122,'lpicard1k','xv9QLN6zR4T0','Customer'),(123,'wlicciardo1l','eudSJk','Customer'),(124,'bwinkless1m','tQbJWvSXIPJ','Customer'),(125,'kdarkins1n','gBXTmfTPrx9I','Customer'),(126,'jmagson1o','Q7c2FFNVo1','Customer'),(127,'astange1p','QLjdZb','Customer'),(128,'pdufoure1q','y4YLx4trR','Customer'),(129,'dbrecken1r','s1JVEt6s6UJ','Customer'),(130,'mwindless1s','NmlM6m','Customer'),(131,'abezarra1t','4pdAUJS2','Customer'),(132,'rshreenan1u','lhNpsuyldKk','Customer'),(133,'bborrill1v','kvM7Ct','Customer'),(134,'jure1w','lRXnblZSqm','Customer'),(135,'lwollen1x','VJCL7w','Customer'),(136,'kdwine1y','qSw5VeRXWJfO','Customer'),(137,'eadamo1z','a7skKS5','Customer'),(138,'aeddoes20','1WxRHtj','Customer'),(139,'gkares21','aAN5UKZIfK','Customer'),(140,'bhaddick22','NLETVc2zre7','Customer'),(141,'aarthey23','Oix0WpJVfR','Customer'),(142,'ndomnick24','kR9hAqEfA','Customer'),(143,'zspilsburie25','GnM3glNvy','Customer'),(144,'rizakovitz26','vlJOfERN9kA','Customer'),(145,'bamy27','e9fLVDGo8B','Customer'),(146,'cverrechia28','5ttryh','Customer'),(147,'fparsell29','NlNEeuhT','Customer'),(148,'lashfold2a','EQ8Vf4A','Customer'),(149,'rclaricoates2b','FvgroZ1s','Customer'),(150,'jraeside2c','KkAIIRYL','Customer'),(151,'nbewshire2d','of4UcQsALxoL','Customer'),(152,'cberrick2e','aA9x9PH5','Customer'),(153,'jguiel2f','1pFGZsyN6zLu','Customer'),(154,'smarlon2g','ydC7F7M0kI','Customer'),(155,'aneil2h','ANXAL7V','Customer'),(156,'shasnney2i','rLxXkPmZOssp','Customer'),(157,'ltoombes2j','2q87pkXD','Customer'),(158,'smoye2k','wvjRgz43h9CA','Customer'),(159,'doskehan2l','TVSOPKpnd9','Customer'),(160,'oivkovic2m','7wempbA8J','Customer'),(161,'hstatter2n','dZdHoLhH8d','Customer'),(162,'lmolineux2o','K1hJ0zE5a','Customer'),(163,'mbilston2p','rKBeqf','Customer'),(164,'hheakey2q','o6N1NO','Customer'),(165,'cbannister2r','Y2AiNSETPT','Customer'),(194,'Dion1','1234','Customer'),(195,'dsasdasd','asdasda','Cashier'),(196,'Mattia','Mattia','Cashier');
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

-- Dump completed on 2022-06-17 12:26:38
