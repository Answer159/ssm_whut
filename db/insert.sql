use TEACH
insert into category(domain) values
	('��ѧ'),
	('�������ѧ'),
	('��Ϣ����'),
	('����'),
	('����'),
	('Ӣ��'),
	('����'),
	('��ʷ')

insert into referal_link(text_,link) values
	('���','www.baidu.com'),
	('����','www.sougou.com'),
	('��ʷ','www.google.com'),
	('����','www.firefox.com')
insert into userInfo(account,username,password,phone,sex,domain_id) values
	('111','wzh','123',123,1,1),
	('123123','����','123',123456,0,2),
	('12341234','����լ��','123',654321,1,3),
	('312','�����˿�','123',12345,0,4),
	('213','���ݸ�Ŀ','123',12345,1,5),
	('222','������','123',12345,0,6),
	('333','�켣','123',12345,1,7),
	('444','�뵺����','123',12345,0,8),
	('555','һ·��','123',12345,1,1),
	('666','����ս��','123',12345,0,2),
	('777','����','123',12345,1,3),
	('888','�ص���ȥ','123',12345,0,4)

insert into classInfo(domain_id,title,use_id,price,suggestTime,textIntro,front_knowledge,tools,class_content,statu) values
	(1,'����������ô��',4,10,1,'just do it','nothing is impossible','Сѧ�α�','chase your mind',1),
	(2,'c++ָ����ô��',5,20,2,'just do it','nothing is impossible','c++�α�','chase your mind',1),
	(3,'ʱ���·��ʲô��˼',6,30,3,'just do it','nothing is impossible','��·�α�','chase your mind',1),
	(4,'��۾���ѧ��ʲô',7,40,4,'just do it','nothing is impossible','��۾���ѧ�α�','chase your mind',1),
	(1,'������ô���',8,50,5,'just do it','nothing is impossible','Сѧ�α�','chase your mind',1),
	(2,'΢ָ����ô���',9,60,6,'just do it','nothing is impossible','��������ԭ��α�','chase your mind',1),
	(3,'����ŵ�������ʲô',10,70,7,'just do it','nothing is impossible','��·�α�','chase your mind',1),
	(4,'΢�۾���ѧ��ʲô',11,80,8,'just do it','nothing is impossible','΢�۾���ѧ�α�','chase your mind',1),
	(1,'��ش﷨����ʲô�����¿���ʹ��?',1,80,9,'just do it','nothing is impossible','�����α�','chase your mind',1),
	(2,'java�����﷨��ʲô?',2,90,10,'just do it','nothing is impossible','java�α�','chase your mind',1),
	(3,'�����뾺����ʲô��˼?',5,100,11,'just do it','nothing is impossible','��·�α�','chase your mind',1),
	(4,'��ô׬��Ǯ��',4,101,12,'just do it','nothing is impossible','Ŭ��ѧϰ','chase your mind',1)

