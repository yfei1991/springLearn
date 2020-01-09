create table cp_cms_ad
(
	id int auto_increment
		primary key,
	ad_name varchar(150) null comment '广告名称',
	start_date datetime null comment '开始时间',
	end_date datetime null comment '结束时间',
	ad_body text null comment '广告内容（如代码）',
	sort_id int null comment '排序编号',
	group_id int null comment '广告分组'
)
comment '广告'
;

create table cp_cms_ad_group
(
	id int auto_increment
		primary key,
	group_name varchar(150) default '' not null,
	status tinyint(1) default '1' not null
)
comment '广告分组'
;

create table cp_cms_ad_silder
(
	id int auto_increment
		primary key,
	silde_name varchar(100) default '' not null,
	img varchar(255) default '' null,
	silde_url varchar(255) default '' not null,
	sort_id int default '0' null,
	status tinyint(1) default '1' null,
	start_date datetime null,
	end_date datetime null
)
comment '幻灯片广告'
;

create table cp_cms_admin
(
	user_id int auto_increment comment '用户id'
		primary key,
	username varchar(64) default '' not null comment '用户名',
	password varchar(64) default '' not null comment '密码',
	create_time timestamp default '0000-00-00 00:00:00' null comment '用户创建时间',
	login_time timestamp null comment '登陆时间',
	logout_time timestamp null comment '离开时间',
	last_ip varchar(64) default '' null comment '登陆IP',
	status tinyint(1) unsigned default '0' not null comment '管理员状态',
	des varchar(255) default '' null comment '管理员说明',
	avatar varchar(255) null comment '用户头像',
	constraint username
		unique (username)
)
comment '系统用户'
;

create table cp_cms_admin_site
(
	id int auto_increment
		primary key,
	user_id int null comment '管理员id',
	site_id int null comment '站点id'
)
comment '系统管理员和用户关联表'
;

create table cp_cms_attachment
(
	id bigint auto_increment
		primary key,
	file_name varchar(50) not null comment '文件名称',
	user_id varchar(32) not null comment '用户ID',
	username varchar(32) null,
	upload_date datetime not null comment '上传时间',
	upload_ip varchar(32) default '' not null comment '上传的ID',
	file_extname varchar(100) default '' not null comment '文件扩展名',
	file_path varchar(500) default '' not null comment '文件路径',
	file_size float(10,2) unsigned default '0.00' not null comment '文件大小',
	url varchar(500) null comment '附件网址',
	file_key varchar(255) null comment '文件key',
	original_file_name varchar(255) null comment '源文件名称'
)
comment '附件表'
;

create table cp_cms_category
(
	category_id bigint auto_increment
		primary key,
	access_style varchar(255) default '' not null comment '栏目访问样式',
	alias varchar(255) default '' not null comment '别名',
	category_name varchar(255) default '' not null comment '分类明细',
	site_id int default '1' null comment '站点编号',
	parent_id bigint default '0' null comment '父类编号',
	model_id int null comment '模型编号',
	alone tinyint(1) default '0' null comment '单页（0：不是，1：是）',
	content mediumtext null comment '文本',
	index_tpl varchar(255) default '' not null comment '模板',
	list_tpl varchar(255) default '' not null comment '列表页面',
	content_tpl varchar(255) default '' not null comment '内容页面',
	is_nav tinyint(1) default '0' not null comment '导航',
	url varchar(255) null comment '外链地址',
	has_child tinyint(1) default '0' null comment '是否有子类',
	is_common tinyint(1) default '0' null comment '是否为通用栏目（子站点也默认继承此栏目）',
	allow_front_submit tinyint(1) default '1' null,
	page_size int null comment '栏目分页数量',
	allow_search tinyint(1) unsigned default '0' null comment '当前栏目下的是否支持全文搜索',
	category_icon varchar(255) null comment '栏目图标',
	permission_key varchar(100) null comment '栏目权限标识',
	sort_id int(11) unsigned default '0' null
)
comment '分类表'
;

create index category_id
	on cp_cms_category (category_id)
