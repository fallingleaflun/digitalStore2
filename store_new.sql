/* 
MySQL - Database - store
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`store` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `store`;


/*Table structure for table `user` */
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` TINYINT DEFAULT '0',
  `username` varchar(20) NOT NULL UNIQUE,
  `password` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL UNIQUE,
  `email` varchar(50) DEFAULT NULL,
  `introduce` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT '1',
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

/*Data for the table `user` */
insert  into `user`(`id`, `role`,`username`,`password`,`tel`,`email`,`introduce`,`state`,`registerTime`) values
(1,1,'admin','123456','13422670733','992606014@qq.com','我是超级管理员，我可以登录后台管理系统',1,'2019-12-2 09:45:40'),
(2,0,'soris','123456','13656521214','2509473985@qq.com','我是2号测试用户',1,'2019-12-2 09:45:46'),
(3,0,'zltan','123456','13656521241','2509473954@qq.com','我是3号测试用户',1,'2019-12-1 09:45:46'),
(4,0,'lun','123456','13556954215','3509473954@qq.com','我是4号测试用户',1,'2019-12-1 08:45:46'),
(5,2,'sales_test','123456','13422670722','3509473954@qq.com','我是销售测试',1,'2019-12-1 08:45:46');














/*Table structure for table `products` */
DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `sold` INT DEFAULT '0',
  `remain` INT NOT NULL,
  `category` varchar(40) DEFAULT NULL,
  `imgurl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8;

/*Data for the table `products` */
insert  into `products`(`id`,`name`,`price`,`description`,`sold`,`remain`,`category`,`imgurl`) values
(1,'闪迪SD卡', 69, '大厂制造，质量好，速度快',10,20,'数码配件','/productImg/ejisd45416.jpg'),
(2,'罗马仕充电宝', 99, '20000毫安大容量充电宝 苹果/安卓/Type-C/小米/华为通用',3,200,'数码配件','/productImg/56dsfdsd.jpg'),
(3,'罗技鼠标G903', 799, '性能全速升级，RGB无线游戏鼠标',3,160,'数码配件','/productImg/dfwsdafsd.jpg'),
(4,'cherry G80机械键盘', 900, 'G80-3494LYCUS-2 机械键盘 有线键盘 游戏键盘 全尺寸键盘 经典复古 全键无冲 黑色 红轴',40,660,'数码配件','/productImg/dsfssaas.jpg'),
(5,'绿联一分二数据线', 60, '同时听歌充电，支持线控，通话，适用于小米系列/华为P20/Mate 10 pro',88,6150,'数码配件','/productImg/llsjx.jpg'),
(6,'天猫精灵智能音箱', 99, '天猫精灵 方糖，智能音箱，DTS音频技术加持，音质更出色',990,10421,'影音娱乐','/productImg/tmjl.jpg'),
(7,'喜马拉雅好声音智能音箱', 1299, '哈曼JBL助力，好音质让好内容更动听。喜马拉雅1亿+免费节目随心听，40+分类全方位满足你',1201,20214,'影音娱乐','/productImg/xmlyhsy.jpg');













/*Table structure for table `orders` */
DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `buyerName` varchar(20) DEFAULT NULL,
  `buyerTel` varchar(20) DEFAULT NULL,
  `buyerAddress` varchar(255) DEFAULT NULL,
  `purchased` int(11) DEFAULT '0',
  `ordertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

/*Data for the table `orders`暂且不插入数据 */
/*insert  into `orders`(`id`,`money`,`buyerAddress`,`buyerName`,`buyerTel`,`purchased`,`ordertime`,`user_id`) values ('0c0796f2-0124-4a13-a891-5efbb63b04f9',44.5,'北京市昌平区金燕龙办公楼','hanyongmeng','15207545526',1,'2016-05-18 10:36:36',4),('305a7870-3820-4079-b6f9-5d2b63cbcd2a',59,'北京市昌平区建材城西路金燕龙办公楼','huangyun','13041019968',0,'2016-01-13 15:14:54',3),('611f80fa-4273-4674-be09-9530b6276e15',89,'北京市海淀区清河永泰园5号楼501','huangyun','13041019968',1,'2016-01-10 18:00:36',3),('677a7314-0e16-4e18-8aec-552f848e0d75',65,'北京市昌平区','hanyongmeng','15207545526',0,'2016-05-18 11:33:25',4),('6f591522-7a2a-4a31-899d-ef1181c72f5f',25,'北京市昌平区金燕龙办公楼一层传智播客','madan','13269219270',0,'2016-01-10 18:00:36',2),('7ae96e6d-4600-41a5-bc5d-143b34ba61db',35,'北京市昌平区建材城西路','madan','13269219270',0,'2016-02-25 10:44:56',2),('a5bfb13d-9085-4374-94d9-4864b4d618ab',25,'海淀区圆明园西路','hanyongmeng','13455260812',1,'2016-02-25 10:43:40',4),('c4b2bfff-1694-4e28-bcf8-fa7169bfc978',129,'北京市昌平区北七家镇','hanyongmeng','15207545526',1,'2016-05-18 10:36:22',4),('d88d75cd-15e3-4622-801d-4cad902aeaa1',25,'北京市昌平区建材城西路金燕龙办公楼','hanyongmeng','13848399998',1,'2016-02-25 10:44:23',4);*/
















/*Table structure for table `orderitem` */
DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `buynum` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` 暂且不插入数据 */

