-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: pjmanagement
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien` (
  `StudentID` varchar(50) NOT NULL,
  `FullName` varchar(50) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `DateofBirth` date NOT NULL,
  `Class` varchar(20) NOT NULL,
  `PhoneNumber` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `ProjectName` varchar(45) NOT NULL,
  `CodeLanguage` varchar(12) NOT NULL,
  `Process` varchar(12) NOT NULL,
  PRIMARY KEY (`StudentID`),
  UNIQUE KEY `Full Name_UNIQUE` (`FullName`),
  UNIQUE KEY `Phone Number_UNIQUE` (`PhoneNumber`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  UNIQUE KEY `Project Name_UNIQUE` (`ProjectName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES ('SV001','Nguyễn Văn A','Nam','1995-04-01','IT01','0905123456','vana@gmail.com','Quản lý thư viện','Java','70%'),('SV002','Trần Thị B','Nữ','1996-08-15','IT02','0905234567','thib@gmail.com','Hệ thống bán hàng','Python','60%'),('SV003','Lê Hoàng C','Nam','1994-12-22','IT03','0905345678','hoangc@gmail.com','Ứng dụng di động','Kotlin','80%'),('SV004','Phạm Thanh D','Nữ','1996-05-30','IT04','0905456789','thanhd@gmail.com','Website tin tức','PHP','50%'),('SV005','Đỗ Minh E','Nam','1997-03-14','IT05','0905567890','minhe@gmail.com','Hệ thống quản lý nhân sự','C#','75%'),('SV006','Nguyễn Thị F','Nữ','1995-07-19','IT06','0905678901','thif@gmail.com','Ứng dụng quản lý tài chính','Ruby','85%'),('SV007','Lê Anh G','Nam','1996-01-25','IT07','0905789012','anhg@gmail.com','Trò chơi di động','Unity','90%'),('SV008','Trần Hải Ha','Female','1997-09-05','IT08','0905890123','haih@gmail.com','Ứng dụng đặt phòng khách sạn','Swift','65%'),('SV009','Phạm Văn I','Nam','1995-11-11','IT09','0905012345','vani@gmail.com','Hệ thống quản lý bán hàng trực tuyến','JavaScript','55%'),('SV010','Đỗ Thị J112','Female','1996-06-20','IT10','0905123450','thij@gmail.com','Ứng dụng theo dõi sức khỏe','React Native','70%');
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-06  1:04:34
