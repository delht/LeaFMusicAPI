-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: leafmusic4
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `id_album` int NOT NULL AUTO_INCREMENT,
  `ngay_phathanh` datetime(6) DEFAULT NULL,
  `ten_album` varchar(255) NOT NULL,
  `url_hinh` varchar(255) DEFAULT NULL,
  `id_casi` int DEFAULT NULL,
  PRIMARY KEY (`id_album`),
  KEY `fk_album_casi` (`id_casi`),
  CONSTRAINT `fk_album_casi` FOREIGN KEY (`id_casi`) REFERENCES `casi` (`id_casi`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (10,'2024-12-13 16:36:00.000000','MADE','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/Album/5611ccfc-1e84-4db1-86c8-a7b2f859ce19_ALBUM%20-%20MADE.jpg',8),(12,'2024-11-26 17:03:00.000000','BIGBANG IS VIP','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/Album/c0d44a25-5dc8-4b9a-9988-22d87f07dd80_ALBUM2.jpeg',8),(13,'2024-11-30 18:13:00.000000','Born Pink','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/Album/eeed538e-4f22-435f-83d0-32b986ad289e_Born_Pink_Digital.jpeg',9),(14,'2024-12-02 18:13:00.000000','Kill this love','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/Album/e1095458-ecc9-4e48-a55c-bab825e63831_71E5k5AlzEL._AC_SL1024_',9),(15,'2024-11-29 03:46:00.000000','I Wanna Dance','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/Album/049a0c92-a6e6-44c1-8da2-714fa5c941ee_album.jpg',10),(16,'2024-11-28 03:46:00.000000','The First Step','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/Album/f26ed21f-f43c-438a-b37a-b2e3146c93ff_101101musikDNa6.webp',10),(17,'2024-12-11 03:58:00.000000','Ai cũng phải bắt đầu từ đó','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/Album/bdcf01d4-3c66-42fa-9210-5b4ad2c443e8_ALBUM2.jpg',11),(18,'2024-11-30 03:59:00.000000','HIEUTHUHAI','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/Album/7496be00-4806-473d-8efb-a83607a99c0d_2.jpg',11),(19,'2024-12-09 04:10:00.000000','MTP','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/Album/bb7d3a93-d61d-498a-9e78-00481445cf2e_ab67616d0000b273af31997b23b7e6e65de1816b.jpg',12),(20,'2024-12-15 04:11:00.000000','SkyTour','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/Album/dc2015a6-79f8-4608-b727-3b33df75edb7_00ff3f754ae9667a3cf8047e41643430.jpg',12);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baihat`
--

DROP TABLE IF EXISTS `baihat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baihat` (
  `id_baihat` int NOT NULL AUTO_INCREMENT,
  `ngay_phathanh` datetime(6) DEFAULT NULL,
  `ten_baihat` varchar(255) NOT NULL,
  `url_file` varchar(255) DEFAULT NULL,
  `url_hinh` varchar(255) DEFAULT NULL,
  `id_album` int DEFAULT NULL,
  `id_casi` int DEFAULT NULL,
  `id_khuvuc` int DEFAULT NULL,
  `id_theloai` int DEFAULT NULL,
  PRIMARY KEY (`id_baihat`),
  KEY `FK9owc9xc7s6wnu1iywcrwyl5ys` (`id_album`),
  KEY `FK9iqxupeyrit22e9hqstmqu8ub` (`id_casi`),
  KEY `FKif480nsxv9r8b3ywluqfpjgql` (`id_khuvuc`),
  KEY `FKtfct20fheqm7brx96rt1yh0g0` (`id_theloai`),
  CONSTRAINT `FK9iqxupeyrit22e9hqstmqu8ub` FOREIGN KEY (`id_casi`) REFERENCES `casi` (`id_casi`),
  CONSTRAINT `FK9owc9xc7s6wnu1iywcrwyl5ys` FOREIGN KEY (`id_album`) REFERENCES `album` (`id_album`),
  CONSTRAINT `FKif480nsxv9r8b3ywluqfpjgql` FOREIGN KEY (`id_khuvuc`) REFERENCES `khuvuc_nhac` (`id_khuvuc`),
  CONSTRAINT `FKtfct20fheqm7brx96rt1yh0g0` FOREIGN KEY (`id_theloai`) REFERENCES `theloai` (`id_theloai`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baihat`
--

LOCK TABLES `baihat` WRITE;
/*!40000 ALTER TABLE `baihat` DISABLE KEYS */;
INSERT INTO `baihat` VALUES (15,'2024-12-06 17:50:00.000000','LastDance','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/35ce4ec5-a684-4307-a488-bebb272c4607_LastDance.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/4dd0d870-755e-4450-864b-2f465c3999b4_lastdance.jpg',10,8,8,7),(16,'2024-12-20 17:51:00.000000','Loser','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/2ef1c244-69e7-44d3-b292-a5bcfdb712ac_Loser.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/838c1497-6da1-4a3e-a5c5-1bef83432451_loser.jpg',10,8,8,7),(17,'2024-12-28 17:57:00.000000','HaruHaru','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/d26d549d-1a48-4c27-b4d1-db1bff23ca78_HaruHaru.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/ed3c634a-064b-46f4-9d34-ddc4619a934f_hary.jpg',12,8,8,7),(18,'2024-12-15 17:58:00.000000','Fantatic Baby','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/d345f710-3fc1-468f-9b0c-de5b0a4613ff_FantasicBaby.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/a82fdbff-da8e-4565-a246-e5b1c7c065c2_baby.jpg',12,8,8,7),(19,'2024-12-07 03:31:00.000000','Pink Venom','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/8536c982-a6f0-4090-823a-a375d805d926_PinkVenom.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/ed317b46-b4ca-4d73-b33b-e80a55b28110_s-l1200.jpg',13,9,8,7),(20,'2024-12-01 03:36:00.000000','Shut Down','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/c9a47167-4325-419c-9324-4e4fead79fbb_ShutDown.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/8bec8b90-58e4-49ab-b0c7-8bf8c7afdbc1_MV5BYzQ4OTY1YjYtMTQzMy00Y2E5LTlmZDktYmQ0NmY5YjdjYmRiXkEyXkFqcGc%40._V1_FMjpg_UX1000_',13,9,8,7),(21,'2024-12-14 03:40:00.000000','Kill this love','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/7f8496e6-a839-4dd3-be44-e6f3b13d7f1c_KillThisLove.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/d8fdf3ec-5e22-4b7d-b722-78ba788ac890_artworks-000516850659-ujfsmz-t500x500.jpg',14,9,8,7),(22,'2024-12-15 03:41:00.000000','HopeNot','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/0405067c-f44f-4b35-b3f1-d161abc3caaa_HopeNot.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/9a56b4df-531e-40b5-b7e7-2cd51f6e6b72_artworks-000527318127-1k5nc3-t500x500.jpg',14,9,8,7),(23,'2024-12-08 03:48:00.000000','Giận Lòng','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/8dc5117d-148f-481a-89b9-f54ec153ecb6_GianLong.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/5f41b16a-c9c9-45d3-8c48-219241934f5a_073a71ce84a4427891997116e7c3569b_1392351834.jpg',15,10,7,8),(24,'2024-12-06 03:50:00.000000','Xóa','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/a05c23b0-efc2-49fa-b225-8a09cf158af9_Xoa.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/05f05d84-27a1-49ac-94e4-9dd6b2315227_1383710963987_500.webp',15,10,7,8),(25,'2024-12-09 03:53:00.000000','Bối rối','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/294a398c-7b3a-4bf7-a952-fc128cb032f6_BoiRoi.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/37b3af8c-10de-41c0-a973-d06e857d9e4c_artworks-000221596928-ru5vb4-t500x500.jpg',16,10,7,8),(26,'2024-12-06 03:54:00.000000','Khóc','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/2241c5f8-c592-4110-8eef-32b30a2bf750_Khoc.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/9372a02a-4815-41b8-b47b-c95252ca1ed5_images.jpg',16,10,7,8),(27,'2024-11-30 04:01:00.000000','Exit Sign','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/3815a272-e562-468c-96fb-0713d70efc66_ExitSign.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/9a9b7821-8d7d-44af-8dff-65dbb5426da8_images.jpg',18,11,7,8),(28,'2024-12-01 04:01:00.000000','Không phải gu','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/1b5b2efb-4975-48dc-b2e7-91c4c7518fd4_KhongPhaiGu.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/a8a2ff47-fd9a-4fbf-b69d-cfe4f5b407b9_images%20%281%29.jpg',18,11,7,8),(29,'2024-12-07 04:05:00.000000','Cho em an toàn','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/6dae6ce4-4d1b-4c8d-9ef6-c42cd749098f_ChoEmAnToan.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/e0d4c3c3-9ff1-48ad-af77-10da1f8ce846_fdg.jpg',18,11,7,8),(30,'2024-12-14 04:07:00.000000','Không thể say','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/7bd9515e-bb61-469c-986e-23a4d00362b7_KhongTheSay.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/56b3d6f6-a842-4187-859d-9ef33980fea4_artworks-VAndO2zc3zAU4tnV-n1WpUA-t1080x1080.jpg',18,11,7,8),(31,'2024-12-22 04:12:00.000000','Anh sai rồi','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/5398fb65-c58c-4893-81a2-cacf53851765_AnhSaiRoi.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/ab2ee9b8-1876-49d5-8e59-ef170150a88f_369adae3c5e6ffb93f7d4c6d17b7a3d2.jpg',19,12,7,8),(32,'2024-12-05 04:13:00.000000','Nắng ấm xa dần','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/e750a5e7-ff84-4eed-bf18-7aa4a526f482_NangAmXaDan.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/d6a56e30-f986-4702-8957-b58bb7a8fdbf_S%C6%A1n_T%C3%B9ng_M-TP_-_N%E1%BA%AFng_%E1%BA%A5m_xa_d%E1%BA%A7n.png',19,12,7,8),(33,'2024-11-29 04:15:00.000000','Chạy ngay đi','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/34ff1cad-db18-4bba-855f-34e1862395fb_ChayNgayDi.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/aa77741f-82c2-4a1e-a5b1-b8e14e96f7ce_Chay_ngay_di.png',20,12,7,8),(34,'2024-11-30 04:14:00.000000','Hãy trao cho anh','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Mp3File/2ff7b238-b555-42cc-9865-b47e98fb4e75_HayTraoChoAnh.mp3','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/BaiHat/3aaaa886-04fa-4b5b-9d35-916415af7534_Hay-Trao-Cho-Anh.jpg',20,12,7,8);
/*!40000 ALTER TABLE `baihat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baihat_ds_yeuthich`
--

DROP TABLE IF EXISTS `baihat_ds_yeuthich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baihat_ds_yeuthich` (
  `id_item` int NOT NULL AUTO_INCREMENT,
  `id_baihat` int DEFAULT NULL,
  `id_ds` int DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `FK3d643wbpo52g1hc86o82sx38n` (`id_baihat`),
  KEY `FK20mvdtc77osfrdqa1y9c8md58` (`id_ds`),
  CONSTRAINT `FK20mvdtc77osfrdqa1y9c8md58` FOREIGN KEY (`id_ds`) REFERENCES `ds_yeuthich` (`id_ds`) ON DELETE CASCADE,
  CONSTRAINT `FK3d643wbpo52g1hc86o82sx38n` FOREIGN KEY (`id_baihat`) REFERENCES `baihat` (`id_baihat`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baihat_ds_yeuthich`
--

LOCK TABLES `baihat_ds_yeuthich` WRITE;
/*!40000 ALTER TABLE `baihat_ds_yeuthich` DISABLE KEYS */;
INSERT INTO `baihat_ds_yeuthich` VALUES (79,15,75),(81,33,76),(83,34,75),(84,33,75),(85,34,77);
/*!40000 ALTER TABLE `baihat_ds_yeuthich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casi`
--

DROP TABLE IF EXISTS `casi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casi` (
  `id_casi` int NOT NULL AUTO_INCREMENT,
  `ten_casi` varchar(255) DEFAULT NULL,
  `url_hinh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_casi`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casi`
--

LOCK TABLES `casi` WRITE;
/*!40000 ALTER TABLE `casi` DISABLE KEYS */;
INSERT INTO `casi` VALUES (8,'BIG BANG','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/CaSi/40c395e4-8790-48ef-9261-c8e441e942f3_1.png'),(9,'Black Pink','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/CaSi/4830db83-284e-4b5c-9e14-817df2fd6271_2.jpg'),(10,'Đông Nhi','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/CaSi/422a0150-8328-415a-877e-7f0908a827b9_boiroi.png'),(11,'HIEUTHUHAI','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/CaSi/0e47b8e7-2179-419c-83e6-938a35e2b372_ALBUM.jpg'),(12,'Sơn Tùng MTP','http://res.cloudinary.com/dw0rr01cm/raw/upload/v1/LeaFMusic/Images/CaSi/519d21a1-2dc5-446f-9b94-69aef77e68a9_ALBUM.jpg');
/*!40000 ALTER TABLE `casi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ds_yeuthich`
--

DROP TABLE IF EXISTS `ds_yeuthich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ds_yeuthich` (
  `id_ds` int NOT NULL AUTO_INCREMENT,
  `loai_ds` enum('macdinh','custom') DEFAULT 'custom',
  `ten_ds` varchar(255) NOT NULL,
  `id_taikhoan` int NOT NULL,
  PRIMARY KEY (`id_ds`),
  KEY `FKfajrb8ty2wbtpk8n0lu5vwoac` (`id_taikhoan`),
  CONSTRAINT `FKfajrb8ty2wbtpk8n0lu5vwoac` FOREIGN KEY (`id_taikhoan`) REFERENCES `taikhoan` (`id_taikhoan`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ds_yeuthich`
--

LOCK TABLES `ds_yeuthich` WRITE;
/*!40000 ALTER TABLE `ds_yeuthich` DISABLE KEYS */;
INSERT INTO `ds_yeuthich` VALUES (75,'macdinh','Danh sách yêu thích',22),(76,'custom','test1',22),(77,'macdinh','Danh sách yêu thích',23),(79,'macdinh','Danh sách yêu thích',25);
/*!40000 ALTER TABLE `ds_yeuthich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khuvuc_nhac`
--

DROP TABLE IF EXISTS `khuvuc_nhac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khuvuc_nhac` (
  `id_khuvuc` int NOT NULL AUTO_INCREMENT,
  `ten_khuvuc` varchar(255) NOT NULL,
  PRIMARY KEY (`id_khuvuc`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuvuc_nhac`
--

LOCK TABLES `khuvuc_nhac` WRITE;
/*!40000 ALTER TABLE `khuvuc_nhac` DISABLE KEYS */;
INSERT INTO `khuvuc_nhac` VALUES (7,'Việt Nam'),(8,'Hàn Quốc');
/*!40000 ALTER TABLE `khuvuc_nhac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `id_taikhoan` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `vaitro` enum('user','admin') DEFAULT 'user',
  PRIMARY KEY (`id_taikhoan`),
  UNIQUE KEY `UK9rrdg0nicwf847tn9cx6dg2cv` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (22,'25d55ad283aa400af464c76d713c07ad','thuanluong1230@gmail.com','user'),(23,'25d55ad283aa400af464c76d713c07ad','keynguyen3101@gmail.com','user'),(24,'25d55ad283aa400af464c76d713c07ad','admin','admin'),(25,'25d55ad283aa400af464c76d713c07ad','thuanluong2403@gmail.com','user');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theloai`
--

DROP TABLE IF EXISTS `theloai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theloai` (
  `id_theloai` int NOT NULL AUTO_INCREMENT,
  `ten_theloai` varchar(255) NOT NULL,
  PRIMARY KEY (`id_theloai`),
  UNIQUE KEY `UKsarlsdoqhjjrsijkbo0fd99vd` (`ten_theloai`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theloai`
--

LOCK TABLES `theloai` WRITE;
/*!40000 ALTER TABLE `theloai` DISABLE KEYS */;
INSERT INTO `theloai` VALUES (7,'KPOP'),(8,'Nhạc trẻ');
/*!40000 ALTER TABLE `theloai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'leafmusic4'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-21 15:27:08
