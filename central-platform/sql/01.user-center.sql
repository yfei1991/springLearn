# 导出 user-center 的数据库结构
CREATE DATABASE IF NOT EXISTS `user-center` DEFAULT CHARACTER SET = utf8mb4;
Use `user-center`;
#
# Structure for table "sys_menu"
#
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) NOT NULL,
  `name` varchar(64) NOT NULL,
  `url` varchar(1024) DEFAULT NULL,
  `path` varchar(1024) DEFAULT NULL,
  `css` varchar(32) DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  `isMenu` int(11) DEFAULT NULL COMMENT '是否菜单 1 是 2 不是',
  `hidden` int(11) DEFAULT NULL COMMENT '是否隐藏,0 false 1 true',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;

#
# Data for table "sys_menu"
#

INSERT INTO `sys_menu` VALUES (2,12,'用户管理','#!user','system/user.html','layui-icon-friends',2,'2017-11-17 16:56:59','2018-09-14 09:06:25',1,0),(3,12,'角色管理','#!role','system/role.html','layui-icon-friends',3,'2017-11-17 16:56:59','2018-09-02 06:12:04',1,0),(4,12,'菜单管理','#!menus','system/menus.html','layui-icon-menu-fill',4,'2017-11-17 16:56:59','2018-09-03 02:23:47',1,0),(5,12,'权限管理','#!permissions','system/permissions.html','layui-icon-password',5,'2017-11-17 16:56:59','2018-09-02 06:12:16',1,0),(7,37,'注册中心','#!register','http://47.99.88.28:1111','layui-icon-engine',7,'2017-11-17 16:56:59','2018-08-30 06:21:51',1,0),(8,37,'监控中心','#!monitor','http://59.110.164.254:9999/#/wallboard','layui-icon-util',8,'2017-11-17 16:56:59','2018-08-25 10:43:24',1,0),(9,37,'文件中心','#!files','files/files.html','layui-icon-file',10,'2017-11-17 16:56:59','2018-08-25 10:43:33',1,0),(10,37,'文档中心','#!swagger','http://47.99.88.28:9200/swagger-ui.html','layui-icon-app',9,'2017-11-17 16:56:59','2018-08-30 06:22:02',1,0),(11,12,'我的信息','#!myInfo','system/myInfo.html','',10,'2017-11-17 16:56:59','2018-09-02 06:12:24',1,1),(12,-1,'认证中心','javascript:;','','layui-icon-set',1,'2017-11-17 16:56:59','2018-09-02 02:44:30',1,0),(35,12,'应用管理','#!app','attestation/app.html','layui-icon-app',9,'2017-11-17 16:56:59','2018-08-25 10:57:42',1,0),(36,12,'服务管理','#!services','attestation/services.html','layui-icon-website',8,'2017-11-17 16:56:59','2018-09-02 09:34:13',1,0),(37,-1,'系统监控','javascript:;','','layui-icon-set',3,'2018-08-25 10:41:58','2018-08-25 10:41:58',1,0),(38,37,'Zipkin监控','#!zipkin','http://59.110.164.254:11008/zipkin/','layui-icon-util',10,'2018-08-26 17:10:38','2018-09-03 09:54:11',1,0),(40,-1,'任务中心','javascript:;','','layui-icon-set',4,'2018-08-28 16:59:44','2018-08-28 17:00:19',1,0),(41,40,'任务管理','#!jobinfo','http://59.110.164.254:8088/jobinfo','layui-icon-senior',1,'2018-08-28 17:02:00','2018-08-28 18:24:23',1,0),(42,40,'调度日志','#!joblog','http://59.110.164.254:8088/joblog','layui-icon-senior',2,'2018-08-28 18:20:53','2018-08-28 18:24:32',1,0),(43,40,'执行器管理','#!jobgroup','http://59.110.164.254:8088/jobgroup','layui-icon-senior',3,'2018-08-28 18:22:04','2018-09-03 08:05:02',1,0),(44,37,'服务治理','#!eureka','eureka/list.html','layui-icon-engine',6,'2018-08-30 15:30:19','2018-08-30 15:30:36',1,0),(48,47,'ccc','ccc','ccc','ccc',1,'2018-09-05 02:17:22','2018-09-05 02:17:22',1,0),(49,48,'ddd','ddd','ddd','',55,'2018-09-05 03:27:18','2018-09-05 03:27:18',1,0),(50,12,'代码生成器','#!generator','generator/list.html','layui-icon-app',9,'2018-09-05 13:43:06','2018-09-05 13:43:40',1,0),(52,12,'token管理','#!token','attestation/token.html','layui-icon-util',11,'2018-09-08 13:19:56','2018-09-08 13:19:56',1,0),(53,-1,'百度','www.baidu.com','','',1,'2018-09-12 02:49:46','2018-09-12 02:49:46',1,0);

