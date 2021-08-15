use TEACH
create table userInfo(
	id int NOT NULL identity(1,1),
	sex int default 0,
	domain_id int default null,
	account varchar(20) not null,
	username varchar(255),
	password varchar(255) not null,
	graghId varchar(255) DEFAULT 'http://localhost:8080/Tmall_SSM_war/img/userImage/defaultImg.jpg',
	selfIntro varchar(MAX) DEFAULT 'Œ¥–¥»Î',
	phone varchar(20) NOT NULL,
	collection_class varchar(500) default null,
	collection_question varchar(500) default null,
	PRIMARY KEY (id)
);
create table category(
	id int not null identity(1,1),
	domain varchar(50) not null,
	primary key (id)
);
create table referal_link(
	id int NOT NULL identity(1,1),
	text_ varchar(255) NOT NULL,
	link varchar(255) NOT NULL
	primary key (id)
);
create table classInfo(
	id int not null identity(1,1),
	domain_id int default null,
	title varchar(255) not null,
	price float default null,
	suggestTime float default null,
	textIntro varchar(MAX) default null,
	use_id int not null,
	front_knowledge varchar(MAX) default null,
	tools varchar(MAX) default null,
	class_content varchar(MAX) default null,
	statu int default null,
	constraint fk_classInfo_category foreign key (domain_id) references category(id),
	constraint fk_classInfo_userInfo foreign key (use_id) references userInfo(id),
	primary key (id)
);
create table ClassImageInfo(
	id int not null identity(1,1),
	classInfo_id int not null,
	statu int default 1,
	primary key (id)
);
create table ClassVideoInfo(
	id int not null identity(1,1),
	classInfo_id int not null,
	statu int default 1,
	primary key (id)
);
create table QuestionImageInfo(
	id int not null identity(1,1),
	question_id int not null,
	statu int default 1,
	primary key (id)
);
create table QuestionVideoInfo(
	id int not null identity(1,1),
	question_id int not null,
	statu int default 1,
	primary key (id)
);
create table comment(
	id int NOT NULL identity(1,1),
	content varchar(MAX) not null,
	use_id int not null,
	question_id int default 0,
	createDate datetime not null,
	like_ int default null,
	replayNum int default null,
	replay_id int default null,
	primary key (id)
);

create table order_(
	id int not null identity(1,1),
	score int not null,
	order_status varchar(20) default 0,
	buyer_id int not null,
	seller_id int not null,
	class_id int not null,
	createDate datetime not null,
	price float not null,
	suggestTime float default null,
	buyer_statu int default null,
	seller_statu int default null,
	primary key (id)
);
create table question(
 id int not null identity(1,1),
 domain_id int default null,
 title varchar(255) not null,
 price float default null,
 suggestTime float default null,
 textIntro varchar(MAX) default null,
 use_id int not null,
 front_knowledge varchar(MAX) default null,
 tools varchar(MAX) default null,
 question_content varchar(MAX) default null,
 statu int default null,
 like_ int default null,
 commentNum int default null,
 primary key (id)
);
create table evaluation(
	id int not null identity(1,1),
	use_id int not null,
	order_id int not null,
	like_ int default null,
	evaluation varchar(MAX) default null,
	class_id int not null,
	primary key (id)
);

create table order_q(
	id int not null identity(1,1),
	score int not null,
	order_status varchar(20) default 0,
	buyer_id int not null,
	seller_id int not null,
	question_id int not null,
	createDate datetime not null,
	price float not null,
	suggestTime float default null,
	buyer_statu int default null,
	seller_statu int default null,
	primary key (id)
);