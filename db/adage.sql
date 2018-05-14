SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS adage;
DROP TABLE IF EXISTS browse_record;
DROP TABLE IF EXISTS collect;
DROP TABLE IF EXISTS search_history;
DROP TABLE IF EXISTS sys_user;
DROP TABLE IF EXISTS vote;




/* Create Tables */

CREATE TABLE adage
(
	-- 主键
	id varchar(32) NOT NULL COMMENT '主键',
	-- 谚语
	adage varchar(200) COMMENT '谚语',
	-- 简单意思
	outline varchar(200) COMMENT '简单意思',
	-- 详细解析
	detail varchar(800) COMMENT '详细解析',
	-- 所属类型
	types varchar(20) COMMENT '所属类型',
	-- 所属季
	season varchar(2) COMMENT '所属季',
	-- 很不错
	upvote int COMMENT '很不错',
	-- 没感觉
	downvote int COMMENT '没感觉',
	-- 创建者
	create_user varchar(32) COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 更新者
	update_user varchar(32) COMMENT '更新者',
	-- 更新时间
	update_date datetime COMMENT '更新时间',
	-- 删除标志
	del_flag varchar(2) COMMENT '删除标志',
	PRIMARY KEY (id)
);


CREATE TABLE browse_record
(
	-- 主键
	id varchar(32) NOT NULL COMMENT '主键',
	-- 谚语主键
	adage_id varchar(32) COMMENT '谚语主键',
	-- 用户主键
	user_id varchar(32) COMMENT '用户主键',
	-- 创建者
	create_user varchar(32) COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 更新者
	update_user varchar(32) COMMENT '更新者',
	-- 更新时间
	update_date datetime COMMENT '更新时间',
	-- 删除标志
	del_flag varchar(2) COMMENT '删除标志',
	PRIMARY KEY (id)
);


CREATE TABLE collect
(
	-- 主键
	id varchar(32) NOT NULL COMMENT '主键',
	-- 谚语主键
	adage_id varchar(32) COMMENT '谚语主键',
	-- 用户主键
	user_id varchar(32) COMMENT '用户主键',
	-- 创建者
	create_user varchar(32) COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 更新者
	update_user varchar(32) COMMENT '更新者',
	-- 更新时间
	update_date datetime COMMENT '更新时间',
	-- 删除标志
	del_flag varchar(2) COMMENT '删除标志',
	PRIMARY KEY (id)
);


CREATE TABLE search_history
(
	-- 主键
	id varchar(32) NOT NULL COMMENT '主键',
	-- 搜索内容
	context varchar(100) COMMENT '搜索内容',
	-- 计数
	count int COMMENT '计数',
	-- 创建者
	create_user varchar(32) COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 更新者
	update_user varchar(32) COMMENT '更新者',
	-- 更新时间
	update_date datetime COMMENT '更新时间',
	-- 删除标志
	del_flag varchar(2) COMMENT '删除标志',
	PRIMARY KEY (id)
);


CREATE TABLE sys_user
(
	-- 主键
	id varchar(32) NOT NULL COMMENT '主键',
	-- 昵称
	name varchar(50) COMMENT '昵称',
	-- 微信唯一主键
	wx_id varchar(64) COMMENT '微信唯一主键',
	-- 配额数
	allocation int COMMENT '配额数',
	-- 最近一次登录时间
	last_login datetime COMMENT '最近一次登录时间',
	-- 用户状态
	-- 1已启用
	-- 2禁止登录
	state varchar(2) COMMENT '用户状态
1已启用
2禁止登录',
	-- 金币
	gold_coin int COMMENT '金币',
	-- 等级
	level int COMMENT '等级',
	-- 创建者
	create_user varchar(32) COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 更新者
	update_user varchar(32) COMMENT '更新者',
	-- 更新时间
	update_date datetime COMMENT '更新时间',
	-- 删除标志
	del_flag varchar(2) COMMENT '删除标志',
	PRIMARY KEY (id)
);


CREATE TABLE vote
(
	-- 主键
	id varchar(32) NOT NULL COMMENT '主键',
	-- 谚语主键
	adage_id varchar(32) COMMENT '谚语主键',
	-- 用户主键
	user_id varchar(32) COMMENT '用户主键',
	-- 投票类型
	vote varchar(2) COMMENT '投票类型',
	-- 创建者
	create_user varchar(32) COMMENT '创建者',
	-- 创建时间
	create_date datetime COMMENT '创建时间',
	-- 更新者
	update_user varchar(32) COMMENT '更新者',
	-- 更新时间
	update_date datetime COMMENT '更新时间',
	-- 删除标志
	del_flag varchar(2) COMMENT '删除标志',
	PRIMARY KEY (id)
);



