
/*menu_item*/
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99', '1', '2019-04-23', 'Main Course', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129', '1', '2019-12-23', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149', '1', '2020-01-10', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57', '0', '2021-01-01', 'Starters', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownie', '32', '1', '2022-02-05', 'Dessert', '1');

/*user*/
insert into`truyum`.`user`(us_id,us_name) values (1,'Siva');
insert into`truyum`.`user`(us_id,us_name) values (2,'Ajay');

/*cart table details*/
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values (1,1);
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values (1,3);
insert into `truyum`.`cart`(ct_us_id,ct_us_id) values (1,5);

/*View Menu Item List Admin(TYUC001)*/
select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery 
from truyum.menu_item;

/*View MenuItem List Customer(TYUC002)*/
select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery 
from truyum.menu_item 
where me_active='1' and me_date_of_launch > (select CURDATE());

/*Edit Menu Item*/
select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery 
from truyum.menu_item where me_id=1;
update truyum.menu_item
set
me_name= 'Sandwich Toast',
me_price= '100.00',
me_active= '1',
me_date_of_launch= '2020-01-15',
me_category= 'Starters',
me_free_delivery= '1'
where me_id=1;

/*Add to Cart (TYUC004)*/
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values (1,1);
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values (1,3);
insert into `truyum`.`cart`(ct_us_id,ct_me_id) values (1,5);

/*View Cart (TYUC005)*/
select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery 
from truyum.menu_item
inner join truyum.cart on
menu_item.me_id=cart.ct_me_id
where ct_us_id=1;

select sum(me_price) as Total
from truyum.menu_item
inner join truyum.cart on
menu_item.me_id=cart.ct_me_id
where ct_us_id=1;

/*Remove Item from Cart (TYUC006)*/
Delete from truyum.cart where ct_us_id=1 and ct_me_id=5;
