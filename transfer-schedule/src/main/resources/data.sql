DROP TABLE IF EXISTS transfer;
DROP TABLE IF EXISTS transfer_rate;

create table TRANSFER(
ID serial,
SOURCE_ACCOUNT varchar(6),
DESTINATION_ACCOUNT varchar(6),
TRANSFER_AMOUNT float,
TRANSFER_RATE float,	
TRANSFER_DATE date,
SCHEDULING_DATE date,
primary key (ID));

create table TRANSFER_RATE(
ID serial,
RATE_MIN_DAY integer,
RATE_MAX_DAY integer,
RATE_PERCENTAGE integer,
RATE_VALUE float,
RATE_MULTIPLIER float,
TRANSFER_VALUE_GREATER float,	
primary key (ID));

insert into TRANSFER_RATE (ID, RATE_MIN_DAY, RATE_MAX_DAY, RATE_PERCENTAGE, RATE_VALUE, RATE_MULTIPLIER,TRANSFER_VALUE_GREATER) values
(1, 0, 0, 3, 3.0, 0, 0);

insert into TRANSFER_RATE (ID, RATE_MIN_DAY, RATE_MAX_DAY, RATE_PERCENTAGE, RATE_VALUE, RATE_MULTIPLIER,TRANSFER_VALUE_GREATER) values
(2, 1, 10, 0, 0, 12.0, 0);

insert into TRANSFER_RATE (ID, RATE_MIN_DAY, RATE_MAX_DAY, RATE_PERCENTAGE, RATE_VALUE, RATE_MULTIPLIER,TRANSFER_VALUE_GREATER) values
(3, 10, 20, 8, 0, 0, 0);

insert into TRANSFER_RATE (ID, RATE_MIN_DAY, RATE_MAX_DAY, RATE_PERCENTAGE, RATE_VALUE, RATE_MULTIPLIER,TRANSFER_VALUE_GREATER) values
(4, 20, 30, 6, 0, 0, 0);

insert into TRANSFER_RATE (ID, RATE_MIN_DAY, RATE_MAX_DAY, RATE_PERCENTAGE, RATE_VALUE, RATE_MULTIPLIER,TRANSFER_VALUE_GREATER) values
(5, 30, 40, 4, 0, 0, 0);

insert into TRANSFER_RATE (ID, RATE_MIN_DAY, RATE_MAX_DAY, RATE_PERCENTAGE, RATE_VALUE, RATE_MULTIPLIER,TRANSFER_VALUE_GREATER) values
(6, 40, 0, 2, 0, 0, 100.000);