/*insert  into `orderitem`(`order_id`,`product_id`,`buynum`) values ('0c0796f2-0124-4a13-a891-5efbb63b04f9','79bbe618-d2f8-4081-b35a-62ebbe938b64',1),('305a7870-3820-4079-b6f9-5d2b63cbcd2a','72c52302-cd1e-4a22-8ac8-dc300a915be5',1),('611f80fa-4273-4674-be09-9530b6276e15','84c842da-16b6-4e87-953e-859a1ca62bab',1),('677a7314-0e16-4e18-8aec-552f848e0d75','3a0196b2-71c1-4d4d-a4e8-d1f875096f00',1),('677a7314-0e16-4e18-8aec-552f848e0d75','bf66a00c-4a78-458b-93c8-08896ee14976',1),('6f591522-7a2a-4a31-899d-ef1181c72f5f','9a7af97e-deea-417e-ad66-23ea755d2a51',1),('7ae96e6d-4600-41a5-bc5d-143b34ba61db','bdb32537-8f2c-4ba2-a752-94fdc0e9a250',1),('a5bfb13d-9085-4374-94d9-4864b4d618ab','9a7af97e-deea-417e-ad66-23ea755d2a51',1),('c4b2bfff-1694-4e28-bcf8-fa7169bfc978','3a0196b2-71c1-4d4d-a4e8-d1f875096f00',2),('c4b2bfff-1694-4e28-bcf8-fa7169bfc978','79bbe618-d2f8-4081-b35a-62ebbe938b64',2),('d88d75cd-15e3-4622-801d-4cad902aeaa1','3cdd01d2-95d4-4077-b512-ff4c3b340d6b',1);*/


DROP TABLE IF EXISTS `tomaru`;

CREATE TABLE `tomaru` (
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `state_time` int(11) NOT NULL,
  `state_jikai` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*Table structure for table `iprecord` */
DROP TABLE IF EXISTS `iprecord`;

CREATE TABLE `iprecord` (
  `iprecord_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role` TINYINT NOT NULL,
  `ip` VARCHAR(16) NOT NULL,
  `opTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `opType` TINYINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*Table structure for table `iprecord`
DROP TABLE IF EXISTS `sales_product`;

CREATE TABLE `sales_product` (
  `user_id` int(11) NOT NULL,
  `procuct_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `procuct_id`),
  FOREIGN KEY (`procuct_id`) REFERENCES `products`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/

/*用户画像的存储过程*/
DROP PROCEDURE IF EXISTS `getUserPortrait`;

DELIMITER //  -- 结束符修改
create procedure `getUserPortrait`(in uid int,out uname varchar(20),out pid int,out ptype varchar(40),out ptime int)
BEGIN
	-- 定义三个计数器
	DECLARE morning_int int default 0;
	DECLARE afternoon_int int default 0;
	DECLARE night_int int default 0;
	-- 求最大值用
	DECLARE max_int int default 0;
	DECLARE cur_time TIMESTAMP;
	DECLARE done INT DEFAULT 0; -- 自定义控制游标循环变量,默认0
	-- 定义游标
	DECLARE cur CURSOR FOR SELECT opTime FROM iprecord where user_id=uid and opType=0;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
	
	-- 得到用户名
	select user.username into uname from user where user.id=uid;

	-- 得到浏览最久的商品id
	select product_id into pid from tomaru where user_id=uid ORDER BY state_time LIMIT 1;

	-- 得到停留最长的类别
	select category into ptype from (select category, sum(state_time) as sum_time from (select * from  tomaru, (select id, category from products) as tmp1 where tomaru.product_id=tmp1.id and user_id=uid) as tmp2 GROUP BY category) as tmp3 ORDER BY sum_time DESC LIMIT 1;
	
-- 打开游标
	OPEN cur;
	-- 执行循环
	read_loop : LOOP
			-- 取游标中的值
			FETCH cur INTO cur_time;
			-- 判断是否结束循环，一定要放到FETCH之后，因为在fetch不到的时候才会设置done为true
			-- 如果放到fetch之前，先判断done，这个时候done的值还是之前的循环的值，因此就会导致循环一次
			IF done THEN
					LEAVE read_loop;
			END IF;
			--  执行SQL操作
			IF cast(cur_time as time) BETWEEN '06:00:00' AND '12:00:00' THEN
				set morning_int=morning_int+1;
			ELSEIF cast(cur_time as time) BETWEEN '12:00:01' AND '18:00:00' THEN
				set afternoon_int=afternoon_int+1;
			ELSE
				set night_int=night_int+1;
			END IF;
	END LOOP read_loop;
	-- 释放游标
	CLOSE cur;
	IF morning_int>max_int THEN
		set max_int=morning_int;
		set ptime=1;
	END IF;
	IF afternoon_int>max_int THEN
		set max_int=afternoon_int;
		set ptime=2;
	END IF;
	IF night_int>max_int THEN
		set max_int=night_int;
		set ptime=3;
	END IF;
END;
//  
DELIMITER ;  -- 改回默认结束符

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
