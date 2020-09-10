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
RATE_RANG_OF_DAYS integer,
RATE_PERCENTAGE integer,
RATE_VALUE float,
RATE_MULTIPLIER float,
TRANSFER_VALUE_GREATER float,	
primary key (ID));


