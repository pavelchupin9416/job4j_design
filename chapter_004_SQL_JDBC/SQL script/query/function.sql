INSERT INTO people ("name") VALUES
	 ('Pavel'),
	 ('Viktor'),
	 ('Nikolai'),
	 ('Olga'),
	 ('Jon'),
	 ('Tom'),
	 ('Ivan');

INSERT INTO devices ("name",price) VALUES
	 ('Poco m3 pro',18000.0),
	 ('Poco x3',21400.0),
	 ('Boss rc 300',38000.0),
	 ('Boss rc 600',45670.0),
	 ('Hotone ampero',23130.0),
	 ('Alesis nitro mesh kit',66000.0),
	 ('Alesis strike pro',180344.0),
	 ('Ammon stereo looper',5600.0);



INSERT INTO devices_people (device_id,people_id) VALUES
	 (1,5),
	 (6,1),
	 (1,3),
	 (2,4),
	 (5,7),
	 (5,1),
	 (6,2),
	 (5,2),
	 (8,6),
	 (7,3),
	 (8,1),
	 (2,2);

select avg(price) as "Средняя цена устройства"
from devices;

select p.name as "Человек", avg(d.price) as "Средняя цена устройства"
from devices_people as d_p join devices as d 
	on d_p.device_id =d.id join people  as p 
	on  d_p.people_id =p.id
group by p.name;

select p.name as "Человек", avg(d.price) as "Средняя цена устройства"
from devices_people as d_p join devices as d 
	on d_p.device_id =d.id join people  as p 
	on  d_p.people_id =p.id
group by p.name
having avg(d.price) > 25000;
