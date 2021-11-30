-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: szkola2
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `klasa`
--

DROP TABLE IF EXISTS `klasa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `klasa` (
  `id_klasa` int NOT NULL AUTO_INCREMENT,
  `id_nauczyciel` int NOT NULL,
  `Nazwa` varchar(45) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id_klasa`),
  KEY `fk_Klasa_Nauczyciel1_idx` (`id_nauczyciel`),
  CONSTRAINT `fk_Klasa_Nauczyciel1` FOREIGN KEY (`id_nauczyciel`) REFERENCES `nauczyciel` (`id_nauczyciel`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klasa`
--

LOCK TABLES `klasa` WRITE;
/*!40000 ALTER TABLE `klasa` DISABLE KEYS */;
INSERT INTO `klasa` VALUES (1,2,'2H'),(2,1,'4A'),(3,3,'5F');
/*!40000 ALTER TABLE `klasa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nauczyciel`
--

DROP TABLE IF EXISTS `nauczyciel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nauczyciel` (
  `id_nauczyciel` int NOT NULL AUTO_INCREMENT,
  `_id_przedmiot` int NOT NULL,
  `imie` varchar(45) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `nazwisko` varchar(45) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `PESEL` bigint DEFAULT NULL,
  `Data_urodzenia` date DEFAULT NULL,
  PRIMARY KEY (`id_nauczyciel`),
  KEY `fk_Nauczyciel_Przedmiot1_idx` (`_id_przedmiot`),
  CONSTRAINT `fk_Nauczyciel_Przedmiot1` FOREIGN KEY (`_id_przedmiot`) REFERENCES `przedmiot` (`id_przedmiot`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nauczyciel`
--

LOCK TABLES `nauczyciel` WRITE;
/*!40000 ALTER TABLE `nauczyciel` DISABLE KEYS */;
INSERT INTO `nauczyciel` VALUES (1,2,'Jan','Kowalski',23546754679,'1998-03-12'),(2,3,'Jacek','Sikora',23653487987,'1980-01-27'),(3,4,'Łukasz','Sokołowski',87436588656,'1995-11-08');
/*!40000 ALTER TABLE `nauczyciel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocena`
--

DROP TABLE IF EXISTS `ocena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ocena` (
  `id_ocena` int NOT NULL AUTO_INCREMENT,
  `wartosc` int DEFAULT NULL,
  `data` date DEFAULT NULL,
  `komentarz` varchar(45) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `id_przedmiot` int NOT NULL,
  `id_ucznia` int NOT NULL,
  `id_nauczyciel` int NOT NULL,
  PRIMARY KEY (`id_ocena`),
  KEY `fk_Ocena_Przedmiot1_idx` (`id_przedmiot`),
  KEY `fk_Ocena_Uczen1_idx` (`id_ucznia`),
  KEY `fk_Ocena_Nauczyciel1_idx` (`id_nauczyciel`),
  CONSTRAINT `fk_Ocena_Nauczyciel1` FOREIGN KEY (`id_nauczyciel`) REFERENCES `nauczyciel` (`id_nauczyciel`),
  CONSTRAINT `fk_Ocena_Przedmiot1` FOREIGN KEY (`id_przedmiot`) REFERENCES `przedmiot` (`id_przedmiot`),
  CONSTRAINT `fk_Ocena_Uczen1` FOREIGN KEY (`id_ucznia`) REFERENCES `uczen` (`id_uczen`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocena`
--

LOCK TABLES `ocena` WRITE;
/*!40000 ALTER TABLE `ocena` DISABLE KEYS */;
INSERT INTO `ocena` VALUES (1,6,'2020-04-17','Happy Birthday',4,3,1),(2,5,'2020-05-27','Dobrze',2,2,1),(3,3,'2018-09-05','Brak wiedzy',3,1,2);
/*!40000 ALTER TABLE `ocena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `przedmiot`
--

DROP TABLE IF EXISTS `przedmiot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `przedmiot` (
  `id_przedmiot` int NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(45) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id_przedmiot`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `przedmiot`
--

LOCK TABLES `przedmiot` WRITE;
/*!40000 ALTER TABLE `przedmiot` DISABLE KEYS */;
INSERT INTO `przedmiot` VALUES (1,'Chemia'),(2,'Matematyka'),(3,'Fizyka'),(4,'Polski'),(5,'Geografia');
/*!40000 ALTER TABLE `przedmiot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala_lekcyjna`
--

DROP TABLE IF EXISTS `sala_lekcyjna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala_lekcyjna` (
  `id_sala_lekcyjna` int NOT NULL AUTO_INCREMENT,
  `numer` int DEFAULT NULL,
  PRIMARY KEY (`id_sala_lekcyjna`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala_lekcyjna`
--

LOCK TABLES `sala_lekcyjna` WRITE;
/*!40000 ALTER TABLE `sala_lekcyjna` DISABLE KEYS */;
INSERT INTO `sala_lekcyjna` VALUES (1,234),(2,321),(3,123),(4,176),(5,267);
/*!40000 ALTER TABLE `sala_lekcyjna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uczen`
--

DROP TABLE IF EXISTS `uczen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uczen` (
  `id_uczen` int NOT NULL AUTO_INCREMENT,
  `id_klasa` int NOT NULL,
  `imie` varchar(45) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `nazwisko` varchar(45) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `PESEL` bigint DEFAULT NULL,
  `Data_urodzenia` date DEFAULT NULL,
  PRIMARY KEY (`id_uczen`),
  KEY `fk_Uczen_Klasa_idx` (`id_klasa`),
  CONSTRAINT `fk_Uczen_Klasa` FOREIGN KEY (`id_klasa`) REFERENCES `klasa` (`id_klasa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uczen`
--

LOCK TABLES `uczen` WRITE;
/*!40000 ALTER TABLE `uczen` DISABLE KEYS */;
INSERT INTO `uczen` VALUES (1,1,'Wojciech','Jarosz',NULL,'2014-03-20'),(2,2,'Jacek','Jarosz',NULL,'2003-01-20'),(3,3,'Krzysiek','Jarosz',NULL,'2018-11-20');
/*!40000 ALTER TABLE `uczen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zajecia`
--

DROP TABLE IF EXISTS `zajecia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zajecia` (
  `id_zajecia` int NOT NULL AUTO_INCREMENT,
  `id_nauczyciel` int NOT NULL,
  `id_klasa` int NOT NULL,
  `id_sala_lekcyjna` int NOT NULL,
  `Data` date NOT NULL,
  `Godzina` time NOT NULL,
  PRIMARY KEY (`id_zajecia`),
  KEY `fk_Zajecia_Nauczyciel1_idx` (`id_nauczyciel`),
  KEY `fk_Zajecia_Klasa1_idx` (`id_klasa`),
  KEY `fk_Zajecia_Sala_lekcyjna1_idx` (`id_sala_lekcyjna`),
  CONSTRAINT `fk_Zajecia_Klasa1` FOREIGN KEY (`id_klasa`) REFERENCES `klasa` (`id_klasa`),
  CONSTRAINT `fk_Zajecia_Nauczyciel1` FOREIGN KEY (`id_nauczyciel`) REFERENCES `nauczyciel` (`id_nauczyciel`),
  CONSTRAINT `fk_Zajecia_Sala_lekcyjna1` FOREIGN KEY (`id_sala_lekcyjna`) REFERENCES `sala_lekcyjna` (`id_sala_lekcyjna`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zajecia`
--

LOCK TABLES `zajecia` WRITE;
/*!40000 ALTER TABLE `zajecia` DISABLE KEYS */;
INSERT INTO `zajecia` VALUES (3,1,3,4,'2019-11-18','16:15:00'),(4,3,2,2,'2020-10-12','14:27:00');
/*!40000 ALTER TABLE `zajecia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-30 15:13:26
