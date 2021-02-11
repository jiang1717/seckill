-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
use seckill;
-- 创建秒杀库存表
create table seckill(
`seckill_id` bigint not null AUTO_INCREMENT COMMENT '商品库存id', -- 自增
`name` varchar(120) not null COMMENT '商品名称',
`number` int not null COMMENT '库存数量',
`start_time` datetime not null COMMENT '秒杀开启时间',
`end_time` datetime not null COMMENT '秒杀结束时间',
-- mysql5.5 只能有一个Timestamp,将其余列类型改为datetime类型就可以解决。
`create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
-- 只有InnoDB支持事务  初始化自增
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- 初始化数据
-- 多行数据插入
insert into seckill(name, number, start_time, end_time)
values
('1000元秒杀华为mate40', 100, '2021-02-05 00:00:00', '2021-02-06 00:00:00'),
('500元秒杀iPhone12', 200, '2021-02-05 00:00:00', '2021-02-06 00:00:00'),
('300元秒杀OPPO Reno5 Pro', 300, '2021-02-05 00:00:00', '2021-02-06 00:00:00'),
('1000元秒杀小米10', 400, '2021-02-05 00:00:00', '2021-02-06 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关的信息
create table success_killed(
`seckill_id` bigint not null COMMENT '商品库存id',
`user_phone` bigint not null COMMENT '用户手机号',
`state` tinyint not null DEFAULT -1 COMMENT '状态标识：-1：无效 0：成功 1：已付款 2：已发货',
`create_time` timestamp not null COMMENT '创建时间',
PRIMARY KEY (seckill_id, user_phone), -- 联合主键
key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- 连接数据库控制台
mysql -uroot -p












