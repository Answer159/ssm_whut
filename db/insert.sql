use TEACH
insert into category(domain) values
	('数学'),
	('计算机科学'),
	('信息工程'),
	('经管'),
	('物理'),
	('英语'),
	('地理'),
	('历史')

insert into referal_link(text_,link) values
	('理科','www.baidu.com'),
	('工科','www.sougou.com'),
	('文史','www.google.com'),
	('政法','www.firefox.com')
insert into userInfo(account,username,password,phone,sex,domain_id) values
	('111','wzh','123',123,1,1),
	('123123','晴天','123',123456,0,2),
	('12341234','阳光宅男','123',654321,1,3),
	('312','开不了口','123',12345,0,4),
	('213','本草纲目','123',12345,1,5),
	('222','七里香','123',12345,0,6),
	('333','轨迹','123',12345,1,7),
	('444','半岛铁盒','123',12345,0,8),
	('555','一路向北','123',12345,1,1),
	('666','最后的战役','123',12345,0,2),
	('777','安静','123',12345,1,3),
	('888','回到过去','123',12345,0,4)

insert into classInfo(domain_id,title,use_id,price,suggestTime,textIntro,front_knowledge,tools,class_content,statu) values
	(1,'四则运算怎么算',4,10,1,'just do it','nothing is impossible','小学课本','chase your mind',1),
	(2,'c++指针怎么用',5,20,2,'just do it','nothing is impossible','c++课本','chase your mind',1),
	(3,'时序电路是什么意思',6,30,3,'just do it','nothing is impossible','电路课本','chase your mind',1),
	(4,'宏观经济学是什么',7,40,4,'just do it','nothing is impossible','宏观经济学课本','chase your mind',1),
	(1,'分数怎么相乘',8,50,5,'just do it','nothing is impossible','小学课本','chase your mind',1),
	(2,'微指令怎么设计',9,60,6,'just do it','nothing is impossible','计算机组成原理课本','chase your mind',1),
	(3,'与非门的作用是什么',10,70,7,'just do it','nothing is impossible','电路课本','chase your mind',1),
	(4,'微观经济学是什么',11,80,8,'just do it','nothing is impossible','微观经济学课本','chase your mind',1),
	(1,'洛必达法则在什么条件下可以使用?',1,80,9,'just do it','nothing is impossible','高数课本','chase your mind',1),
	(2,'java基本语法是什么?',2,90,10,'just do it','nothing is impossible','java课本','chase your mind',1),
	(3,'险象与竞争是什么意思?',5,100,11,'just do it','nothing is impossible','电路课本','chase your mind',1),
	(4,'怎么赚大钱？',4,101,12,'just do it','nothing is impossible','努力学习','chase your mind',1)

insert into question(domain_id,title,use_id,price,suggestTime,textIntro,front_knowledge,tools,question_content,statu) values
	(1,'窗外的麻雀，在电线杆上多嘴',1,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(2,'你说这一句，很有夏天的感觉？',2,10,0.5,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(3,'手中的铅笔，在纸上来来回回',4,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(4,'我用几行字形容你是我的谁',5,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(1,'秋刀鱼的滋味，猫跟你都想了解',6,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(2,'初恋的香味就这样被我们寻回',7,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(3,'那温暖的阳光，像刚摘的鲜艳草莓',8,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(4,'你说你舍不得吃掉这一种感觉',9,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(1,'问泪声入林寻梨花白只得一行青苔',1,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1),
	(2,'天在山之外雨落花台我两鬓斑白',1,100,2,'just do it','nothing is impossible','jay chou','chase your mind',1)

insert into comment(content,use_id,question_id,createDate) values
	('hahaha',4,1,'2018-05-02 10:42:07'),
	('讲的什么东西？',5,5,'2019-03-02 10:42:07'),
	('通俗易懂，好！',6,6,'2021-01-02 10:42:07'),
	('雨下整夜',7,7,'2021-01-02 10:42:07'),
	('我的爱溢出就像雨水',8,8,'2021-01-02 10:42:07'),
	('让我们乘着阳光',9,1,'2021-01-02 10:42:07'),
	('海上冲浪',10,1,'2021-01-02 10:42:07'),
	('吸引她目光',11,1,'2021-01-02 10:42:07'),
	('不要怕露出胸膛',1,1,'2021-01-02 10:42:07'),
	('留一点汗',2,1,'2021-01-02 10:42:07'),
	('你成了型男',7,1,'2021-01-02 10:42:07'),
	('为你翘课的那一天',4,1,'2021-01-02 10:42:07'),
	('花落的那一天',5,1,'2021-01-02 10:42:07'),
	('教室的那一间',5,1,'2021-01-02 10:42:07'),
	('我怎么看不见',6,1,'2021-01-02 10:42:07'),
	('刮风这天我试过握着你手',1,5,'2021-01-02 10:42:07'),
	('但偏偏雨渐渐',1,6,'2021-01-02 10:42:07'),
	('大到我看你不见',1,7,'2021-01-02 10:42:07'),
	('还要多久我才能在你身边',1,8,'2021-01-02 10:42:07'),
	('等到放晴的那天也许我会比较好一点',1,9,'2021-01-02 10:42:07'),
	('还记得你说家是唯一的城堡',1,5,'2021-01-02 10:42:07'),
	('随着稻香河流继续奔跑',1,6,'2021-01-02 10:42:07'),
	('微微笑，小时候的梦我知道',1,7,'2021-01-02 10:42:07'),
	('不要哭，让萤火虫带着你逃跑',1,8,'2021-01-02 10:42:07'),
	('乡间的歌谣，永远的依靠',1,5,'2021-01-02 10:42:07'),
	('回家吧，回到最初的美好',1,6,'2021-01-02 10:42:07')

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
	(2,2,2,'一盏离愁孤灯伫立在窗口'),
	(3,3,3,'我在门后假装你人还没走'),
	(4,4,4,'旧地如重游月圆跟着我'),
	(5,5,5,'夜半清醒的烛火不忍苛责我'),
	(6,6,6,'一壶漂泊浪迹天涯难入喉'),
	(7,7,7,'你走之后酒暖回忆思念瘦'),
	(8,8,8,'谁再用琵琶弹奏一曲东风破'),
	(9,9,9,'枫叶将故事染色结局我看透')
