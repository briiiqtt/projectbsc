drop table users;
create table users (id varchar2(200) primary key, password varchar2(200));
drop table scores;
create table scores (id varchar2(200), played_date date, score number);