;

create index short_name
	on cp_cms_category (alias)
;

create table cp_cms_content
(
	content_id bigint auto_increment
		primary key,
	site_id int default '0' not null comment '站点编号',
	user_id int default '0' not null comment '用户id',
	category_id bigint default '0' not null comment '栏目',
	model_id int default '0' null comment '模型id',
	title varchar(255) default '' not null comment '标题',
	keywords char(40) default '' null comment '关键字',
	description text null comment '描述',
	top tinyint(1) default '0' null comment '热门',
	recommend tinyint(1) default '0' not null comment '推荐',
	thumb varchar(255) null comment '封面',
	status tinyint(1) default '1' not null comment '状态',
	inputdate timestamp null comment '发布时间',
	updatedate timestamp null comment '更新时间',
	url char(100) default '' null comment '文章地址',
	author char(20) default '' not null comment '用户名',
	view_num int(11) unsigned default '0' not null comment '查看次数'
)
comment '内容表'
;

create index catid
	on cp_cms_content (category_id, model_id)
;

create table cp_cms_content_news
(
	content_id bigint default '0' not null
		primary key,
	content mediumtext not null,
	file varchar(255) null
)
;

create table cp_cms_friendlink
(
	id int auto_increment
		primary key,
	link_name varchar(100) default '' not null,
	link_type int(1) default '0' not null,
	img varchar(255) default '' null,
	link_url varchar(255) default '' not null,
	sort_id int default '0' null,
	status tinyint(1) default '1' null,
	group_id int(1) default '0' not null
)
comment '友情链接'
;

create table cp_cms_friendlink_group
(
	id int auto_increment
		primary key,
	group_name varchar(255) null,
	status tinyint(1) null
)
;

create table cp_cms_linkage
(
	id int(5) unsigned auto_increment
		primary key,
	site_id int default '0' not null comment '站点id',
	name varchar(30) not null,
	parent_id int(11) unsigned default '0' not null,
	grade int(1) default '0' not null,
	childs varchar(200) default '' not null,
	sort_id smallint(5) unsigned default '0' not null,
	is_common tinyint(1) default '0' null comment '是否为通用'
)
;

create index child
	on cp_cms_linkage (grade)
;

create index keyid
	on cp_cms_linkage (site_id)
;

create index list
	on cp_cms_linkage (site_id, parent_id, sort_id)
;

create table cp_cms_member
(
	member_id int auto_increment comment '用户id'
		primary key,
	username varchar(64) default '' not null comment '用户名',
	password varchar(64) default '' not null comment '用户密码',
	email varchar(100) default '' not null comment '电子邮件',
	linkman varchar(64) null comment '联系人',
	mobile varchar(11) default '' not null comment '手机号',
	status tinyint(1) default '0' not null comment '用户状态',
	ip varchar(100) null comment '用户登陆ip',
	last_time timestamp null comment '上次登陆时间',
	salt varchar(64) default '' not null comment '用户密码加密盐',
	user_type int(1) default '0' null comment '（0为个人用户，1为企业）',
	level_id int null comment '分组id',
	integral int null comment '用户积分'
)
comment '用户表'
;

create table cp_cms_member_level
(
	id int auto_increment
		primary key,
	level_name varchar(64) null,
	is_default tinyint(1) null,
	`desc` varchar(255) null comment '描述',
	level_credit int default '0' not null
)
comment '会员分组'
;

create table cp_cms_member_oauth
(
	id int unsigned auto_increment
		primary key,
	member_id int default '0' not null,
	oauth_openid varchar(80) default '' not null,
	oauth_name varchar(30) default '' not null,
	oauth_data text not null,
	nickname varchar(255) default '' not null,
	avatar varchar(255) default '' not null,
	login_time bigint(10) unsigned default '0' not null,
	create_time datetime null,
	oauth_type varchar(30) null
)
comment '第三方登陆'
;

create index site
	on cp_cms_member_oauth (oauth_openid, oauth_name)
;

