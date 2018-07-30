-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: lottery
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `t_lottery_list`
--

DROP TABLE IF EXISTS `t_lottery_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lottery_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lottery_id` varchar(10) NOT NULL COMMENT '彩票ID',
  `lottery_type_id` int(11) NOT NULL COMMENT ' 彩票类型，1:福利彩票 2:体育彩票,3:高频彩',
  `lottery_name` varchar(20) NOT NULL COMMENT '彩票名称',
  `lottery_group` varchar(16) DEFAULT NULL COMMENT '彩票组',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态，0开启，1禁用',
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `remarks` varchar(100) DEFAULT NULL COMMENT ' 描述信息',
  PRIMARY KEY (`id`,`lottery_id`),
  UNIQUE KEY `lottery_id_UNIQUE` (`lottery_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_lottery_list`
--

LOCK TABLES `t_lottery_list` WRITE;
/*!40000 ALTER TABLE `t_lottery_list` DISABLE KEYS */;
INSERT INTO `t_lottery_list` VALUES (1,'ssq',1,'双色球',NULL,'0','2018-04-10 17:27:38','每周二、四、日开奖'),(2,'dlt',2,'超级大乐透',NULL,'0','2018-04-10 17:27:39','每周一、三、六开奖'),(3,'qlc',1,'七乐彩',NULL,'0','2018-04-10 17:27:39','每周一、三、五开奖'),(4,'fcsd',1,'福彩3D',NULL,'0','2018-04-10 17:27:39','每日开奖'),(5,'qxc',2,'七星彩',NULL,'0','2018-04-10 17:27:39','每周二、五、日开奖'),(6,'pls',2,'排列3',NULL,'0','2018-04-10 17:27:39','每日开奖'),(7,'plw',2,'排列5',NULL,'0','2018-04-10 17:27:39','每日开奖'),(8,'cqssc',3,'重庆时时彩','时时彩','0','2018-06-05 10:37:58','每10分钟或5分钟开奖'),(9,'ffssc',3,'分分时时彩','时时彩','0','2018-06-05 10:51:58','每1分钟开奖'),(10,'bjpk10',3,'北京PK拾','PK拾','0','2018-06-05 10:53:28','每5分钟开奖'),(11,'ffpk10',3,'分分PK拾','PK拾','0','2018-06-05 10:54:34','每1分钟开奖'),(12,'lk28',3,'幸运28','PC蛋蛋','0','2018-06-05 10:56:11','每2分钟开奖'),(13,'bj28',3,'北京28','PC蛋蛋','0','2018-06-05 10:56:56','每5分钟开奖'),(14,'tjssc',3,'天津时时彩','时时彩','0','2018-07-13 16:52:43','每10分钟开奖'),(15,'xjssc',3,'新疆时时彩','时时彩','0','2018-07-13 16:52:43','每10分钟开奖'),(16,'lfssc',3,'二分时时彩','时时彩','0','2018-07-13 16:52:43',NULL),(17,'lfpk10',3,'二分PK拾','PK拾','0','2018-07-13 16:52:43',NULL),(18,'jbk3',3,'北京快3','快3','0','2018-07-13 16:52:43','每10分钟开奖'),(19,'lfk3',3,'二分快3','快3','0','2018-07-13 16:52:43','每2分钟开奖'),(20,'ahd11',3,'安徽11选5','11选5','0','2018-07-28 16:52:43','每10分钟开奖'),(21,'gdd11',3,'广东11选5','11选5','0','2018-07-28 16:52:43','每10分钟开奖'),(22,'jxd11',3,'江西11选5','11选5','0','2018-07-28 16:52:43','每10分钟开奖'),(23,'sdd11',3,'山东11选5','11选5','0','2018-07-28 16:52:43','每10分钟开奖'),(24,'shd11',3,'上海11选5','11选5','0','2018-07-28 16:52:43','每10分钟开奖'),(25,'ahk3',3,'安徽快3','快3','0','2018-07-28 16:52:43','每10分钟开奖'),(26,'gxk3',3,'广西快3','快3','0','2018-07-28 16:52:43','每10分钟开奖'),(27,'jsk3',3,'江苏快3','快3','0','2018-07-28 16:52:43','每10分钟开奖'),(28,'jlk3',3,'吉林快3','快3','0','2018-07-28 16:52:43','每10分钟开奖'),(29,'gdkl10f',3,'广东快乐十分','快乐10分','0','2018-07-28 16:52:43','每10分钟开奖'),(30,'cqkl10f',3,'重庆快乐十分','快乐10分','0','2018-07-28 16:52:43','每10分钟开奖'),(31,'shssl',3,'上海时时乐','时时乐','0','2018-07-28 16:52:43','每30分钟开奖'),(32,'lfklpk',3,'幸运扑克','扑克','0','2018-07-28 16:52:43','每30分钟开奖'),(33,'xyft',3,'幸运飞艇','幸运','0','2018-07-28 16:52:43','每5分钟开奖'),(34,'xysm',3,'幸运赛马','幸运','0','2018-07-28 16:52:43','每5分钟开奖'),(35,'xglhc',1,'香港六合彩',NULL,'0','2018-07-28 16:52:43','每周三期，周二、周四和周六(或周日)的21:33开奖'),(36,'jslhc',3,'极速六合彩','六合彩','0','2018-07-28 16:13:35','每5分钟开奖'),(37,'fjd11',3,'福建11选5','11选5','0','2018-07-28 16:13:35','每10分钟开奖'),(38,'ffk3',3,'分分快3','快3','0','2018-07-28 16:52:43','每1分钟开奖');
/*!40000 ALTER TABLE `t_lottery_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-30 19:43:05