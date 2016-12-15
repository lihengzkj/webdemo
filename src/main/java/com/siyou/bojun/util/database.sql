
select table_name from information_schema.tables where table_schema='databaseName';

show databases;

create database bojun character set utf8;

use dbdemo;


create table t_user(
	user_id int auto_increment primary key,
	user_name varchar(30),
	credits  int,
	password varchar(32) not null,
	last_visit datetime,
	last_ip  varchar(23),
	login_status varchar(1),
	privilege varchar(10)
);


/*绠＄悊鍝℃棩蹇楄〃*/
create table t_login_log(
	login_log_id int auto_increment primary key,
	user_id int,
	ip varchar(23),
	login_datatime datetime
) ;

insert into t_user(user_name,credits,password,last_visit,login_status,privilege)values('sadmin',100,'sadmin@1qa','2016-10-18 15:38:11','F','SUPPER');
insert into t_user(user_name,credits,password,last_visit,login_status,privilege)values('kejing',100,'kejing123','2016-10-18 15:38:11','F','ADMIN');
insert into t_user(user_name,credits,password,last_visit,login_status,privilege)values('guest',100,'guest321','2016-10-18 15:38:11','F','NORMAL');



