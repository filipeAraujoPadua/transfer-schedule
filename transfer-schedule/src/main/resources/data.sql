DROP TABLE IF EXISTS transfer;
DROP TABLE IF EXISTS transfer_rate;

create table transfer(
id serial,
source_account varchar(8),
destination_account varchar(8),
transfer_amount float,
transfer_rate float,	
transfer_date date,
scheduling_date date,
primary key (id));

create table transfer_rate(
id serial,
rate_range_of_days integer,
rate_percentage integer,
rate_value float,
rate_multiplier float,
transfer_value_greater float,	
primary key (id));


