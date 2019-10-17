insert into planetype values ("001", 2011, "Ace", "Toshiba", 15, 6);
insert into planetype values ("002", 2017, "Alpha", "Mitsubishi", 20, 9);
insert into planetype values ("003", 2000, "Kakeru", "Kawasaki", 15, 9);
insert into planetype values ("004", 2007, "Beta", "Mitsubishi", 15, 9);
insert into planetype values ("005", 2004, "Twice", "Toshiba", 20, 6);

select * from planetype p where convert(p.year, char) like "%%%%";
select * from planetype p where cast(p.year as char) like "%%%%";