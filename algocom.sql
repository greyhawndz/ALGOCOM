-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: securde2
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `accountingmanager_account`
--

DROP TABLE IF EXISTS `accountingmanager_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accountingmanager_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `password_changed` varchar(45) NOT NULL,
  `date` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountingmanager_account`
--

LOCK TABLES `accountingmanager_account` WRITE;
/*!40000 ALTER TABLE `accountingmanager_account` DISABLE KEYS */;
INSERT INTO `accountingmanager_account` VALUES (1,'articuno','mystic','articuno@mystic.com','active','yes','2016-08-18 17:00:00.000000'),(2,'mew','123456','mew@gmail.com','active','no','2016-08-20 08:00:28.687000');
/*!40000 ALTER TABLE `accountingmanager_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator_account`
--

DROP TABLE IF EXISTS `administrator_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator_account`
--

LOCK TABLES `administrator_account` WRITE;
/*!40000 ALTER TABLE `administrator_account` DISABLE KEYS */;
INSERT INTO `administrator_account` VALUES (1,'zapdos','instinct','zapdos@instinct.com');
/*!40000 ALTER TABLE `administrator_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billing_address`
--

DROP TABLE IF EXISTS `billing_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing_address` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `house_no` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `subdivision` varchar(255) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `country` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_idx` (`customer_id`),
  CONSTRAINT `user_billing` FOREIGN KEY (`customer_id`) REFERENCES `customer_account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing_address`
--

LOCK TABLES `billing_address` WRITE;
/*!40000 ALTER TABLE `billing_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `billing_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_card`
--

DROP TABLE IF EXISTS `credit_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credit_num` varchar(16) NOT NULL,
  `security_code` varchar(3) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `balance` double NOT NULL,
  `full_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card`
--

LOCK TABLES `credit_card` WRITE;
/*!40000 ALTER TABLE `credit_card` DISABLE KEYS */;
INSERT INTO `credit_card` VALUES (1,'1234567890123456','111','Nica','de Jesus',901427,'Nica de Jesus');
/*!40000 ALTER TABLE `credit_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_account`
--

DROP TABLE IF EXISTS `customer_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `middle_initial` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `billing_house_no` varchar(255) NOT NULL,
  `billing_street` varchar(255) NOT NULL,
  `billing_subdivision` varchar(255) NOT NULL,
  `billing_postal_code` varchar(255) NOT NULL,
  `billing_country` varchar(255) NOT NULL,
  `shipping_house_no` varchar(255) NOT NULL,
  `shipping_street` varchar(255) NOT NULL,
  `shipping_subdivision` varchar(255) NOT NULL,
  `shipping_postal_code` varchar(255) NOT NULL,
  `shipping_country` varchar(255) NOT NULL,
  `billing_city` varchar(255) NOT NULL,
  `shipping_city` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `billing_address_idx` (`billing_house_no`),
  KEY `shipping_address_idx` (`billing_street`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_account`
--

LOCK TABLES `customer_account` WRITE;
/*!40000 ALTER TABLE `customer_account` DISABLE KEYS */;
INSERT INTO `customer_account` VALUES (1,'Nica','ilovepaolo69','Nica','de Jesus','Mangubat','ilovepaolo@gmail.com','1','taft','Malate','6969','Philippines','1','taft','Malate','6969','Philippines','Manila','Manila'),(2,'avzxsfeh','123456','William','Dionio','A','avzxsfeh@gmail.com','2','Vasquez','Malate','1234','Philippines','2','Vasquez','Malate','1234','Philippines','Manila','Manila'),(3,'KayeSolomon','securde','Kaye','Solomon','C','kaye@gmail.com','1','La Salle','Kaye','232','Philippines','1','La Salle','Kaye','232','Philippines','Manila','Manila'),(4,'glenn','123456','Glenn','Matias','H','glennyboy@gmail.com','2','taft','Malate','1234','Philippines','','taft','Malate','1234','Philippines','Manila','Manila'),(5,'sho','123456','Sho','Chiba','Y','shochiba@gmail.com','1','taft','Malate','1234','Philippines','1','taft','Malate','1234','Philippines','Manila','Manila');
/*!40000 ALTER TABLE `customer_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `account_privilege` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (1,'Nica','customer'),(2,'avzxsfeh','customer'),(3,'KayeSolomon','customer'),(4,'glenn','customer'),(5,'sho','customer'),(6,'zapdos','admin'),(7,'moltres','product manager'),(8,'articuno','accounting manager'),(9,'mewtwo','product manager'),(10,'mew','accounting manager'),(11,'Gengar','product manager');
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `description` varchar(500) NOT NULL,
  `category` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Chuck Taylor',2596,'Black','Shoes','converse2.jpg'),(2,'Brown Claw',934,'I’m BIG, brown bearish and playful. Need a bear hug for your feet? I’m your man!','Slippers','converse2.jpg'),(3,'Steve Madden Donddi Flat Sandals',3333,'Who is Steve Madden Donddi?','Sandals','converse2.jpg'),(4,'Leopard Print Boots',623,'Just notice that “less is more” flash of fur on the tops of our scrummy boots. And when your knees are cold or you’re just not wanting to get noticed, turn the cuffs up then in the blink of an eye … hey presto … a totally different, unrecognisable and “go with anything” pair of boots.','Boots','converse2.jpg'),(13,'Magic Stick',999,'I got the magic stick\r\nI know if I can hit once, I can hit twice\r\nI hit the baddest chicks\r\nShorty don\'t believe me, then come with me tonight\r\nAnd I\'ll show you magic\r\n(What? What?) Magic (uh huh uh huh)\r\nI got the magic stick','Shoes','converse2.jpg'),(14,'In Da Club',5000,'Go, go, go, go go, go, go, shawty\r\nIt\'s your birthday\r\nWe gon\' party like it\'s yo birthday\r\nWe gon\' sip Bacardi like it\'s your birthday','Sandals','converse2.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_review`
--

DROP TABLE IF EXISTS `product_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `review` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_review`
--

LOCK TABLES `product_review` WRITE;
/*!40000 ALTER TABLE `product_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_transaction`
--

DROP TABLE IF EXISTS `product_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `timestamp` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_transaction`
--

LOCK TABLES `product_transaction` WRITE;
/*!40000 ALTER TABLE `product_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productmanager_account`
--

DROP TABLE IF EXISTS `productmanager_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productmanager_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `password_changed` varchar(45) NOT NULL,
  `date` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productmanager_account`
--

LOCK TABLES `productmanager_account` WRITE;
/*!40000 ALTER TABLE `productmanager_account` DISABLE KEYS */;
INSERT INTO `productmanager_account` VALUES (1,'moltres','valor','moltres@valor.com','active','yes','2016-08-18 17:00:00.000000'),(2,'mewtwo','psychic','mewtwo@gmail.com','active','no','2016-08-20 07:53:21.419000'),(3,'Gengar','123456','gengar@gmail.com','active','no','2016-08-20 08:07:00.937000');
/*!40000 ALTER TABLE `productmanager_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `category` varchar(45) NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,'Chuck Taylor','Shoes',407788),(2,'Brown Claw','Slippers',230000),(3,'Steve Madden Donddi Flat Sandals','Sandals',36666),(4,'Leopard Print Boots','Boots',380000),(5,'Magic Stick','Shoes',700000),(6,'In Da Club','Sandals',1000000);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_address`
--

DROP TABLE IF EXISTS `shipping_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipping_address` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `house_no` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `subdivision` varchar(255) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `country` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_idx` (`customer_id`),
  CONSTRAINT `user_shipping` FOREIGN KEY (`customer_id`) REFERENCES `customer_account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_address`
--

LOCK TABLES `shipping_address` WRITE;
/*!40000 ALTER TABLE `shipping_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
INSERT INTO `shopping_cart` VALUES (7,2,2,1);
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-26 19:56:17
