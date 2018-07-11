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
-- Table structure for table `t_lottery_hf_bj28`
--

DROP TABLE IF EXISTS `t_lottery_hf_bj28`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lottery_hf_bj28` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(24) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL COMMENT '公开开奖时间',
  `nextOfficialOpenTime` varchar(45) NOT NULL COMMENT '下一次开奖时间',
  `stopOrderTime` varchar(45) NOT NULL COMMENT '订单停止时间',
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='北京28';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lottery_hf_bjpk10`
--

DROP TABLE IF EXISTS `t_lottery_hf_bjpk10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lottery_hf_bjpk10` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(32) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='北京PK10';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lottery_hf_cqssc`
--

DROP TABLE IF EXISTS `t_lottery_hf_cqssc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lottery_hf_cqssc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(24) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='重庆时时彩';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lottery_hf_ffpk10`
--

DROP TABLE IF EXISTS `t_lottery_hf_ffpk10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lottery_hf_ffpk10` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(32) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='分分pk10';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lottery_hf_ffssc`
--

DROP TABLE IF EXISTS `t_lottery_hf_ffssc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lottery_hf_ffssc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(24) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='分分时时彩';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_lottery_hf_lk28`
--

DROP TABLE IF EXISTS `t_lottery_hf_lk28`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_lottery_hf_lk28` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(24) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='幸运28';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-08 19:08:06


DROP TABLE IF EXISTS `t_lottery_hf_lfpk10`;
CREATE TABLE `t_lottery_hf_lfpk10` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(32) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='二分PK10';

DROP TABLE IF EXISTS `t_lottery_hf_lfssc`;
CREATE TABLE `t_lottery_hf_lfssc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(24) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='二分时时彩';

DROP TABLE IF EXISTS `t_lottery_hf_lfpk10`;
CREATE TABLE `t_lottery_hf_lfpk10` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(24) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='二分时时彩';

DROP TABLE IF EXISTS `t_lottery_hf_lfk3`;
CREATE TABLE `t_lottery_hf_lfk3` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(24) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='二分快3';

DROP TABLE IF EXISTS `t_lottery_hf_ffk3`;
CREATE TABLE `t_lottery_hf_ffk3` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(24) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='分分快3';

DROP TABLE IF EXISTS `t_lottery_hf_bjk3`;
CREATE TABLE `t_lottery_hf_bjk3` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `planNo` int(11) NOT NULL,
  `lotteryNo` varchar(24) NOT NULL COMMENT '彩票期号',
  `resultNum` varchar(24) NOT NULL COMMENT '开奖号码',
  `officialOpenTime` varchar(45) NOT NULL,
  `nextOfficialOpenTime` varchar(45) NOT NULL,
  `stopOrderTime` varchar(45) NOT NULL,
  `sum` varchar(24) DEFAULT NULL COMMENT '总和',
  `bullfight` varchar(24) DEFAULT NULL COMMENT '斗牛',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lotteryNo_UNIQUE` (`lotteryNo`),
  UNIQUE KEY `planNo_UNIQUE` (`planNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='北京快3';



