
CREATE TABLE board(
num number(6) PRIMARY KEY,
author varchar2(15) not null,
title varchar2(90) not null,
content varchar2(1000) not null,
writeday date default sysdate,
readcnt number(6) default 0,
repRoot number(4),
repStep number(4),
repIndent number(4)
)

select * from board

CREATE TABLE member(
id varchar2(6) PRIMARY KEY,
name varchar2(12),
birthday date default sysdate,
key number(6)
)

select * from MEMBER

