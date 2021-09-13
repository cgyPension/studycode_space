-- MySQL主要用于存储数据质量监控的结果值，这里需要提前建库建表MySQL主要用于存储数据质量监控的结果值，这里需要提前建库建表

drop database if exists data_supervisor;
create database data_supervisor;

-- 创建空值指标表，null_id 自己要再多加列 库名
CREATE TABLE data_supervisor.`null_id`
(
    `dt`                 date        NOT NULL COMMENT '日期',
    `tbl`                varchar(50) NOT NULL COMMENT '表名',
    `col`                varchar(50) NOT NULL COMMENT '列名',
    `value`              int         DEFAULT NULL COMMENT '空ID个数',
    `value_min`          int         DEFAULT NULL COMMENT '下限',
    `value_max`          int         DEFAULT NULL COMMENT '上限',
    `notification_level` int         DEFAULT NULL COMMENT '警告级别',
    PRIMARY KEY (`dt`, `tbl`, `col`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    comment '空值指标表';

-- 创建重复值指标表，duplicate
CREATE TABLE data_supervisor.`duplicate`
(
    `dt`                 date        NOT NULL COMMENT '日期',
    `tbl`                varchar(50) NOT NULL COMMENT '表名',
    `col`                varchar(50) NOT NULL COMMENT '列名',
    `value`              int         DEFAULT NULL COMMENT '重复值个数',
    `value_min`          int         DEFAULT NULL COMMENT '下限',
    `value_max`          int         DEFAULT NULL COMMENT '上限',
    `notification_level` int         DEFAULT NULL COMMENT '警告级别',
    PRIMARY KEY (`dt`, `tbl`, `col`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    comment '重复值指标表';

-- 创建值域指标表，rng
CREATE TABLE data_supervisor.`rng`
(
    `dt`                 date        NOT NULL COMMENT '日期',
    `tbl`                varchar(50) NOT NULL COMMENT '表名',
    `col`                varchar(50) NOT NULL COMMENT '列名',
    `value`              int         DEFAULT NULL COMMENT '超出预定值域个数',
    `range_min`          int         DEFAULT NULL COMMENT '值域下限',
    `range_max`          int         DEFAULT NULL COMMENT '值域上限',
    `value_min`          int         DEFAULT NULL COMMENT '下限',
    `value_max`          int         DEFAULT NULL COMMENT '上限',
    `notification_level` int         DEFAULT NULL COMMENT '警告级别',
    PRIMARY KEY (`dt`, `tbl`, `col`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    comment '值域指标表';

-- 创建环比增长指标表，day_on_day
CREATE TABLE data_supervisor.`day_on_day`
(
    `dt`                 date        NOT NULL COMMENT '日期',
    `tbl`                varchar(50) NOT NULL COMMENT '表名',
    `value`              double DEFAULT NULL COMMENT '环比增长百分比',
    `value_min`          double DEFAULT NULL COMMENT '增长上限',
    `value_max`          double DEFAULT NULL COMMENT '增长上限',
    `notification_level` int    DEFAULT NULL COMMENT '警告级别',
    PRIMARY KEY (`dt`, `tbl`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    comment '环比增长指标表';

-- 创建同比增长指标表，week_on_week
CREATE TABLE data_supervisor.`week_on_week`
(
    `dt`                 date        NOT NULL COMMENT '日期',
    `tbl`                varchar(50) NOT NULL COMMENT '表名',
    `value`              double DEFAULT NULL COMMENT '同比增长百分比',
    `value_min`          double DEFAULT NULL COMMENT '增长上限',
    `value_max`          double DEFAULT NULL COMMENT '增长上限',
    `notification_level` int    DEFAULT NULL COMMENT '警告级别',
    PRIMARY KEY (`dt`, `tbl`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    comment '同比增长指标表';
