drop databse if exists patterns;
create database patterns;
create user 'patterns'@'localhost' identified by 'patterns';
create user 'patterns'@'%' identified by 'patterns';
grant ALL privileges on patterns.* to 'patterns'@'localhost';
grant ALL privileges on patterns.* to 'patterns'@'%';
