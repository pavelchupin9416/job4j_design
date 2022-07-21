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