-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mydbspor
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `antrenman`
--

DROP TABLE IF EXISTS `antrenman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antrenman` (
  `Gun` int(11) NOT NULL,
  `Gogus` int(11) DEFAULT NULL,
  `Sırt` int(11) DEFAULT NULL,
  `Kol` int(11) DEFAULT NULL,
  `Kanat` int(11) DEFAULT NULL,
  `Omuz` int(11) DEFAULT NULL,
  `Bacak` int(11) DEFAULT NULL,
  `MusteriNo` int(11) NOT NULL,
  `Gunİsim` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Gun`,`MusteriNo`),
  KEY `fk_Antrenman_Musteri1_idx` (`MusteriNo`),
  CONSTRAINT `fk_Antrenman_Musteri1` FOREIGN KEY (`MusteriNo`) REFERENCES `musteri` (`MusteriNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antrenman`
--

LOCK TABLES `antrenman` WRITE;
/*!40000 ALTER TABLE `antrenman` DISABLE KEYS */;
INSERT INTO `antrenman` VALUES (1,4,2,3,2,1,2,1000,'Pazartesi'),(1,5,4,5,4,5,4,1001,'Pazartesi'),(2,4,1,3,5,0,0,1000,'Salı'),(2,3,2,3,2,3,2,1001,'Çarşamba'),(3,2,1,3,0,1,4,1000,'Çarşamba'),(3,0,2,3,0,1,2,1001,'Cuma');
/*!40000 ALTER TABLE `antrenman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beslenmeprog`
--

DROP TABLE IF EXISTS `beslenmeprog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beslenmeprog` (
  `Vakit` varchar(45) NOT NULL,
  `MusteriNo` int(11) NOT NULL,
  `Pazartesi` varchar(45) DEFAULT NULL,
  `Salı` varchar(45) DEFAULT NULL,
  `Çarşamba` varchar(45) DEFAULT NULL,
  `Perşembe` varchar(45) DEFAULT NULL,
  `Cuma` varchar(45) DEFAULT NULL,
  `Cumartesi` varchar(45) DEFAULT NULL,
  `Pazar` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Vakit`,`MusteriNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beslenmeprog`
--

LOCK TABLES `beslenmeprog` WRITE;
/*!40000 ALTER TABLE `beslenmeprog` DISABLE KEYS */;
INSERT INTO `beslenmeprog` VALUES ('Akşam',1000,NULL,'et',NULL,NULL,NULL,NULL,NULL),('Akşam',1001,'tavuk',NULL,NULL,NULL,NULL,NULL,NULL),('Öğle',1000,NULL,'sebze',NULL,NULL,NULL,NULL,NULL),('Öğle',1001,'çorba',NULL,NULL,NULL,NULL,NULL,NULL),('Sabah',1000,NULL,'yumurta',NULL,NULL,NULL,NULL,NULL),('Sabah',1001,'Peynir',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `beslenmeprog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musteri`
--

DROP TABLE IF EXISTS `musteri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musteri` (
  `MusteriNo` int(11) NOT NULL,
  `Sifre` varchar(45) NOT NULL,
  `Ad` varchar(45) NOT NULL,
  `Soyad` varchar(45) NOT NULL,
  `DogumTarihi` varchar(45) DEFAULT NULL,
  `Telefon` int(11) DEFAULT NULL,
  `Adres` varchar(100) DEFAULT NULL,
  `kullaniciadi` varchar(45) DEFAULT NULL,
  `Resim` blob,
  PRIMARY KEY (`MusteriNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musteri`
--

LOCK TABLES `musteri` WRITE;
/*!40000 ALTER TABLE `musteri` DISABLE KEYS */;
INSERT INTO `musteri` VALUES (1000,'1234','Mehmet','Yılmaz','1990-01-01',520111223,'Ankara','birinci',NULL),(1001,'1234','Ayşe','Avcı','1985-08-05',520433431,'İstanbul','ikinci',NULL);
/*!40000 ALTER TABLE `musteri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saglikfizik`
--

DROP TABLE IF EXISTS `saglikfizik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saglikfizik` (
  `Boy` double DEFAULT NULL,
  `Kilo` double DEFAULT NULL,
  `YagOrani` double DEFAULT NULL,
  `KanGrubu` varchar(5) DEFAULT NULL,
  `Hastalik` varchar(45) DEFAULT NULL,
  `MusteriNo` int(11) NOT NULL,
  PRIMARY KEY (`MusteriNo`),
  CONSTRAINT `fk_SaglikFizik_Musteri` FOREIGN KEY (`MusteriNo`) REFERENCES `musteri` (`MusteriNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saglikfizik`
--

LOCK TABLES `saglikfizik` WRITE;
/*!40000 ALTER TABLE `saglikfizik` DISABLE KEYS */;
INSERT INTO `saglikfizik` VALUES (170,80,12,'A+','yok',1000),(160,90,20,'AB+','Astım',1001);
/*!40000 ALTER TABLE `saglikfizik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spordetaylari`
--

DROP TABLE IF EXISTS `spordetaylari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spordetaylari` (
  `UyelikTipi` varchar(45) DEFAULT NULL,
  `SporZamani` varchar(45) DEFAULT NULL,
  `HamamSauna` tinyint(4) DEFAULT NULL,
  `MusteriNo` int(11) NOT NULL,
  PRIMARY KEY (`MusteriNo`),
  CONSTRAINT `fk_SporDetaylari_Musteri1` FOREIGN KEY (`MusteriNo`) REFERENCES `musteri` (`MusteriNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spordetaylari`
--

LOCK TABLES `spordetaylari` WRITE;
/*!40000 ALTER TABLE `spordetaylari` DISABLE KEYS */;
INSERT INTO `spordetaylari` VALUES ('Fitness','Sabah',1,1000),('Body Building','Öğle',0,1001);
/*!40000 ALTER TABLE `spordetaylari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sporprogrami`
--

DROP TABLE IF EXISTS `sporprogrami`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sporprogrami` (
  `MusteriNo` int(11) NOT NULL,
  `Pazartesi` varchar(250) DEFAULT NULL,
  `Salı` varchar(250) DEFAULT NULL,
  `Çarşamba` varchar(250) DEFAULT NULL,
  `Perşembe` varchar(250) DEFAULT NULL,
  `Cuma` varchar(250) DEFAULT NULL,
  `Cumartesi` varchar(250) DEFAULT NULL,
  `Pazar` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`MusteriNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sporprogrami`
--

LOCK TABLES `sporprogrami` WRITE;
/*!40000 ALTER TABLE `sporprogrami` DISABLE KEYS */;
INSERT INTO `sporprogrami` VALUES (1000,'4-2-3-2-1-2','4-1-3-5-1-2','2-1-3-0-1-4',NULL,NULL,NULL,NULL),(1001,'5-4-5-4-5-4',NULL,'3-2-3-2-3-2',NULL,'4-2-3-2-1-2',NULL,NULL);
/*!40000 ALTER TABLE `sporprogrami` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonetici`
--

DROP TABLE IF EXISTS `yonetici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonetici` (
  `YoneticiNo` int(11) NOT NULL,
  `Ad` varchar(45) NOT NULL,
  `Soyad` varchar(45) NOT NULL,
  `kullaniciadi` varchar(45) NOT NULL,
  `sifre` varchar(45) NOT NULL,
  PRIMARY KEY (`YoneticiNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonetici`
--

LOCK TABLES `yonetici` WRITE;
/*!40000 ALTER TABLE `yonetici` DISABLE KEYS */;
INSERT INTO `yonetici` VALUES (2000,'Örnek','Yönetici','admin','admin');
/*!40000 ALTER TABLE `yonetici` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-18 23:38:26
