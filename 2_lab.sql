#1
select * from income_o
where inc between 5000 and 10000 
order by inc;

#2
select date from pass_in_trip
where place like '1_'
order by date;

#3
select pc.model, product.maker 
from product 
inner join pc 
on product.model = pc.model  
where pc.price < 600;

#4
select maker
from product
where maker not in(
	select maker 
	from product
		where model not in(
		select model
		from pc
		group by model
		) and type = 'PC'
	group by maker) and type = 'PC'
group by maker;

#5
select classes.class from classes join outcomes on outcomes.ship = classes.class
where outcomes.result = 'sunk'
union
select ships.name from ships join outcomes on outcomes.ship = ships.name
where outcomes.ship = ships.name and outcomes.result = 'sunk';

#6
select concat('ряд: ',left(place, 1)) as 'ряд', concat('місце: ', right(place, 1)) as 'місце' from pass_in_trip;

#7
select product.maker, min(printer.price)
from product
join printer
on product.model = printer.model
group by product.maker
order by min(printer.price);

#8
select product.maker, max(pc.price)
from product
join pc
on product.model = pc.model
group by product.maker;

#9
select product.maker,
case 
	when count(case printer.type when 'Laser' then 1 end) = 0 then 'no'
	when count(case printer.type when 'Laser' then 1 end) != 0 then concat('yes(', count(case printer.type when 'Laser' then 1 end), ')')
    end as Laser,
case 
	when count(case printer.type when 'Jet' then 1 end) = 0 then 'no'
	when count(case printer.type when 'Jet' then 1 end) != 0 then concat('yes(', count(case printer.type when 'Jet' then 1 end), ')')
    end as Jet,
case 
	when count(case printer.type when 'Matrix' then 1 end) = 0 then 'no'
	when count(case printer.type when 'Matrix' then 1 end) != 0 then concat('yes(', count(case printer.type when 'Matrix' then 1 end), ')')
    end as Laser
from product join printer on product.model = printer.model
group by product.maker;

#10
select class, count(*) from 
(select class from
(select class from classes
union
select ship from outcomes
where ship != any(select name from ships)) as classes_and_outcomes
union all
select class from ships) as classes_and_outcomes_and_ships
group by class