create index username
	on cp_cms_member_oauth (member_id)
;

create table cp_cms_menu
(
	id int auto_increment
		primary key,
	module_name varchar(255) null,
	is_enable tinyint(1) default '0' not null comment '是否启用',
	is_auto_expand tinyint(1) null comment '是否自动展开',
	url varchar(255) null comment '菜单url',
	icon_name varchar(64) null comment '菜单节点图标',
	permission_key varchar(64) null comment '权限key',
	pid int default '0' not null comment '父id编号',
	has_child tinyint(1) default '0' not null comment '有子节点',
	sort_no int default '0' null comment '排序'
)
;

create table cp_cms_model
(
	model_id int auto_increment
		primary key,
	model_name varchar(255) null comment '模型名称',
	table_name varchar(255) null comment '模型表名称',
	site_id bigint null comment '站点id',
	des varchar(255) default '' null comment '字段描述',
	status tinyint(1) default '1' not null comment '状态'
)
comment '模型表'
;

create table cp_cms_model_filed
(
	filed_id int auto_increment comment '字段编号'
		primary key,
	model_id int default '0' not null comment '模型编号',
	filed_name varchar(255) default '' not null comment '字段名称',
	filed_class varchar(255) default '' not null comment '字段类型（如文本）',
	filed_value text null comment '字段值',
	filed_type varchar(255) default '0' not null comment '字段类别（数据库类别）',
	alias varchar(255) default '' not null comment '别名',
	not_null tinyint(1) default '0' not null comment '是否为空',
	filed_length int default '0' null comment '字段长度',
	is_primary tinyint(1) default '0' not null comment '是否为主键',
	setting varchar(255) default '' null
)
comment '模型字段'
;

create table cp_cms_search_words
(
	id int auto_increment
		primary key,
	name varchar(255) not null comment '搜索词汇',
	hit_count int default '0' not null comment '搜索次数',
	is_recommend tinyint(1) default '0' not null comment '推荐',
	site_id int default '1' not null comment '站点'
)
comment '搜索热词'
;

create table cp_cms_site
(
	site_id int auto_increment comment '站点id（0为主站，不能删除）'
		primary key,
	site_name varchar(255) null comment '站点名称',
	domain varchar(255) default '' null comment '域名',
	language char(10) default '' null comment '语言',
	template varchar(20) default '' null comment '模板',
	title varchar(64) null,
	keyword varchar(60) default '' null comment '关键字',
	description text null comment '描述',
	is_mobile tinyint(1) default '0' null comment '移动是否开启',
	mobile_tpl varchar(255) default 'mobile' null comment '手机模板',
	status tinyint(1) default '0' null comment '站点状态',
	logo varchar(255) null
)
comment '站点'
;

create table cp_cms_tag
(
	tag_id int auto_increment
		primary key,
	tag_name varchar(64) default '' not null,
	letter varchar(255) default '' not null,
	count int default '0' null
)
comment 'cmstag'
;

create index letter
	on cp_cms_tag (letter)
;

create index name
	on cp_cms_tag (tag_name)
;

create table cp_cms_tag_content
(
	id int auto_increment
		primary key,
	tag_id int default '0' not null,
	content_id bigint default '0' not null
)
comment '标签内容'
;

create index content_id
	on cp_cms_tag_content (content_id)
;

create index tag_Id
	on cp_cms_tag_content (tag_id)
;

create table cp_cms_topic
(
	topic_id int auto_increment
		primary key,
	category_ids varchar(128) default '' null,
	topic_name varchar(150) not null comment '名称',
	short_name varchar(150) null comment '简称',
	keywords varchar(255) null comment '关键字',
	description varchar(255) null comment '描述',
	title_img varchar(100) null comment '标题图',
	content_img varchar(100) null comment '内容图',
	topic_tpl varchar(100) null comment '专题模板',
	sort_id int default '10' not null comment '排列顺序',
	is_recommend tinyint(1) default '0' not null comment '是否推??',
	site_id int null comment '站点Id'
)
comment 'CMS专题表'
;

