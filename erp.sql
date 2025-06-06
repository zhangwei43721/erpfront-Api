/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80042 (8.0.42-0ubuntu0.24.04.1)
 Source Host           : localhost:3306
 Source Schema         : erp

 Target Server Type    : MySQL
 Target Server Version : 80042 (8.0.42-0ubuntu0.24.04.1)
 File Encoding         : 65001

 Date: 06/06/2025 09:45:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_after_sales
-- ----------------------------
DROP TABLE IF EXISTS `t_after_sales`;
CREATE TABLE `t_after_sales` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '售后服务ID (主键, 自增)',
  `cust_id` int DEFAULT NULL COMMENT '客户ID (外键, 关联 t_customer.id)',
  `question` varchar(50) DEFAULT NULL COMMENT '问题描述',
  `state` varchar(50) DEFAULT NULL COMMENT '处理状态 (例如: 待处理, 处理中, 已解决)',
  `record` varchar(200) DEFAULT NULL COMMENT '处理记录/沟通纪要',
  `level` int DEFAULT NULL COMMENT '问题级别 (例如: 1-普通, 2-重要, 3-紧急)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='售后服务表';

-- ----------------------------
-- Records of t_after_sales
-- ----------------------------
BEGIN;
INSERT INTO `t_after_sales` (`id`, `cust_id`, `question`, `state`, `record`, `level`) VALUES (1, 1, '退钱！', '未处理', '1', 5);
INSERT INTO `t_after_sales` (`id`, `cust_id`, `question`, `state`, `record`, `level`) VALUES (2, 2, '商品质量问题', '处理中', '客服已联系，等待客户提供照片', 2);
INSERT INTO `t_after_sales` (`id`, `cust_id`, `question`, `state`, `record`, `level`) VALUES (3, 3, '发货太慢', '待处理', '客户投诉物流速度', 1);
INSERT INTO `t_after_sales` (`id`, `cust_id`, `question`, `state`, `record`, `level`) VALUES (4, 1, '咨询活动详情', '已解决', '已告知客户活动规则', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `brand_id` int NOT NULL AUTO_INCREMENT COMMENT '品牌ID',
  `brand_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '品牌名称',
  `brand_leter` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '品牌首字母',
  `brand_desc` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '品牌描述',
  PRIMARY KEY (`brand_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='品牌表';

-- ----------------------------
-- Records of t_brand
-- ----------------------------
BEGIN;
INSERT INTO `t_brand` (`brand_id`, `brand_name`, `brand_leter`, `brand_desc`) VALUES (1, '东东果蔬', 'D', '别买了，不能吃...');
INSERT INTO `t_brand` (`brand_id`, `brand_name`, `brand_leter`, `brand_desc`) VALUES (2, '美的', 'M', '还可以');
INSERT INTO `t_brand` (`brand_id`, `brand_name`, `brand_leter`, `brand_desc`) VALUES (3, '海尔', 'H', '我家洗衣机就是海尔啊');
INSERT INTO `t_brand` (`brand_id`, `brand_name`, `brand_leter`, `brand_desc`) VALUES (4, '华为', 'H', '中华有为');
INSERT INTO `t_brand` (`brand_id`, `brand_name`, `brand_leter`, `brand_desc`) VALUES (5, 'ikun之家', 'I', '再看一眼就要爆炸');
INSERT INTO `t_brand` (`brand_id`, `brand_name`, `brand_leter`, `brand_desc`) VALUES (6, '格力', 'G', '掌握核心科技');
INSERT INTO `t_brand` (`brand_id`, `brand_name`, `brand_leter`, `brand_desc`) VALUES (7, '小米', 'X', '为发烧而生');
COMMIT;

-- ----------------------------
-- Table structure for t_buy_list
-- ----------------------------
DROP TABLE IF EXISTS `t_buy_list`;
CREATE TABLE `t_buy_list` (
  `buy_id` int NOT NULL AUTO_INCREMENT COMMENT '采购单ID (主键, 自增)',
  `product_id` int DEFAULT NULL COMMENT '商品ID (外键, 关联 t_item.id)',
  `store_id` int DEFAULT NULL COMMENT '目标仓库ID (外键, 关联 t_store.store_id)',
  `buy_num` int DEFAULT NULL COMMENT '计划采购数量',
  `fact_buy_num` int DEFAULT NULL COMMENT '实际采购数量',
  `buy_time` datetime DEFAULT NULL COMMENT '采购时间',
  `supply_id` int DEFAULT NULL COMMENT '供应商ID (外键, 关联 t_supply.supply_id)',
  `place_id` int DEFAULT NULL COMMENT '产地ID (外键, 关联 t_place.place_id)',
  `buy_user` varchar(20) DEFAULT NULL COMMENT '采购员/申请人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `is_in` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '0 否 1 是',
  PRIMARY KEY (`buy_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='采购单';

-- ----------------------------
-- Records of t_buy_list
-- ----------------------------
BEGIN;
INSERT INTO `t_buy_list` (`buy_id`, `product_id`, `store_id`, `buy_num`, `fact_buy_num`, `buy_time`, `supply_id`, `place_id`, `buy_user`, `phone`, `is_in`) VALUES (49, 1, 1, 100, 95, '2025-05-25 14:07:53', 1, 1, '采购员张三', '13300001111', '1');
INSERT INTO `t_buy_list` (`buy_id`, `product_id`, `store_id`, `buy_num`, `fact_buy_num`, `buy_time`, `supply_id`, `place_id`, `buy_user`, `phone`, `is_in`) VALUES (50, 2, 2, 50, 50, '2025-05-27 14:07:53', 4, 2, '采购员李四', '13300002222', '1');
INSERT INTO `t_buy_list` (`buy_id`, `product_id`, `store_id`, `buy_num`, `fact_buy_num`, `buy_time`, `supply_id`, `place_id`, `buy_user`, `phone`, `is_in`) VALUES (51, 12, 1, 20, 0, '2025-05-30 14:07:53', 6, 2, '采购员王五', '13300003333', '0');
INSERT INTO `t_buy_list` (`buy_id`, `product_id`, `store_id`, `buy_num`, `fact_buy_num`, `buy_time`, `supply_id`, `place_id`, `buy_user`, `phone`, `is_in`) VALUES (52, 3, 1, 200, 150, '2025-05-29 14:07:53', 2, 3, '采购主管赵六', '13300004444', '1');
INSERT INTO `t_buy_list` (`buy_id`, `product_id`, `store_id`, `buy_num`, `fact_buy_num`, `buy_time`, `supply_id`, `place_id`, `buy_user`, `phone`, `is_in`) VALUES (53, 4, 2, 30, 0, '2025-05-31 14:07:53', 5, 4, '采购员张三', '13300001111', '0');
COMMIT;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int NOT NULL COMMENT '分类ID (主键)',
  `isbn` varchar(255) NOT NULL COMMENT '国际标准书号或分类编码',
  `cate_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `pid` int DEFAULT NULL COMMENT '父分类ID (用于层级分类, 0或NULL表示顶级)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='商品分类表';

-- ----------------------------
-- Records of t_category
-- ----------------------------
BEGIN;
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (1, 'SX_000_001', '蔬菜', '蔬菜', 0);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (2, 'SX_001_002', '黄瓜', '黄瓜', 1);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (3, 'SX_001_003', '菠菜', '菠菜', 1);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (4, 'SX_000_001', '数码', '数码', 0);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (5, 'SM_001_002', '电脑', '电脑', 4);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (6, 'SM_001_002', '手机', '手机', 4);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (7, 'IK_000_001', '坤坤', '坤坤', 0);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (8, 'IK_001_002', '背带裤', '背带裤', 7);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (9, 'JD_000_001', '家电', '家用电器', 0);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (10, 'JD_001_001', '冰箱', '冰箱类', 9);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (11, 'JD_001_002', '洗衣机', '洗衣机类', 9);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (12, 'FS_000_001', '服饰', '衣物鞋帽', 0);
INSERT INTO `t_category` (`id`, `isbn`, `cate_name`, `remark`, `pid`) VALUES (13, 'FS_001_001', '男装', '男性服装', 12);
COMMIT;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '客户ID (主键, 自增)',
  `cust_name` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `address` varchar(100) DEFAULT NULL COMMENT '客户地址',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `cust_type` varchar(50) DEFAULT NULL COMMENT '客户类型 (例如: 个人, 企业)',
  `grade` int DEFAULT NULL COMMENT '客户等级/积分',
  `his_total` double DEFAULT NULL COMMENT '历史消费总额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='客户信息表';

-- ----------------------------
-- Records of t_customer
-- ----------------------------
BEGIN;
INSERT INTO `t_customer` (`id`, `cust_name`, `address`, `phone`, `cust_type`, `grade`, `his_total`) VALUES (1, '马化腾', '腾讯', '8888888', '互联网', 3, 211);
INSERT INTO `t_customer` (`id`, `cust_name`, `address`, `phone`, `cust_type`, `grade`, `his_total`) VALUES (2, '马云', '埃里巴巴', '123456', '互联网', 1, 210);
INSERT INTO `t_customer` (`id`, `cust_name`, `address`, `phone`, `cust_type`, `grade`, `his_total`) VALUES (3, '匿名用户', '未知', '00000000000', '个人', 1, 0);
INSERT INTO `t_customer` (`id`, `cust_name`, `address`, `phone`, `cust_type`, `grade`, `his_total`) VALUES (4, '雷军', '小米科技园', '18888888888', '企业', 5, 7003);
INSERT INTO `t_customer` (`id`, `cust_name`, `address`, `phone`, `cust_type`, `grade`, `his_total`) VALUES (5, '张小龙', '广州TIT创意园', '13900000001', '个人', 4, 8800);
INSERT INTO `t_customer` (`id`, `cust_name`, `address`, `phone`, `cust_type`, `grade`, `his_total`) VALUES (6, '普通消费者A', '幸福小区101', '13512345678', '个人', 2, 560.5);
COMMIT;

-- ----------------------------
-- Table structure for t_in_store
-- ----------------------------
DROP TABLE IF EXISTS `t_in_store`;
CREATE TABLE `t_in_store` (
  `ins_id` int NOT NULL AUTO_INCREMENT COMMENT '入库记录ID (主键, 自增)',
  `store_id` int DEFAULT NULL COMMENT '仓库ID (外键, 关联 t_store.store_id)',
  `product_id` int DEFAULT NULL COMMENT '商品ID (外键, 关联 t_item.id)',
  `in_num` int DEFAULT NULL COMMENT '入库数量',
  `create_by` int DEFAULT NULL COMMENT '操作员ID/创建人ID (可能关联员工表或用户表)',
  `create_time` datetime DEFAULT NULL COMMENT '入库时间/创建时间',
  `is_in` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '0 否 1 是',
  PRIMARY KEY (`ins_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='入库记录表';

-- ----------------------------
-- Records of t_in_store
-- ----------------------------
BEGIN;
INSERT INTO `t_in_store` (`ins_id`, `store_id`, `product_id`, `in_num`, `create_by`, `create_time`, `is_in`) VALUES (1, 1, 1, 95, 1, '2025-05-25 14:07:53', '0');
INSERT INTO `t_in_store` (`ins_id`, `store_id`, `product_id`, `in_num`, `create_by`, `create_time`, `is_in`) VALUES (2, 2, 2, 50, 1, '2025-05-27 14:07:53', '0');
INSERT INTO `t_in_store` (`ins_id`, `store_id`, `product_id`, `in_num`, `create_by`, `create_time`, `is_in`) VALUES (3, 1, 3, 150, 2, '2025-05-29 14:07:53', '0');
INSERT INTO `t_in_store` (`ins_id`, `store_id`, `product_id`, `in_num`, `create_by`, `create_time`, `is_in`) VALUES (4, 1, 4, 70, 2, '2025-05-31 14:07:53', '1');
COMMIT;

-- ----------------------------
-- Table structure for t_item
-- ----------------------------
DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '商品ID，主键，自动递增',
  `item_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品编号',
  `item_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品名称',
  `type_id` int DEFAULT NULL COMMENT '商品类型ID (外键, 关联 t_categrory.id)',
  `store` int DEFAULT NULL COMMENT '库存数量',
  `brand_id` int DEFAULT NULL COMMENT '品牌ID (外键, 关联 t_brand.brand_id)',
  `store_id` int DEFAULT NULL COMMENT '门店ID (可能关联门店表, 非库存字段)',
  `supply_id` int DEFAULT NULL COMMENT '供应商ID (外键, 关联 t_supply.supply_id)',
  `place_id` int DEFAULT NULL COMMENT '产地ID (外键, 关联 t_place.place_id)',
  `unit_id` int DEFAULT NULL COMMENT '单位ID (外键, 关联 t_unit.unit_id)',
  `price` double DEFAULT NULL COMMENT '进货价格',
  `sell_price` double DEFAULT NULL COMMENT '销售价格',
  `vip_price` double DEFAULT NULL COMMENT '会员价格',
  `item_desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '商品描述',
  `item_date` date DEFAULT NULL COMMENT '生产日期 (YYYY-MM-DD)',
  `end_date` date DEFAULT NULL COMMENT '到期日期 (YYYY-MM-DD)',
  `hot_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '促销标题',
  `facturer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '制造商',
  `statue` int DEFAULT NULL COMMENT '商品状态 (例如: 0-下架, 1-上架, 2-预售)',
  `imgs` text COMMENT '商品图片路径列表 (JSON格式的字符串)',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='商品信息表';

-- ----------------------------
-- Records of t_item
-- ----------------------------
BEGIN;
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (1, NULL, '包面', NULL, 10, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL, NULL, '2025-05-15', NULL, '新鲜出炉', '新鲜出炉', NULL, NULL, NULL);
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (2, NULL, '啤酒', NULL, 20, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, '2025-05-15', NULL, '冰爽', '冰爽', NULL, NULL, NULL);
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (3, NULL, 'ikun', NULL, 0, NULL, NULL, NULL, NULL, NULL, 52, NULL, NULL, NULL, '2025-05-01', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (4, NULL, '坤坤', NULL, 1, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, '2025-05-01', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (5, NULL, 'kun', NULL, 1, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2025-05-29', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (6, NULL, '小黑子', NULL, 1, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, '2025-05-01', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (7, NULL, '', NULL, 12, NULL, NULL, NULL, NULL, NULL, 12, NULL, NULL, NULL, '2025-05-20', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (8, NULL, '11', NULL, 1, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, '2025-05-21', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (9, NULL, '11', NULL, 1111, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, '2025-05-13', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (10, NULL, '黑子', NULL, 1100, NULL, NULL, NULL, NULL, NULL, 11, NULL, NULL, NULL, '2025-05-13', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (12, '20250529095708504', '坤甲', 8, 0, 5, 1, 6, 2, 4, 111, 111, 111, '', '2025-04-29', '2025-04-29', '', '', 0, '[\"http://localhost:8081/uploads/imgs/8381e87f-f71d-447d-ab68-fa4e4079e319.jpg\"]', '');
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (13, 'SN00001', '新鲜黄瓜', 2, 81, 1, 1, 1, 1, 3, 2.5, 4, 3.8, '农场直供，口感脆甜', '2025-05-29', '2025-06-11', '限时特价', '东东农场', 0, '[\"http://example.com/imgs/cucumber.jpg\"]', 'admin');
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (14, 'SN00002', '华为Mate 60 Pro', 6, 49, 4, 2, 4, 6, 2, 6500, 6999, 6899, '麒麟芯片，遥遥领先', '2025-05-02', NULL, '旗舰新品', '华为技术有限公司', 0, '[\"http://example.com/imgs/mate60.jpg\"]', 'admin');
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (15, 'SN00003', '美的电冰箱', 10, 30, 2, 1, 5, 5, 6, 2800, 3299, 3199, '节能静音，大容量', '2025-04-02', NULL, '节能补贴', '美的集团', 0, '[\"http://example.com/imgs/fridge.jpg\"]', 'admin');
INSERT INTO `t_item` (`id`, `item_num`, `item_name`, `type_id`, `store`, `brand_id`, `store_id`, `supply_id`, `place_id`, `unit_id`, `price`, `sell_price`, `vip_price`, `item_desc`, `item_date`, `end_date`, `hot_title`, `facturer`, `statue`, `imgs`, `create_by`) VALUES (16, 'SN00004', '背带裤经典款', 8, 100, 5, 1, 6, 2, 2, 99, 199, 189, 'ikun最爱，时尚单品', '2025-05-27', NULL, '粉丝福利', 'ikun之家制造厂', 0, '[\"http://example.com/imgs/bib_pants.jpg\"]', '小黑子');
COMMIT;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID (主键)',
  `label` varchar(255) DEFAULT NULL COMMENT '导航名称',
  `component` int DEFAULT NULL COMMENT '子 ID',
  `pid` int DEFAULT NULL COMMENT '父 ID',
  `sort_order` int DEFAULT NULL COMMENT '排序',
  `icon_name` varchar(255) DEFAULT NULL COMMENT '图标名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='前端菜单表';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (1, '客户管理', NULL, 0, 0, 'User');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (2, '添加客户', 0, 1, 0, 'Plus');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (3, '查询客户', 1, 1, 1, 'Search');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (4, '售后服务', 2, 1, 2, 'Service');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (5, '客户订单', 3, 1, 3, 'Document');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (6, '销售过程', 4, 1, 4, 'TrendCharts');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (7, '数据统计', NULL, 0, 1, 'DataLine');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (8, '客户统计', 5, 7, 0, 'UserFilled');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (9, '库存统计', 6, 7, 1, 'Box');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (10, '销售过程列表', 7, 1, 5, 'List');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (11, '系统管理', NULL, 0, 3, 'Setting');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (25, '添加菜单', 8, 11, 0, 'Menu');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (26, '用户管理', 9, 11, 1, 'Avatar');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (27, '角色管理', 10, 11, 2, 'User');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (33, '商品管理', NULL, 0, 2, 'Goods');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (34, '商品分类', 14, 33, 0, 'Grid');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (35, '信息管理', 15, 33, 1, 'InfoFilled');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (36, '商品出库', 16, 33, 4, 'Download');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (37, '采购管理', 17, 33, 2, 'Shop');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (38, '入库管理', 18, 33, 3, 'Upload');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (39, '仓库列表', 19, 33, 5, 'House');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (40, '员工信息统计', 20, 7, 2, 'Histogram');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (41, '投诉统计', 21, 7, 3, 'Warning');
INSERT INTO `t_menu` (`id`, `label`, `component`, `pid`, `sort_order`, `icon_name`) VALUES (42, '销售额统计', 22, 7, 4, 'Money');
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单ID (主键, 自增)',
  `cust_id` int DEFAULT NULL COMMENT '客户ID (外键, 关联 t_customer.id)',
  `item_id` int DEFAULT NULL COMMENT '商品ID (外键, 关联 t_item.id) - 注意: 如果一个订单可含多个商品, 此处可能代表主要商品或需要订单详情表',
  `order_date` datetime DEFAULT NULL COMMENT '下单日期时间',
  `state` varchar(50) DEFAULT NULL COMMENT '订单状态 (例如: 待支付, 已支付, 已发货, 已完成, 已取消)',
  `pay` varchar(50) DEFAULT NULL COMMENT '支付方式 (例如: 支付宝, 微信, 银行卡)',
  `pay_money` double DEFAULT NULL COMMENT '支付金额',
  `num` int DEFAULT NULL COMMENT '购买数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='订单表';

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` (`id`, `cust_id`, `item_id`, `order_date`, `state`, `pay`, `pay_money`, `num`) VALUES (1, 1, 1, '2025-05-15 09:38:19', '已发货', '微信', 100, 10);
INSERT INTO `t_order` (`id`, `cust_id`, `item_id`, `order_date`, `state`, `pay`, `pay_money`, `num`) VALUES (2, 2, 2, '2025-05-14 10:12:26', '已发货', '支付宝', 200, 10);
INSERT INTO `t_order` (`id`, `cust_id`, `item_id`, `order_date`, `state`, `pay`, `pay_money`, `num`) VALUES (3, 1, 12, '2025-05-29 14:07:53', '待发货', '支付宝', 111, 1);
INSERT INTO `t_order` (`id`, `cust_id`, `item_id`, `order_date`, `state`, `pay`, `pay_money`, `num`) VALUES (4, 2, 1, '2025-05-27 14:07:53', '已完成', '微信', 10, 2);
INSERT INTO `t_order` (`id`, `cust_id`, `item_id`, `order_date`, `state`, `pay`, `pay_money`, `num`) VALUES (5, 4, 13, '2025-05-31 14:07:53', '待支付', '银行卡', 4, 1);
INSERT INTO `t_order` (`id`, `cust_id`, `item_id`, `order_date`, `state`, `pay`, `pay_money`, `num`) VALUES (6, 4, 14, '2025-06-01 12:07:53', '已支付', '微信', 6999, 1);
COMMIT;

-- ----------------------------
-- Table structure for t_out_store
-- ----------------------------
DROP TABLE IF EXISTS `t_out_store`;
CREATE TABLE `t_out_store` (
  `outs_id` int NOT NULL AUTO_INCREMENT COMMENT '出库单ID，主键，自增',
  `product_id` int DEFAULT NULL COMMENT '产品ID',
  `store_id` int DEFAULT NULL COMMENT '仓库ID',
  `tally_id` int DEFAULT NULL COMMENT '理货ID',
  `out_price` decimal(8,2) DEFAULT NULL COMMENT '出库单价',
  `out_num` int DEFAULT NULL COMMENT '出库数量',
  `create_by` int DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_out` char(1) DEFAULT NULL COMMENT '是否出库：0 否，1 是',
  PRIMARY KEY (`outs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3 COMMENT='出库单';

-- ----------------------------
-- Records of t_out_store
-- ----------------------------
BEGIN;
INSERT INTO `t_out_store` (`outs_id`, `product_id`, `store_id`, `tally_id`, `out_price`, `out_num`, `create_by`, `create_time`, `is_out`) VALUES (23, 13, 1, NULL, 4.00, 0, 101010, '2025-06-03 07:01:46', '1');
INSERT INTO `t_out_store` (`outs_id`, `product_id`, `store_id`, `tally_id`, `out_price`, `out_num`, `create_by`, `create_time`, `is_out`) VALUES (24, 13, 1, NULL, 4.00, 23, 101010, '2025-06-03 07:05:02', '1');
INSERT INTO `t_out_store` (`outs_id`, `product_id`, `store_id`, `tally_id`, `out_price`, `out_num`, `create_by`, `create_time`, `is_out`) VALUES (25, 13, 1, NULL, 4.00, 23, 101010, '2025-06-03 07:05:14', '0');
INSERT INTO `t_out_store` (`outs_id`, `product_id`, `store_id`, `tally_id`, `out_price`, `out_num`, `create_by`, `create_time`, `is_out`) VALUES (26, 13, 1, NULL, 4.00, 23, 101010, '2025-06-03 07:05:50', '0');
COMMIT;

-- ----------------------------
-- Table structure for t_place
-- ----------------------------
DROP TABLE IF EXISTS `t_place`;
CREATE TABLE `t_place` (
  `place_id` int NOT NULL AUTO_INCREMENT COMMENT '产地ID',
  `place_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '产地名称',
  `place_num` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '产地编号',
  `introduce` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '产地介绍',
  `is_delete` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '0' COMMENT '逻辑删除标记(0:可用  1:不可用)',
  PRIMARY KEY (`place_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='产地表';

-- ----------------------------
-- Records of t_place
-- ----------------------------
BEGIN;
INSERT INTO `t_place` (`place_id`, `place_name`, `place_num`, `introduce`, `is_delete`) VALUES (1, '湖南', 'hunan', '湖南挺好的啊', '0');
INSERT INTO `t_place` (`place_id`, `place_name`, `place_num`, `introduce`, `is_delete`) VALUES (2, '湖北', 'hubei', '湖北没有湖南好', '0');
INSERT INTO `t_place` (`place_id`, `place_name`, `place_num`, `introduce`, `is_delete`) VALUES (3, '陕西', 'shanxi', '还是陕西更好', '0');
INSERT INTO `t_place` (`place_id`, `place_name`, `place_num`, `introduce`, `is_delete`) VALUES (4, '浙江', 'zhejiang', '好地方', '0');
INSERT INTO `t_place` (`place_id`, `place_name`, `place_num`, `introduce`, `is_delete`) VALUES (5, '山东', 'shandong', '很好', '0');
INSERT INTO `t_place` (`place_id`, `place_name`, `place_num`, `introduce`, `is_delete`) VALUES (6, '广东', 'guangdong', '非常好', '0');
INSERT INTO `t_place` (`place_id`, `place_name`, `place_num`, `introduce`, `is_delete`) VALUES (7, '河北', 'hebei', '知道有个叫唐山的地方', '0');
COMMIT;

-- ----------------------------
-- Table structure for t_replay
-- ----------------------------
DROP TABLE IF EXISTS `t_replay`;
CREATE TABLE `t_replay` (
  `id` int NOT NULL COMMENT '反馈/评价ID (主键)',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '反馈或评价内容',
  `redate` datetime DEFAULT NULL COMMENT '反馈或评价日期时间',
  `score` int DEFAULT NULL COMMENT '评分 (如：1-5分)',
  `ques_id` int DEFAULT NULL COMMENT '问题ID，对应after_sales表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户反馈/评价表';

-- ----------------------------
-- Records of t_replay
-- ----------------------------
BEGIN;
INSERT INTO `t_replay` (`id`, `content`, `redate`, `score`, `ques_id`) VALUES (-1681727486, '好的', '2025-06-01 01:16:22', 5, 1);
INSERT INTO `t_replay` (`id`, `content`, `redate`, `score`, `ques_id`) VALUES (216634, '客服态度很好。', '2025-05-30 14:07:53', 4, 4);
INSERT INTO `t_replay` (`id`, `content`, `redate`, `score`, `ques_id`) VALUES (272169, '非常满意，问题解决很快！', '2025-05-31 14:07:53', 5, 1);
INSERT INTO `t_replay` (`id`, `content`, `redate`, `score`, `ques_id`) VALUES (406629, '处理中，期待结果。', '2025-06-01 13:07:53', 3, 2);
COMMIT;

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '关联ID (主键, 自增)',
  `rid` int DEFAULT NULL COMMENT '角色ID (外键, 关联 t_roler.id)',
  `mid` int DEFAULT NULL COMMENT '菜单ID (外键, 关联 t_menu.id)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (1, 1, 1);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (2, 1, 2);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (3, 1, 3);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (4, 1, 4);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (5, 1, 5);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (6, 1, 6);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (7, 1, 10);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (8, 1, 33);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (9, 1, 34);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (10, 1, 35);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (11, 1, 36);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (12, 2, 33);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (13, 2, 34);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (14, 2, 7);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (15, 2, 9);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (16, 6, 1);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (17, 6, 2);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (18, 6, 3);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (19, 6, 4);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (20, 6, 5);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (21, 6, 6);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (22, 6, 7);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (23, 6, 8);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (24, 6, 9);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (25, 6, 10);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (26, 6, 11);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (27, 6, 25);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (28, 6, 26);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (29, 6, 27);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (30, 6, 33);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (31, 6, 34);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (32, 6, 35);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (33, 6, 36);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (47, 7, 33);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (48, 7, 35);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (49, 7, 36);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (50, 7, 7);
INSERT INTO `t_role_menu` (`id`, `rid`, `mid`) VALUES (51, 7, 9);
COMMIT;

-- ----------------------------
-- Table structure for t_roler
-- ----------------------------
DROP TABLE IF EXISTS `t_roler`;
CREATE TABLE `t_roler` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '角色ID (主键, 自增)',
  `rname` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `rdesc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of t_roler
-- ----------------------------
BEGIN;
INSERT INTO `t_roler` (`id`, `rname`, `rdesc`) VALUES (1, '销售经理', '负责销售');
INSERT INTO `t_roler` (`id`, `rname`, `rdesc`) VALUES (2, '产品经理', '产品规划');
INSERT INTO `t_roler` (`id`, `rname`, `rdesc`) VALUES (3, '技术经理', '技术更新');
INSERT INTO `t_roler` (`id`, `rname`, `rdesc`) VALUES (5, '人力经理', '人力管理');
INSERT INTO `t_roler` (`id`, `rname`, `rdesc`) VALUES (6, '系统管理员', '负责系统的全面管理和维护');
INSERT INTO `t_roler` (`id`, `rname`, `rdesc`) VALUES (7, '库管员', '负责仓库库存管理');
COMMIT;

-- ----------------------------
-- Table structure for t_sell_jh
-- ----------------------------
DROP TABLE IF EXISTS `t_sell_jh`;
CREATE TABLE `t_sell_jh` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '销售机会/计划ID (主键, 自增)',
  `custid` int DEFAULT NULL COMMENT '客户ID (外键, 关联 t_customer.id)',
  `channel_id` int DEFAULT NULL COMMENT '渠道ID (可能关联渠道表)',
  `money` double DEFAULT NULL COMMENT '预计金额/成交金额',
  `now_step` varchar(50) DEFAULT NULL COMMENT '当前阶段/步骤',
  `emp_id` int DEFAULT NULL COMMENT '负责人ID/员工ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='销售机会/计划表';

-- ----------------------------
-- Records of t_sell_jh
-- ----------------------------
BEGIN;
INSERT INTO `t_sell_jh` (`id`, `custid`, `channel_id`, `money`, `now_step`, `emp_id`) VALUES (1, 1, 1, 111, '1', 1);
INSERT INTO `t_sell_jh` (`id`, `custid`, `channel_id`, `money`, `now_step`, `emp_id`) VALUES (2, 2, 2, 5000, '初步接洽', 2);
INSERT INTO `t_sell_jh` (`id`, `custid`, `channel_id`, `money`, `now_step`, `emp_id`) VALUES (3, 4, 1, 200000, '方案展示', 1);
INSERT INTO `t_sell_jh` (`id`, `custid`, `channel_id`, `money`, `now_step`, `emp_id`) VALUES (4, 3, 3, 1200.5, '意向确认', 3);
COMMIT;

-- ----------------------------
-- Table structure for t_store
-- ----------------------------
DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store` (
  `store_id` int NOT NULL AUTO_INCREMENT COMMENT '仓库ID',
  `store_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '仓库名称',
  `store_num` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '仓库编号',
  `store_address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '仓库地址',
  `concat` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`store_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='仓库表';

-- ----------------------------
-- Records of t_store
-- ----------------------------
BEGIN;
INSERT INTO `t_store` (`store_id`, `store_name`, `store_num`, `store_address`, `concat`, `phone`) VALUES (1, '西安仓库', 'xa1', '西安市雁塔区', '张三', '13829086625');
INSERT INTO `t_store` (`store_id`, `store_name`, `store_num`, `store_address`, `concat`, `phone`) VALUES (2, '北京仓库', 'bj2', '北京市朝阳区 ', '王麻子', '15229267291');
INSERT INTO `t_store` (`store_id`, `store_name`, `store_num`, `store_address`, `concat`, `phone`) VALUES (3, '上海仓库', 'sh3', '上海市浦东区', '李四', '18092647320');
COMMIT;

-- ----------------------------
-- Table structure for t_supply
-- ----------------------------
DROP TABLE IF EXISTS `t_supply`;
CREATE TABLE `t_supply` (
  `supply_id` int NOT NULL AUTO_INCREMENT COMMENT '供应商ID',
  `supply_num` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '供应商编号',
  `supply_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '供应商名称',
  `supply_introduce` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '供应商介绍',
  `concat` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '联系电话',
  `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '供应商地址',
  `is_delete` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '0' COMMENT '逻辑删除标记(0:可用  1:不可用)',
  PRIMARY KEY (`supply_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='供货商表';

-- ----------------------------
-- Records of t_supply
-- ----------------------------
BEGIN;
INSERT INTO `t_supply` (`supply_id`, `supply_num`, `supply_name`, `supply_introduce`, `concat`, `phone`, `address`, `is_delete`) VALUES (1, 'zjsh', '浙江三禾竹木有限公司', '贷款是否会为加快和规范健康环境如何根据', '任伟', '15287653921', '浙江省丽水市', '0');
INSERT INTO `t_supply` (`supply_id`, `supply_num`, `supply_name`, `supply_introduce`, `concat`, `phone`, `address`, `is_delete`) VALUES (2, 'lqlo', '龙泉绿欧食品有限公司', NULL, '张三', '18134532830', '浙江省龙泉市', '0');
INSERT INTO `t_supply` (`supply_id`, `supply_num`, `supply_name`, `supply_introduce`, `concat`, `phone`, `address`, `is_delete`) VALUES (3, 'dhgy', '帝豪供应链公司', NULL, '李四', '17493976543', '陕西省西安市', '0');
INSERT INTO `t_supply` (`supply_id`, `supply_num`, `supply_name`, `supply_introduce`, `concat`, `phone`, `address`, `is_delete`) VALUES (4, 'haier', '海尔集团', '海尔智家为用户提供衣、食、住、娱的智慧全场景解决方案，全面提升用户生活品质，以“云”体验、全链路服务、个性化智慧终端，实现交互、体验、销售、服务于一体的全流程生态平台。', '周云杰', '4006999511', '山东省青岛市', '0');
INSERT INTO `t_supply` (`supply_id`, `supply_num`, `supply_name`, `supply_introduce`, `concat`, `phone`, `address`, `is_delete`) VALUES (5, 'midea', '美的集团股份有限公司', '科技尽善，生活尽美”– 美的集团秉承用科技创造美好生活的经营理念，如今已成为一家集智能家居事业群、机电事业群、暖通与楼宇事业部、机器人及自动化事业部、数字化创新业务五大板块为一体的全球化科技集团，产品及服务惠及全球200多个国家和地区约4亿用户。形成美的、小天鹅、东芝、华凌、布谷、COLMO、Clivet、Eureka、库卡、GMCC、威灵在内的多品牌组合。', '方洪波', '075726338788', '广东省佛山市', '0');
INSERT INTO `t_supply` (`supply_id`, `supply_num`, `supply_name`, `supply_introduce`, `concat`, `phone`, `address`, `is_delete`) VALUES (6, 'ikun', 'ikun之家', '再看一眼就会爆炸', '坤坤', '114514520', '鸡棚', '0');
COMMIT;

-- ----------------------------
-- Table structure for t_tree_test
-- ----------------------------
DROP TABLE IF EXISTS `t_tree_test`;
CREATE TABLE `t_tree_test` (
  `id` int NOT NULL COMMENT '节点ID (主键)',
  `tname` varchar(50) DEFAULT NULL COMMENT '节点名称',
  `pid` int DEFAULT NULL COMMENT '父节点ID (用于构建树形结构)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='树形结构测试表';

-- ----------------------------
-- Records of t_tree_test
-- ----------------------------
BEGIN;
INSERT INTO `t_tree_test` (`id`, `tname`, `pid`) VALUES (1, '档案管理', 0);
INSERT INTO `t_tree_test` (`id`, `tname`, `pid`) VALUES (2, '档案录入', 1);
INSERT INTO `t_tree_test` (`id`, `tname`, `pid`) VALUES (3, '档案查询', 1);
INSERT INTO `t_tree_test` (`id`, `tname`, `pid`) VALUES (4, '班级管理', 0);
INSERT INTO `t_tree_test` (`id`, `tname`, `pid`) VALUES (5, '班级录入', 4);
INSERT INTO `t_tree_test` (`id`, `tname`, `pid`) VALUES (6, '班级调整', 4);
INSERT INTO `t_tree_test` (`id`, `tname`, `pid`) VALUES (7, '档案调动', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_unit
-- ----------------------------
DROP TABLE IF EXISTS `t_unit`;
CREATE TABLE `t_unit` (
  `unit_id` int NOT NULL AUTO_INCREMENT COMMENT '单位ID',
  `unit_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '单位名称',
  `unit_desc` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '单位描述',
  PRIMARY KEY (`unit_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='规格单位表';

-- ----------------------------
-- Records of t_unit
-- ----------------------------
BEGIN;
INSERT INTO `t_unit` (`unit_id`, `unit_name`, `unit_desc`) VALUES (1, '箱/件', '箱/件');
INSERT INTO `t_unit` (`unit_id`, `unit_name`, `unit_desc`) VALUES (2, '个', '个');
INSERT INTO `t_unit` (`unit_id`, `unit_name`, `unit_desc`) VALUES (3, '公斤', '公斤');
INSERT INTO `t_unit` (`unit_id`, `unit_name`, `unit_desc`) VALUES (4, '只', '只');
INSERT INTO `t_unit` (`unit_id`, `unit_name`, `unit_desc`) VALUES (5, '克', '克');
INSERT INTO `t_unit` (`unit_id`, `unit_name`, `unit_desc`) VALUES (6, '台', '台');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID (主键, 自增)',
  `uname` varchar(255) DEFAULT NULL COMMENT '用户名/登录名',
  `upwd` varchar(255) DEFAULT NULL COMMENT '用户密码 (建议加密存储)',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `edu` varchar(20) DEFAULT NULL COMMENT '学历',
  `age` int DEFAULT NULL COMMENT '年龄',
  `title` varchar(255) DEFAULT NULL COMMENT '职称/头衔',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` (`id`, `uname`, `upwd`, `phone`, `edu`, `age`, `title`) VALUES (1, 'admin', 'admin123', '13800138000', '本科', 30, '系统管理员');
INSERT INTO `t_user` (`id`, `uname`, `upwd`, `phone`, `edu`, `age`, `title`) VALUES (2, 'sales01', 'sales123', '13900139000', '大专', 25, '销售代表');
INSERT INTO `t_user` (`id`, `uname`, `upwd`, `phone`, `edu`, `age`, `title`) VALUES (3, 'stock_manager', 'stock123', '13700137000', '高中', 35, '仓库主管');
INSERT INTO `t_user` (`id`, `uname`, `upwd`, `phone`, `edu`, `age`, `title`) VALUES (4, 'testuser', 'test123', '13600136000', '硕士', 28, '测试工程师');
COMMIT;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '关联ID (主键, 自增)',
  `uid` int DEFAULT NULL COMMENT '用户ID (外键, 关联 t_user.id)',
  `rid` int DEFAULT NULL COMMENT '角色ID (外键, 关联 t_roler.id)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` (`id`, `uid`, `rid`) VALUES (1, 1, 6);
INSERT INTO `t_user_role` (`id`, `uid`, `rid`) VALUES (2, 2, 1);
INSERT INTO `t_user_role` (`id`, `uid`, `rid`) VALUES (3, 3, 7);
INSERT INTO `t_user_role` (`id`, `uid`, `rid`) VALUES (4, 3, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
