CREATE DATABASE  IF NOT EXISTS `students` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `students`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: students
-- ------------------------------------------------------
-- Server version	5.7.3-m13

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
-- Table structure for table `student_admin`
--

DROP TABLE IF EXISTS `student_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_admin` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `username` char(255) NOT NULL,
  `password` char(255) NOT NULL,
  `name` char(255) NOT NULL,
  `phone` char(255) NOT NULL,
  `email` char(255) CHARACTER SET utf8 COLLATE utf8_estonian_ci NOT NULL,
  `work` char(255) NOT NULL,
  `type` int(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_admin`
--

LOCK TABLES `student_admin` WRITE;
/*!40000 ALTER TABLE `student_admin` DISABLE KEYS */;
INSERT INTO `student_admin` VALUES (1,'admin','admin','冯宇晖','123456789','123456789@qq.com','教三233',1);
/*!40000 ALTER TABLE `student_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_book`
--

DROP TABLE IF EXISTS `student_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_book` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `studentid` char(255) NOT NULL,
  `bookname` char(255) NOT NULL,
  `chengji` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_book`
--

LOCK TABLES `student_book` WRITE;
/*!40000 ALTER TABLE `student_book` DISABLE KEYS */;
INSERT INTO `student_book` VALUES (1,'2017140638','实训','100'),(2,'2017140638','信息系统','100'),(3,'123456','English','100'),(9,'2017140638','English',''),(10,'2017140638','需求工程',''),(11,'2017140610','计算机导论',''),(12,'2017140610','实训','95'),(13,'2017140610','English','');
/*!40000 ALTER TABLE `student_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_class`
--

DROP TABLE IF EXISTS `student_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_class` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `classid` char(255) NOT NULL,
  `classname` char(255) NOT NULL,
  `classs` char(255) NOT NULL,
  `classmust` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_class`
--

LOCK TABLES `student_class` WRITE;
/*!40000 ALTER TABLE `student_class` DISABLE KEYS */;
INSERT INTO `student_class` VALUES (1,'1001','信息系统','软件学院','必修课'),(2,'1002','English','人文学院','public'),(3,'1003','jisuanji','jisuanjikexue','public'),(4,'1004','实训','软件学院','必修'),(5,'1005','需求工程','软件学院','选修'),(6,'1006','高级数理逻辑','理学院','选修课'),(7,'1007','计算机导论','计算机学院','选修课');
/*!40000 ALTER TABLE `student_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_stu`
--

DROP TABLE IF EXISTS `student_stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_stu` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `studentid` char(255) NOT NULL,
  `studentsex` char(255) NOT NULL,
  `studentclass` char(255) NOT NULL,
  `studentyear` char(255) NOT NULL,
  `studentname` char(255) NOT NULL,
  `studentpassword` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_stu`
--

LOCK TABLES `student_stu` WRITE;
/*!40000 ALTER TABLE `student_stu` DISABLE KEYS */;
INSERT INTO `student_stu` VALUES (1,'123456','woman','软件001','2017','fyh','123456'),(2,'2017140638','女','软件学院','2017','冯宇晖','123456'),(3,'123456789','男','计算机学院','2017','李小明','123456'),(4,'2017140610','男','计算机学院','2017','严坤','123456');
/*!40000 ALTER TABLE `student_stu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_teacher`
--

DROP TABLE IF EXISTS `student_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_teacher` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `teacherid` char(255) NOT NULL,
  `teacherpassword` varchar(255) NOT NULL,
  `teachername` char(255) NOT NULL,
  `teacherfrom` char(255) NOT NULL,
  `teachersex` char(255) NOT NULL,
  `teacherphone` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_teacher`
--

LOCK TABLES `student_teacher` WRITE;
/*!40000 ALTER TABLE `student_teacher` DISABLE KEYS */;
INSERT INTO `student_teacher` VALUES (1,'001','001','傅湘玲','软件学院','woman','123456789'),(2,'002','002','李炜炜','人文学院','man','123456789'),(3,'003','003','王小明','计算机学院','男','123456789'),(4,'004','004','李华','经管院','女','123456789'),(5,'005','005','方开','自动化学院','男','123456789'),(6,'006','006','江文莉','国际学院','女','18810821061');
/*!40000 ALTER TABLE `student_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_book`
--

DROP TABLE IF EXISTS `teacher_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_book` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `teacherid` char(255) NOT NULL,
  `bookname` char(255) NOT NULL,
  `bookhouse` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_book`
--

LOCK TABLES `teacher_book` WRITE;
/*!40000 ALTER TABLE `teacher_book` DISABLE KEYS */;
INSERT INTO `teacher_book` VALUES (1,'004','离散数学','3#117'),(2,'001','实训','3#211'),(3,'003','高等数学','1#402'),(4,'001','信息系统','3#229'),(5,'002','English','3#233'),(6,'001','需求工程','3#239'),(7,'003','高级数理逻辑','3#339'),(8,'003','计算机导论','3#439');
/*!40000 ALTER TABLE `teacher_book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-23 20:59:28
