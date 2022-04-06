drop table users;
create table users (
    id varchar2(512) primary key,
    password varchar2(512),
    address varchar2(512),
    key_id varchar2(512),
    krn varchar2(512),
    public_key varchar2(512)
    );
drop table scores;
create table scores (
	id varchar2(200),
	played_date date,
	score number
	);