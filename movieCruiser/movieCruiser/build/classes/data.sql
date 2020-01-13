create database if not exists moviecruiser;
use moviecruiser;

/*Movies*/
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787965087', '1', '2019-08-05', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', '1', '2019-12-02', 'Superhero', '0');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', '1', '2020-01-05', 'Romance', '0');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', '0', '2020-09-10', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers:End Game', '2750760348', '1', '2022-05-02', 'Superhero', '1');

/*user*/
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Ajay');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Veer');

/*favorites table details*/
INSERT INTO `moviecruiser`.`favorites` (`ft_id`, `ft_us_id`, `ft_mo_id`) VALUES ('1', '1', '1');
INSERT INTO `moviecruiser`.`favorites` (`ft_id`, `ft_us_id`, `ft_mo_id`) VALUES ('4', '1', '3');

/*View Movie List Admin*/
select mo_id,mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser 
from moviecruiser.movies;

/*View Movie List Customer*/
select mo_id,mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser 
from moviecruiser.movies 
where mo_active='1' and mo_date_of_launch > (select CURDATE());

/*Edit Menu Item*/
select mo_id,mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser 
from moviecruiser.movies 
where mo_id='1';
update moviecruiser.movies
set
mo_title= 'Spiderman',
mo_box_office= '1678648765',
mo_active= '1',
mo_date_of_launch= '2020-09-10',
mo_genre= 'Superhero',
mo_has_teaser= '1' 
where mo_id=1;

/*Add to Favorites*/
insert into `moviecruiser`.`favorites`(ft_us_id,ft_mo_id) values (1,1);
insert into `moviecruiser`.`favorites`(ft_us_id,ft_mo_id) values (1,3);
insert into `moviecruiser`.`favorites`(ft_us_id,ft_mo_id) values (1,5);

/*View Favorites*/
select mo_id,mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser
from moviecruiser.movies
inner join moviecruiser.favorites on
movies.mo_id=favorites.ft_mo_id
where ft_us_id=1;

select count(mo_id) as Total_favorites
from moviecruiser.movies
inner join moviecruiser.favorites on
movies.mo_id=favorites.ft_mo_id
where ft_us_id=1;

/*Remove Item from Favorites*/
Delete from moviecruiser.favorites where ft_us_id=1 and ft_mo_id=2 limit 1;




