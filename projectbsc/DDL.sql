drop table scores;
create table scores (
	address varchar2(512),
	played_date date,
	score number
	);
drop table users;
create table users (
    name varchar2(512),
    address varchar2(512) primary key
    );