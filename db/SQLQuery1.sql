USE TEACH
create table userInfo(
	id int NOT NULL identity(1,1),
	username varchar(255),
	password varchar(255) not null,
	graghId int DEFAULT NULL,
	selfIntro varchar(1000) DEFAULT 'δд��',
	phone varchar(20) NOT NULL,
	PRIMARY KEY (id)
);
insert into userInfo(username,password,phone) values
	('wzh',123,123456),
	('aaa',234,654321)
create table category(
	id int not null identity(1,1),
	domain varchar(50) not null,
	primary key (id)
);
insert into category(domain) values
	('��ѧ'),
	('�������ѧ'),
	('��Ϣ����'),
	('����')
create table referal_link(
	id int NOT NULL identity(1,1),
	text_ varchar(255) NOT NULL,
	link varchar(255) NOT NULL
	primary key (id)
);
insert into referal_link(text_,link) values
	('���','nowhere'),
	('����','nowhere'),
	('��ʷ','nowhere'),
	('����','nowhere')
create table classInfo(
	id int not null identity(1,1),
	domain_id int default null,
	title varchar(255) not null,
	price float default null,
	suggestTime float default null,
	textIntro varchar(1000) default null,
	graghId int default null,
	videoId int default null,
	use_id int not null,
	constraint fk_classInfo_category foreign key (domain_id) references category(id),
	constraint fk_classInfo_userInfo foreign key (use_id) references userInfo(id),
	primary key (id)
);
insert into classInfo(domain_id,title,use_id) values
	(1,'Բ׶���ߵ����ֽⷨ',1),
	(2,'��δ�0��ʼʵ��web����',1),
	(3,'��Ϣ���ݵĸ����׶�',2)

create table comment(
	id int NOT NULL identity(1,1),
	content varchar(1000) not null,
	use_id int not null,
	class_id int not null,
	createDate datetime not null,
	constraint fk_comment_userInfo foreign key (use_id) references userInfo(id),
	constraint fk_comment_classInfo foreign key (class_id) references classInfo(id),
	primary key (id)
);
insert into comment(content,use_id,class_id,createDate) values
	('���ĺܺ�',1,1,'2018-05-02 10:42:07'),
	('����ʲô������',2,2,'2019-03-02 10:42:07'),
	('ͨ���׶����ã�',1,3,'2021-01-02 10:42:07')

create table order_(
	id int not null identity(1,1),
	order_status int default 0,
	buyer_statu int default 1,
	seller_statu int default 0,
	buyer_id int not null,
	seller_id int not null,
	class_id int not null,
	createDate datetime not null,
	price float not null,
	constraint fk_buyer_userInfo foreign key (buyer_id) references userInfo(id),
	constraint fk_seller_userInfo foreign key (seller_id) references userInfo(id),
	constraint fk_class_classInfo foreign key (class_id) references classInfo(id),
	primary key (id)
);
insert into order_(buyer_id,seller_id,class_id,createDate,price) values
	(2,1,1,'2018-05-02 10:42:07',100),
	(1,2,2,'2019-05-02 10:42:07',200)

create table question(
 id int not null identity(1,1),
 domain_id int default null,
 title varchar(255) not null,
 price float default null,
 suggestTime float default null,
 textIntro varchar(1000) default null,
 use_id int not null,
 constraint fk_question_category foreign key (domain_id) references category(id),
 constraint fk_question_userInfo foreign key (use_id) references userInfo(id),
 primary key (id)
);
insert into question(domain_id,title,use_id,price,suggestTime,textIntro) values
	(1,'�������',1,100,2,'��ô��⵼���ĸ��������ô��?'),
	(2,'���ݿ������������������',2,10,0.5,'���ݿ�С�ף���ô��sql���������������?')
