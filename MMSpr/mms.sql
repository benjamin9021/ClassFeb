
CREATE TABLE board(
num number(6) PRIMARY KEY,
id varchar2(15) not null,
title varchar2(90) not null,
content varchar2(1000) not null,
writeday date default sysdate,
readcnt number(6) default 0,
repRoot number(4),
repStep number(4),
repIndent number(4)
)

insert into board values(2,'master','테스트2','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(3,'master','테스트3','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(4,'master','테스트4','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(5,'master','테스트5','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(6,'master','테스트6','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(7,'master','테스트7','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(8,'master','테스트8','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(9,'master','테스트9','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(10,'master','테스트10','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(11,'master','테스트11','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(12,'master','테스트12','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(13,'master','테스트13','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(14,'master','테스트14','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(15,'master','테스트15','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(16,'master','테스트16','테스트중입니다.',sysdate,0,0,0,0);
insert into board values(17,'master','테스트17','테스트중입니다.',sysdate,0,0,0,0);

select * from board

CREATE TABLE member(
id varchar2(10) PRIMARY KEY,
pw varchar2(20) not null,
name varchar2(12) not null,
birthday varchar2(12) not null,
nkey number(4)
)

insert into member values('manager','rnlcksgdk','매니저1','1990-01-24',100);
insert into member values('manager1','rnlcksgdk','매니저2','1990-01-25',100);
insert into member values('user1','1','유저','1990-01-25',1);
insert into member values('user2','1','유저','1990-01-25',1);
insert into member values('user3','1','유저','1990-01-25',1);
insert into member values('user4','1','유저','1990-01-25',1);
insert into member values('user5','1','유저','1990-01-25',1);
insert into member values('user6','1','유저','1990-01-25',1);
insert into member values('user7','1','유저','1990-01-25',1);
insert into member values('user8','1','유저','1990-01-25',1);
insert into member values('user9','1','유저','1990-01-25',1);
insert into member values('user10','1','유저','1990-01-25',1);


drop table member
drop table board
select * from MEMBER



