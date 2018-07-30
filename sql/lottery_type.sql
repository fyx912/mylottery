
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

DROP TABLE IF EXISTS `t_lottery_hf_tjssc`;
CREATE TABLE `t_lottery_hf_tjssc` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='天津时时彩';


DROP TABLE IF EXISTS `t_lottery_hf_xjssc`;
CREATE TABLE `t_lottery_hf_xjssc` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='新疆时时彩';
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

DROP TABLE IF EXISTS `t_lottery_hf_ahd11`;
CREATE TABLE `t_lottery_hf_ahd11` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='安徽11选5';

DROP TABLE IF EXISTS `t_lottery_hf_sdd11`;
CREATE TABLE `t_lottery_hf_sdd11` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='山东11选5';

DROP TABLE IF EXISTS `t_lottery_hf_shd11`;
CREATE TABLE `t_lottery_hf_shd11` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='上海11选5';

DROP TABLE IF EXISTS `t_lottery_hf_ahk3`;
CREATE TABLE `t_lottery_hf_ahk3` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='安徽快3';

DROP TABLE IF EXISTS `t_lottery_hf_cqkl10f`;
CREATE TABLE `t_lottery_hf_cqkl10f` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='重庆快乐10分';

DROP TABLE IF EXISTS `t_lottery_hf_fjd11`;
CREATE TABLE `t_lottery_hf_fjd11` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='福建11选5';

DROP TABLE IF EXISTS `t_lottery_hf_gdd11`;
CREATE TABLE `t_lottery_hf_gdd11` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='广东11选5';


DROP TABLE IF EXISTS `t_lottery_hf_jxd11`;
CREATE TABLE `t_lottery_hf_jxd11` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='江西11选5';

DROP TABLE IF EXISTS `t_lottery_hf_gdkl10f`;
CREATE TABLE `t_lottery_hf_gdkl10f` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='广东快乐10分';

DROP TABLE IF EXISTS `t_lottery_hf_gxk3`;
CREATE TABLE `t_lottery_hf_gxk3` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='广西快3';

DROP TABLE IF EXISTS `t_lottery_hf_jlk3`;
CREATE TABLE `t_lottery_hf_jlk3` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='吉林快3';

DROP TABLE IF EXISTS `t_lottery_hf_jsk3`;
CREATE TABLE `t_lottery_hf_jsk3` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='江苏快3';

DROP TABLE IF EXISTS `t_lottery_hf_jslhc`;
CREATE TABLE `t_lottery_hf_jslhc` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='极速六合彩';

DROP TABLE IF EXISTS `t_lottery_hf_lfklpk`;
CREATE TABLE `t_lottery_hf_lfklpk` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='幸运扑克';

DROP TABLE IF EXISTS `t_lottery_hf_shssl`;
CREATE TABLE `t_lottery_hf_shssl` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='上海时时乐';

DROP TABLE IF EXISTS `t_lottery_hf_xyft`;
CREATE TABLE `t_lottery_hf_xyft` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='幸运飞艇'

DROP TABLE IF EXISTS `t_lottery_hf_xysm`;
CREATE TABLE `t_lottery_hf_xysm` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=ucs2 COMMENT='幸运赛马';