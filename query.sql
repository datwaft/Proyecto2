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

insert into plane values ("AX09", "001"),
("BX09", "001"),
("CX09", "001"),
("PD43", "002");

insert into flight (origin, destination, weekday, departure, duration, price, discount) values
("SJO", "LAX", 1, "10:45", "01:30", 700, 0),
("SJO", "NYC", 2, "17:45", "03:00", 800, 0.60),
("SJO", "MSY", 3, "10:35", "02:30", 600, 0.30),
("SJO", "LON", 4, "06:05", "01:30", 650, 1),
("LAX", "SJO", 5, "08:00", "01:00", 750, 0),
("NYC", "SJO", 6, "15:00", "02:00", 850, 0.65),
("LON", "SJO", 7, "12:00", "02:30", 500, 0);

insert into trip (plane, outward, departure, inward, arrival) values
("AX09", 1, CURDATE(), 5, CURDATE()),
("BX09", 1, CURDATE(), null, null);

select * from planetype;
select * from city;
select * from country;
select * from payment;
select * from plane;
select * from flight;
select * from trip;
