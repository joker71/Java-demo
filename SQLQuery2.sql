﻿create database QLBH
create table USER_ACCOUNT
(
 USER_NAME VARCHAR(30) not null,
 PASSWORD VARCHAR(30) not null,
 USER_FULLNAME VARCHAR(30) not null,
 PHONE VARCHAR(12),
 GENDER VARCHAR(1),
 EMAIL VARCHAR(60),
 ADDRESS VARCHAR(200),
 USER_ROLE VARCHAR(1) not null ,
 USER_ACTIVE VARCHAR(1) not null,
 primary key (USER_NAME)
);
insert into USER_ACCOUNT (USER_NAME, GENDER, PASSWORD, USER_ACTIVE, USER_ROLE, USER_FULLNAME)
values ('tom', 'M', 'tom001', '1', '1', 'Tom Holland');
insert into USER_ACCOUNT (USER_NAME, GENDER, PASSWORD, USER_ACTIVE, USER_ROLE, USER_FULLNAME)
values ('MiA', 'F', '1612', '1', '1', 'Mai Anh');
insert into USER_ACCOUNT (USER_NAME, GENDER, PASSWORD, USER_ACTIVE, USER_ROLE, USER_FULLNAME)
values ('Sơn', 'M', 'son12', '1', '0', 'Thái Sơn');
select * from USER_ACCOUNT
create table PRODUCT
(
CODE  VARCHAR(20) not null,
SIZE INT not null,
BRAND VARCHAR(20) not null,
COLOR VARCHAR(20) not null,
NAME  VARCHAR(128) not null,
PRICEINT FLOAT ,
PRICEOUT FLOAT ,
DESCRIPTION VARCHAR(100),
primary key (CODE)
) ;
insert into PRODUCT(CODE, NAME, SIZE, BRAND, COLOR, PRICEINT, PRICEOUT)
values ('P002', 'TUF-104', 14, 'ASUS', 'BLACK', 14000000, 16000000);
insert into PRODUCT(CODE, NAME, SIZE, BRAND, COLOR, PRICEINT, PRICEOUT)
values ('P001', 'INPERSON', 14, 'DELL', 'SILIVER', 11000000, 16000000);
insert into PRODUCT(CODE, NAME, SIZE, BRAND, COLOR, PRICEINT, PRICEOUT)
values ('P004', 'GF65', 17, 'MSI', 'RED', 20400000, 25000000);
insert into PRODUCT(CODE, NAME, SIZE, BRAND, COLOR, PRICEINT, PRICEOUT)
values ('P005', 'TUF-105', 15, 'ASUS', 'BLACK', 14000000, 16000000);
insert into PRODUCT(CODE, NAME, SIZE, BRAND, COLOR, PRICEINT, PRICEOUT)
values ('P006', 'PLAVION', 14, 'HP', 'SILIVER', 11000000, 16000000);
insert into PRODUCT(CODE, NAME, SIZE, BRAND, COLOR, PRICEINT, PRICEOUT)
values ('P014', 'NITRO', 15, 'ACER', 'RED', 13400000, 15000000);
insert into PRODUCT(CODE, NAME, SIZE, BRAND, COLOR, PRICEINT, PRICEOUT)
values ('P016', 'PLAVION', 13, 'HP', 'SILIVER', 11000000, 16000000);
insert into PRODUCT(CODE, NAME, SIZE, BRAND, COLOR, PRICEINT, PRICEOUT)
values ('P024', 'NITRO', 15, 'ACER', 'RED', 13400000, 15000000);
select * from PRODUCT