#
# Structure for table "sys_permission"
#

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission` (`permission`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;

#
# Data for table "sys_permission"
#

INSERT INTO `sys_permission` VALUES (1,'permission:post/permissions','保存权限标识','2018-01-18 17:06:39','2018-01-18 17:06:42'),(2,'permission:put/permissions','修改权限标识','2018-01-18 17:06:39','2018-01-18 17:06:42'),(3,'permission:delete/permissions/{id}','删除权限标识','2018-01-18 17:06:39','2018-01-18 17:06:42'),(4,'permission:get/permissions','查询权限标识','2018-01-18 17:06:39','2018-01-18 17:06:42'),(5,'role:post/roles','添加角色','2018-01-18 17:06:39','2018-01-18 17:06:42'),(6,'role:put/roles','修改角色','2018-01-18 17:06:39','2018-01-18 17:06:42'),(7,'role:delete/roles/{id}','删除角色','2018-01-18 17:06:39','2018-01-18 17:06:42'),(8,'role:post/roles/{id}/permissions','给角色分配权限','2018-01-18 17:06:39','2018-01-18 17:06:42'),(9,'role:get/roles','查询角色','2018-01-18 17:06:39','2018-01-18 17:06:42'),(10,'role:get/roles/{id}/permissions','获取角色的权限','2018-01-18 17:06:39','2018-01-18 17:06:42'),(11,'user:post/users/{id}/roles','给用户分配角色','2018-01-18 17:06:39','2018-01-18 17:06:42'),(12,'user:post/users/{id}/resetPassword','用户重置密码','2018-01-18 17:06:39','2018-01-18 17:06:42'),(13,'user:get/users','用户查询','2018-01-18 17:12:00','2018-01-18 17:12:05'),(14,'user:put/users/me','修改用户','2018-01-18 17:06:39','2018-01-18 17:06:42'),(15,'user:get/users/{id}/roles','获取用户的角色','2018-01-18 17:06:39','2018-01-18 17:06:42'),(16,'user:post/users/saveOrUpdate','新增用户','2018-01-18 17:06:39','2018-01-18 17:06:42'),(17,'user:post/users/exportUser','导出用户','2018-01-18 17:06:39','2018-01-18 17:06:42'),(18,'user:get/users/updateEnabled','用户状态修改','2018-01-18 17:06:39','2018-01-18 17:06:42'),(19,'user:put/users/password','修改密码','2018-01-18 17:06:39','2018-01-18 17:06:39'),(20,'menu:get/menus/all','查询菜单','2018-01-18 17:06:39','2018-01-18 17:06:42'),(21,'menu:post/menus/granted','给角色分配菜单','2018-01-18 17:06:39','2018-01-18 17:06:42'),(22,'menu:get/menus/tree','树形显示','2018-01-18 17:06:39','2018-01-18 17:06:39'),(23,'menu:get/menus/{roleId}/menus','获取角色的菜单','2018-01-18 17:06:39','2018-01-18 17:06:42'),(24,'menu:post/menus','添加菜单','2018-01-18 17:06:39','2018-09-04 07:35:29'),(25,'menu:put/menus','修改菜单','2018-01-18 17:06:39','2018-01-18 17:06:42'),(26,'menu:delete/menus/{id}','删除菜单','2018-01-18 17:06:39','2018-01-18 17:06:42'),(27,'menu:get/menus/current','当前用户菜单','2018-01-18 17:06:39','2018-01-18 17:06:42'),(29,'menu:get/menus/findAlls','所有菜单','2018-01-18 17:06:39','2018-01-18 17:06:39'),(30,'client:post/clients','保存应用','2018-01-18 17:06:39','2018-01-18 17:06:39'),(31,'client:get/clients','应用列表','2018-01-18 17:06:39','2018-01-18 17:06:39'),(32,'client:get/clients/{id}','根据id获取应用','2018-01-18 17:06:39','2018-01-18 17:06:39'),(33,'clientdelete/clients','删除应用','2018-01-18 17:06:39','2018-01-18 17:06:42'),(34,'service:get/service/findAlls','查询所有服务','2018-01-18 17:06:39','2018-09-03 08:05:09'),(35,'service:get/service/findOnes','服务树','2018-01-18 17:06:39','2018-09-08 03:23:28');

#
# Structure for table "sys_role"
#

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL COMMENT '角色code',
  `name` varchar(50) NOT NULL COMMENT '角色名',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

#
# Data for table "sys_role"
#

INSERT INTO `sys_role` VALUES (1,'ADMIN','管理员','2017-11-17 16:56:59','2017-11-17 16:56:59');

#
# Structure for table "sys_role_menu"
#

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `roleId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "sys_role_menu"
#

INSERT INTO `sys_role_menu` VALUES (1,2),(1,3),(1,4),(1,5),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,35),(1,36),(1,37),(1,38),(1,40),(1,41),(1,42),(1,43),(1,44),(1,50),(1,52);