insert into question(domain_id,title,use_id,price,suggestTime,textIntro,front_knowledge,tools,question_content,statu) values
	(1,'�������ȸ���ڵ��߸��϶���',1,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(2,'��˵��һ�䣬��������ĸо���',2,10,0.5,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(3,'���е�Ǧ�ʣ���ֽ�������ػ�',4,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(4,'���ü��������������ҵ�˭',5,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(1,'�ﵶ�����ζ��è���㶼���˽�',6,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(2,'��������ζ������������Ѱ��',7,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(3,'����ů�����⣬���ժ�����޲�ݮ',8,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(4,'��˵���᲻�óԵ���һ�ָо�',9,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(1,'����������Ѱ�滨��ֻ��һ����̦',1,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(2,'����ɽ֮�����仨̨�����ް߰�',1,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1)

insert into comment(content,use_id,question_id,createDate) values
	('hahaha',4,1,'2018-05-02 10:42:07'),
	('����ʲô������',5,5,'2019-03-02 10:42:07'),
	('ͨ���׶����ã�',6,6,'2021-01-02 10:42:07'),
	('������ҹ',7,7,'2021-01-02 10:42:07'),
	('�ҵİ����������ˮ',8,8,'2021-01-02 10:42:07'),
	('�����ǳ�������',9,1,'2021-01-02 10:42:07'),
	('���ϳ���',10,1,'2021-01-02 10:42:07'),
	('������Ŀ��',11,1,'2021-01-02 10:42:07'),
	('��Ҫ��¶������',1,1,'2021-01-02 10:42:07'),
	('��һ�㺹',2,1,'2021-01-02 10:42:07'),
	('���������',7,1,'2021-01-02 10:42:07'),
	('Ϊ���̿ε���һ��',4,1,'2021-01-02 10:42:07'),
	('�������һ��',5,1,'2021-01-02 10:42:07'),
	('���ҵ���һ��',5,1,'2021-01-02 10:42:07'),
	('����ô������',6,1,'2021-01-02 10:42:07'),
	('�η��������Թ���������',1,5,'2021-01-02 10:42:07'),
	('��ƫƫ�꽥��',1,6,'2021-01-02 10:42:07'),
	('���ҿ��㲻��',1,7,'2021-01-02 10:42:07'),
	('��Ҫ����Ҳ����������',1,8,'2021-01-02 10:42:07'),
	('�ȵ����������Ҳ���һ�ȽϺ�һ��',1,9,'2021-01-02 10:42:07'),
	('���ǵ���˵����Ψһ�ĳǱ�',1,5,'2021-01-02 10:42:07'),
	('���ŵ��������������',1,6,'2021-01-02 10:42:07'),
	('΢΢Ц��Сʱ�������֪��',1,7,'2021-01-02 10:42:07'),
	('��Ҫ�ޣ���ө������������',1,8,'2021-01-02 10:42:07'),
	('���ĸ�ҥ����Զ������',1,5,'2021-01-02 10:42:07'),
	('�ؼҰɣ��ص����������',1,6,'2021-01-02 10:42:07')

insert into order_(buyer_id,seller_id,class_id,createDate,price,order_status,buyer_statu,seller_statu,score) values
	(1,4,1,'2018-05-02 10:42:07',100,'waitUpdate',1,1,5),
	(2,5,2,'2019-05-02 10:42:07',200,'waiUpdate',1,1,5),
	(3,6,3,'2019-05-02 10:42:07',20,'waiUpdate',1,1,5),
	(4,7,4,'2019-05-02 10:42:07',300,'waiUpdate',1,1,5),
	(5,8,5,'2019-05-02 10:42:07',2000,'waiUpdate',1,1,5),
	(6,9,6,'2019-05-02 10:42:07',10,'waiUpdate',1,1,5),
	(7,10,7,'2019-05-02 10:42:07',200,'waiUpdate',1,1,5),
	(8,11,8,'2019-05-02 10:42:07',200,'waiUpdate',1,1,5),
	(9,1,9,'2019-05-02 10:42:07',200,'waiUpdate',1,1,5)

insert into order_q(buyer_id,seller_id,question_id,createDate,price,order_status,buyer_statu,seller_statu,score) values
	(2,1,1,'2018-05-02 10:42:07',10,'waitUpdate',1,1,5),
	(3,2,2,'2018-05-02 10:42:07',20,'waitUpdate',1,1,5),
	(2,4,3,'2018-05-02 10:42:07',30,'waitUpdate',1,1,5),
	(2,5,4,'2018-05-02 10:42:07',40,'waitUpdate',1,1,5),
	(2,6,5,'2018-05-02 10:42:07',50,'waitUpdate',1,1,5),
	(2,7,6,'2018-05-02 10:42:07',60,'waitUpdate',1,1,5),
	(2,8,7,'2018-05-02 10:42:07',70,'waitUpdate',1,1,5),
	(2,9,8,'2018-05-02 10:42:07',80,'waitUpdate',1,1,5),
	(2,1,9,'2018-05-02 10:42:07',90,'waitUpdate',1,1,5),
	(2,1,10,'2018-05-02 10:42:07',110,'waitUpdate',1,1,5),
	(3,1,1,'2018-05-02 10:42:07',101,'waitUpdate',1,1,5),
	(4,1,1,'2018-05-02 10:42:07',102,'waitUpdate',1,1,5),
	(5,1,1,'2018-05-02 10:42:07',103,'waitUpdate',1,1,5),
	(6,1,1,'2018-05-02 10:42:07',104,'waitUpdate',1,1,5),
	(7,1,1,'2018-05-02 10:42:07',105,'waitUpdate',1,1,5)

insert into evaluation(use_id,order_id,class_id,evaluation) values
	(1,1,1,'hello,shouting star'),
	(2,2,2,'һյ���µ������ڴ���'),
	(3,3,3,'�����ź��װ���˻�û��'),
	(4,4,4,'�ɵ���������Բ������'),
	(5,5,5,'ҹ�����ѵ�����̿�����'),
	(6,6,6,'һ��Ư���˼����������'),
	(7,7,7,'����֮���ů����˼����'),
	(8,8,8,'˭�������õ���һ��������'),
	(9,9,9,'��Ҷ������Ⱦɫ����ҿ�͸')
