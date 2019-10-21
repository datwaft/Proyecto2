insert into planetype values ("001", 2011, "Ace", "Toshiba", 15, 6),
("002", 2017, "Alpha", "Mitsubishi", 20, 9),
("003", 2000, "Kakeru", "Kawasaki", 15, 9),
("004", 2007, "Beta", "Mitsubishi", 15, 9),
("005", 2004, "Twice", "Toshiba", 20, 6);

insert into country values ("US", "United States"),
("UK", "United Kingdom"),
("BO", "Bolivia"),
("CA", "Canada"),
("CR", "Costa Rica");

insert into city values ("SJO", "San José", "CR"),
("UPL", "Upala", "CR"),
("LAX", "Los Angeles", "US"),
("NYC", "New York", "US"),
("MSY", "New Orleans", "US"),
("LON", "London", "UK"),
("SRB", "Santa Rosa", "BO"),
("YFO", "Flin FLon", "CA"),
("YHM", "Hamilton", "CA");

insert into payment (name) values ("MasterCard"),
("Visa"),
("Discover"),
("American Express"),
("Paypal"),
("Google Pay"),
("Apple Pay");

delete from payment p where p.key < 10000;
alter table payment auto_increment = 0;
update payment p set p.name = "Visa" where p.id = 15;

select * from planetype;
select * from city;
select * from country;
select * from payment;
select id, name FROM payment;

