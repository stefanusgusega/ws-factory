-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: factory
-- ------------------------------------------------------
-- Server version	10.4.14-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `add_stock`
--

DROP TABLE IF EXISTS `add_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `add_stock` (
  `id_add_stock` int(11) NOT NULL AUTO_INCREMENT,
  `nama_coklat` varchar(30) NOT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_add_stock`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_stock`
--

LOCK TABLES `add_stock` WRITE;
/*!40000 ALTER TABLE `add_stock` DISABLE KEYS */;
INSERT INTO `add_stock` VALUES (1,'choco',10,'delivered'),(2,'fefe',30,'pending'),(3,'jj\'0',30,'pending'),(4,'jj\'0',20,'delivered');
/*!40000 ALTER TABLE `add_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bahan`
--

DROP TABLE IF EXISTS `bahan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bahan` (
  `id_bahan` int(11) NOT NULL AUTO_INCREMENT,
  `nama_bahan` varchar(50) NOT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `tanggal_kadaluwarsa` date DEFAULT NULL,
  PRIMARY KEY (`id_bahan`),
  UNIQUE KEY `unique_nama_bahan` (`nama_bahan`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bahan`
--

LOCK TABLES `bahan` WRITE;
/*!40000 ALTER TABLE `bahan` DISABLE KEYS */;
INSERT INTO `bahan` VALUES (1,'susu',30,'2022-10-01'),(2,'kakao',50,'2022-10-01'),(3,'gula pasir',50,'2022-10-01'),(4,'vanilla',50,'2022-10-01'),(5,'madu',50,'2022-10-01'),(6,'garam',50,'2022-10-01'),(7,'minyak kelapa',50,'2022-10-01'),(8,'bubuk cocoa',50,'2022-10-01'),(9,'wallnut',50,'2022-10-01'),(10,'kelapa',50,'2022-10-01'),(11,'almond',50,'2022-10-01'),(12,'sprinkle',50,'2022-10-01'),(13,'coffee',50,'2022-10-01'),(14,'jeruk',50,'2022-10-01'),(16,'mesis coklat',50,'2022-10-01'),(17,'mesis mix',50,'2022-10-01'),(18,'cocoa butter',50,'2022-10-01'),(19,'mentega',50,'2022-10-01'),(20,'tepung terigu',50,'2022-10-01'),(21,'baking soda',50,'2022-10-01'),(22,'gula aren',50,'2022-10-01'),(23,'telur',50,'2022-10-01'),(24,'milk choco',50,'0000-00-00'),(25,'white choco',50,'0000-00-00'),(26,'dark choco',50,'0000-00-00'),(27,'pewarna makanan',50,'0000-00-00');
/*!40000 ALTER TABLE `bahan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gudang`
--

DROP TABLE IF EXISTS `gudang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gudang` (
  `id_coklat` int(11) DEFAULT NULL,
  `nama_coklat` varchar(30) NOT NULL,
  `jumlah` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gudang`
--

LOCK TABLES `gudang` WRITE;
/*!40000 ALTER TABLE `gudang` DISABLE KEYS */;
INSERT INTO `gudang` VALUES (1,'Dark chocolate',100),(2,'JJ8',100),(3,'choco',100),(4,'Susanti Gojali',100),(5,'coco',100),(6,'fefe',100),(7,'dwdw',100),(8,'okok',100),(9,'jj\'0',100),(10,'chacha',100);
/*!40000 ALTER TABLE `gudang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resep`
--

DROP TABLE IF EXISTS `resep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resep` (
  `id_coklat` int(11) DEFAULT NULL,
  `nama_coklat` varchar(30) DEFAULT NULL,
  `nama_bahan` varchar(50) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  KEY `fk_namabahan_tbl_resep` (`nama_bahan`),
  CONSTRAINT `fk_namabahan_tbl_resep` FOREIGN KEY (`nama_bahan`) REFERENCES `bahan` (`nama_bahan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resep`
--

LOCK TABLES `resep` WRITE;
/*!40000 ALTER TABLE `resep` DISABLE KEYS */;
INSERT INTO `resep` VALUES (1,'Dark chocolate','kakao',100),(1,'Dark chocolate','gula pasir',100),(1,'Dark chocolate','garam',100),(2,'JJ8','white choco',100),(2,'JJ8','dark choco',100),(2,'JJ8','milk choco',100),(2,'JJ8','gula pasir',100),(2,'JJ8','gula aren',100),(2,'JJ8','susu',100),(3,'choco','white choco',100),(3,'choco','dark choco',100),(3,'choco','milk choco',100),(3,'choco','susu',100),(3,'choco','gula pasir',100),(3,'choco','gula aren',100),(3,'choco','bubuk cocoa',100),(2,'JJ8','bubuk cocoa',100),(4,'Susanti Gojali','susu',100),(4,'Susanti Gojali','kakao',100),(4,'Susanti Gojali','gula pasir',100),(4,'Susanti Gojali','cocoa butter',100),(4,'Susanti Gojali','garam',100),(4,'Susanti Gojali','vanilla',100),(5,'coco','telur',100),(5,'coco','gula pasir',100),(5,'coco','tepung terigu',100),(5,'coco','baking soda',100),(5,'coco','bubuk cocoa',100),(5,'coco','mentega',100),(6,'fefe','gula pasir',100),(6,'fefe','tepung terigu',100),(6,'fefe','baking soda',100),(6,'fefe','bubuk cocoa',100),(6,'fefe','almond',100),(6,'fefe','wallnut',100),(6,'fefe','mentega',100),(6,'fefe','white choco',100),(6,'fefe','milk choco',100),(7,'dwdw','milk choco',100),(7,'dwdw','sprinkle',100),(7,'dwdw','gula pasir',100),(7,'dwdw','tepung terigu',100),(7,'dwdw','dark choco',100),(8,'okok','milk choco',100),(8,'okok','tepung terigu',100),(8,'okok','mesis coklat',100),(8,'okok','sprinkle',100),(8,'okok','wallnut',100),(8,'okok','gula pasir',100),(8,'okok','bubuk cocoa',100),(9,'jj\'0','white choco',100),(9,'jj\'0','dark choco',100),(9,'jj\'0','milk choco',100),(9,'jj\'0','susu',100),(9,'jj\'0','gula pasir',100),(9,'jj\'0','gula aren',100),(9,'jj\'0','pewarna makanan',100),(9,'jj\'0','bubuk cocoa',100),(10,'chacha','milk choco',100),(10,'chacha','pewarna makanan',100),(10,'chacha','gula pasir',100);
/*!40000 ALTER TABLE `resep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saldo`
--

DROP TABLE IF EXISTS `saldo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saldo` (
  `uang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saldo`
--

LOCK TABLES `saldo` WRITE;
/*!40000 ALTER TABLE `saldo` DISABLE KEYS */;
INSERT INTO `saldo` VALUES (500000000);
/*!40000 ALTER TABLE `saldo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-18 17:29:36
