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
drop table transactions;
create table transactions(
    status varchar2 (512),
    transaction_hash varchar2(512),
    transaction_date date
    );
drop table aircrafts;
create table aircrafts(
    owner_address varchar2(512),
    hp number,
    metadata varchar2(512) primary key,
    bin_selected number);