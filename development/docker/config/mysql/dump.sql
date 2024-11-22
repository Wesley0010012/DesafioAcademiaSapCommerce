-- MySQL dump 10.13  Distrib 8.4.0, for Linux (x86_64)
--
-- Host: localhost    Database: cursos
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `aln_id` bigint NOT NULL AUTO_INCREMENT,
  `aln_data_cadastro` datetime(6) NOT NULL,
  `aln_email` varchar(80) NOT NULL,
  `aln_nome` varchar(80) NOT NULL,
  `aln_registro_academico` varchar(50) NOT NULL,
  PRIMARY KEY (`aln_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'2024-11-21 20:50:59.993000','henry@email.com','Henry Townshend','2775581d-b868-4280-be65-e76ea1d313d5'),(2,'2024-11-21 20:51:42.060000','anatoly@email.com','Anatoly Karpov','c9540bdc-b566-4373-8868-e9d99ad06b2c');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `crs_id` bigint NOT NULL AUTO_INCREMENT,
  `crs_data_criacao` datetime(6) NOT NULL,
  `crs_email` varchar(80) NOT NULL,
  `crs_nome` varchar(80) NOT NULL,
  `crs_registro` varchar(80) NOT NULL,
  PRIMARY KEY (`crs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'2024-11-21 20:50:17.079000','Curso de Física 1.','FISICA 1','57114da6-633c-48a7-8ae8-bb70f5e671cc'),(2,'2024-11-21 20:50:22.422000','Curso de Física 2.','FISICA 2','699998c4-cc9f-4dc5-81d9-a15dbf9ddf6d'),(3,'2024-11-21 20:50:36.932000','Curso de Engenharia 1.','ENGENHARIA 1','81037988-3099-4376-9112-bc5ac937723c'),(4,'2024-11-21 20:52:15.546000','Curso de jogo posicional de Xadrez.','JOGO POSICIONAL','f763498a-687b-4496-838f-6ac451d205ab');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscricao`
--

DROP TABLE IF EXISTS `inscricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscricao` (
  `ins_id` bigint NOT NULL AUTO_INCREMENT,
  `ins_data_inscricao` datetime(6) NOT NULL,
  `ins_aln_id` bigint NOT NULL,
  `ins_crs_id` bigint NOT NULL,
  PRIMARY KEY (`ins_id`),
  KEY `FKtkaw5n8plli4ytixntjrr3ug5` (`ins_aln_id`),
  KEY `FK92k8q9hk14m8jdf4bg1xhtm1n` (`ins_crs_id`),
  CONSTRAINT `FK92k8q9hk14m8jdf4bg1xhtm1n` FOREIGN KEY (`ins_crs_id`) REFERENCES `curso` (`crs_id`),
  CONSTRAINT `FKtkaw5n8plli4ytixntjrr3ug5` FOREIGN KEY (`ins_aln_id`) REFERENCES `aluno` (`aln_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscricao`
--

LOCK TABLES `inscricao` WRITE;
/*!40000 ALTER TABLE `inscricao` DISABLE KEYS */;
INSERT INTO `inscricao` VALUES (1,'2024-11-21 20:58:00.737000',1,1),(2,'2024-11-21 20:58:31.434000',1,2),(3,'2024-11-21 20:58:41.453000',1,3),(4,'2024-11-21 20:58:52.904000',1,4),(5,'2024-11-21 21:02:09.711000',2,4);
/*!40000 ALTER TABLE `inscricao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-22  0:02:48