#
# Structure for table "sys_role_permission"
#

DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `roleId` int(11) NOT NULL,
  `permissionId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "sys_role_permission"
#

INSERT INTO `sys_role_permission` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35);

#
# Structure for table "sys_role_user"
#

DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "sys_role_user"
#

INSERT INTO `sys_role_user` VALUES (1,1),(2,1),(4,1),(7,1),(8,1),(9,1),(10,1),(11,1),(13,1),(14,1),(15,1);

#
# Structure for table "sys_user"
#

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `headImgUrl` varchar(1024) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `type` varchar(16) NOT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

#
# Data for table "sys_user"
#

INSERT INTO `sys_user` VALUES (1,'admin','$2a$10$Wtw81uu43fGKw9lkOr1RAOTNWxQIZBsB3YDwc/5yDnr/yeG5x92EG','管理员','http://payo7kq4i.bkt.clouddn.com/耳机.jpg','13106975707',1,1,'BACKEND','2017-11-17 16:56:59','2018-09-15 03:12:44'),(2,'owen','$2a$10$4WkpmB1jHncBCrzJ7hJRq.SsiEFiyE/FdgPF26hLs8vzPyoNpZjta','欧文','http://payo7kq4i.bkt.clouddn.com/QQ%E5%9B%BE%E7%89%8720180819191900.jpg','18579068166',1,0,'APP','2017-11-17 16:56:59','2018-09-12 06:00:31'),(3,'user','$2a$10$fL/AfD4RDS0LxLJS7zpaZ.YUMfjNWKVvUn7oiA75L1K6PXazSTJPi','体验用户','http://payo7kq4i.bkt.clouddn.com/QQ%E5%9B%BE%E7%89%8720180819191900.jpg',NULL,1,0,'APP','2017-11-17 16:56:59','2018-09-07 13:38:34'),(4,'test','$2a$10$RD18sHNphJMmcuLuUX/Np.IV/7Ngbjd3Jtj3maFLpwaA6KaHVqPtq','测试账户','http://payo7kq4i.bkt.clouddn.com/QQ%E5%9B%BE%E7%89%8720180819191900.jpg','13851539156',0,0,'APP','2017-11-17 16:56:59','2018-09-07 03:27:40'),(7,'useruser','$2a$10$IcsVUMlsZtOljOSrCKhx5.JA5vj/x8XiN6XJDwj4al5NKFU/KwdeO','useruser',NULL,'18571111111',1,0,'APP','2018-09-03 09:57:12','2018-09-05 12:57:14'),(8,'abc','$2a$10$RII9blAhenwoFLjL1Y7kNOgq8xqUR/.o6SCDmfPbb6IAnZng/HsKa','abc',NULL,'13322332123',0,0,'APP','2018-09-03 03:32:52','2018-09-11 13:55:24'),(9,'jay','$2a$10$og3NMep2E4sJF90IzoyVre53A37APaNvbXXTJDhcjQkDuTHIe.wvO','jay',NULL,'15151515151',0,0,'APP','2018-09-06 02:30:51','2018-09-13 07:21:33'),(10,'testpre','$2a$10$m7vrMB.xq/k3Xq4EJ/p84eV33DOKtGDZ1pL8/jsegDH3FoUz1BUXa','testpre',NULL,'17791907897',0,1,'APP','2018-09-07 02:48:44','2018-09-16 08:29:17'),(11,'1','$2a$10$lQ5w8eRYFx4JYfS/zV6OM.IzIRf0rbyevUHFu.xQJtL7Bobc8AuY.','1',NULL,'13530151800',1,1,'APP','2018-09-07 14:20:51','2018-09-14 06:49:59'),(12,'12','$2a$10$cgRGZ0uuIAoKuwBoTWmz7eJzP4RUEr688VlnpZ4BTCz2RZEt0jrIe','12',NULL,'17587132062',0,1,'APP','2018-09-08 04:52:25','2018-09-16 01:48:00'),(13,'abc1','$2a$10$pzvn4TfBh2oFZJbtagovFe56ZTUlTaawPnx0Yz2PeqGex0xbddAGu','abc',NULL,'12345678901',0,1,'APP','2018-09-11 08:02:25','2018-09-14 06:49:54'),(14,'ceshis','$2a$10$wh0d8dn67WXCH6oNeDW3Q.NnJHiVUjEvLBOVUqjA2F/pn7cIpfjLG','ceshis',NULL,'12345643456',0,1,'APP','2018-09-12 13:50:57','2018-09-14 06:49:53'),(15,'w2121','$2a$10$C2TNbguxyfqlDUgB6/44XesmYeX5JMmWU5x4DsWrGU3bdgl6E3ei.','122',NULL,'15854556993',0,1,'APP','2018-09-13 09:35:15','2018-09-17 00:38:25');
