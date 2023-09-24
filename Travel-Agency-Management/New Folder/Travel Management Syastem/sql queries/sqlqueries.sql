use travelmanagementsystem;

create table bookpackage(username varchar(50),package varchar(30),persons varchar(30),id varchar(20),number varchar(30),phone varchar(20),price varchar(20));

create table hotel(name varchar(20), costperperson varchar(20), acroom varchar(20),foodincluded varchar(20));

insert into hotel values ("KB hotel","3400","1000","1700");

insert into hotel values ("Taj hotel","3800","1200","2900");

insert into hotel values ("Nisarg hotel","2000","700","1000");

create table bookhotel(username varchar(20),name varchar(30),persons varchar(20),days varchar(20),ac varchar(20) , food varchar(20), id varchar(20),number varchar(30),phone varchar(20),price varchar(30));

use travelmanagementsystem;

create table account (username varchar(50) primary key,name varchar(50),password varchar(50) unique, question varchar(50),answer varchar(50));

create table customer (username varchar(50),id varchar(50),number varchar(50),name varchar(50),gender varchar(50),country varchar(50),address varchar(50),phone varchar(50),email varchar(50));

-- create table bookpackage (username varchar(50),package varchar(50),persons varchar(50),id varchar(50),number varchar(50),phone varchar(50),price varchar(50));

create table bookhotel (username varchar(50),hotel varchar(50),persons varchar(50),days varchar(50),ac varchar(50),food varchar(50),id varchar(50),number varchar(50),phone varchar(50),price varchar(50));