-- Insurances
insert into insurance(name,enabled,updated) VALUES('Dôvera',true,now());
insert into insurance(name,enabled,updated) VALUES('Všeobecná zdravotná poistovňa',true,now());
insert into insurance(name,enabled,updated) VALUES('Apollo',false,now());

-- Specializations
insert into specialization(id,enabled, name, updated) VALUES(1,TRUE,'Oftalmológia',now());
insert into specialization(id,enabled, name, updated) VALUES(2,TRUE,'Chirurgia',now());
insert into specialization(id,enabled, name, updated) VALUES(3,TRUE,'Anesteziológia',now());
insert into specialization(id,enabled, name, updated) VALUES(4,TRUE,'Všeobecný pre dospelých',now());
insert into specialization(id,enabled, name, updated) VALUES(5,FALSE,'Hepatológia',now());

-- Patients
insert into patient(username,account_non_expired,account_non_locked,credentials_non_expired,email,enabled,first_name,password,phone,surname,updated,insurance) VALUES('admin',true,true,true,'admin@easycare.sk',true,'Admin','1000:670cf1510ec7137f59a409c5c3af8533f34a93496e4c77a5:4c1ca5b461e019c831ec38da6a9e4c3086fc158136b6c1ee','+42108080808','Admin',now(),1);
insert into patient(username,account_non_expired,account_non_locked,credentials_non_expired,email,enabled,first_name,password,phone,surname,updated,insurance) VALUES('user',true,true,true,'user@easycare.sk',true,'User','1000:f16ff666a8ef7d831c96ead9f8f751333b9ee322614fe95c:2bd50c86a04d6f6b9b71faba73185f9a25f75ac621dc9625','+42108080808','User',now(),1);

-- Authorities
insert into patient_authorities(username, authority) VALUES ('admin','ADMIN');
insert into patient_authorities(username, authority) VALUES ('user','USER');

-- Facilities
insert into facility(city,street_and_number,zip,enabled,name) VALUES('Bratislava','Mickiewiczova 13','81369',true,'Nemocnica Staré Mesto');
insert into facility(city,street_and_number,zip,enabled,name) VALUES('Bratislava','Hlboká 7','81104',false,'1. ortopedická klinika');


-- Employees
insert into employee(username, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, password, prefix_title, suffix_title, updated) VALUES ('user1',TRUE,TRUE,TRUE,TRUE,'Ján','Drsný','user1','Mudr','','2015-06-14 17:03:57.557');
INSERT INTO employee(username, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, password, prefix_title, suffix_title, updated) VALUES ('user2',TRUE,TRUE,TRUE,TRUE,'Juraj','Kožný','user2','Mudr','','2015-06-14 17:05:57.176');
INSERT INTO employee(username, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, password, prefix_title, suffix_title, updated) VALUES ('user3',TRUE,TRUE,TRUE,TRUE,'Jakub','Kornutný','user3','Mudr','','2015-06-14 17:04:57.176');
INSERT INTO employee(username, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, password, prefix_title, suffix_title, updated) VALUES ('user4',TRUE,TRUE,TRUE,TRUE,'Peter','Mocný','user4','Mudr','','2015-06-14 17:03:57.176');
INSERT INTO employee(username, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, password, prefix_title, suffix_title, updated) VALUES ('user5',TRUE,TRUE,TRUE,TRUE,'Marek','Hutný','user5','Mudr','','2015-06-14 17:02:57.176');



-- Offices
INSERT INTO office(id,enabled, name, facility) VALUES (1,TRUE,'Oftalmologická ambulancia',1);
INSERT INTO office(id,enabled, name, facility) VALUES (2,TRUE,'Chirurgická ambulancia',1);
INSERT INTO office(id,enabled, name, facility) VALUES (3,TRUE,'Hepatologická ambulancia',2);
INSERT INTO office(id,enabled, name, facility) VALUES (4,TRUE,'Chirurgická ambulancia 1.Bratislavská',1);
INSERT INTO office(id,enabled, name, facility) VALUES (5,TRUE,'Meditech ',2);

-- Employee -> office
INSERT INTO employee_office(employee, office) VALUES ('user1',1);
INSERT INTO employee_office(employee, office) VALUES ('user2',2);
INSERT INTO employee_office(employee, office) VALUES ('user3',3);
INSERT INTO employee_office(employee, office) VALUES ('user4',4);
INSERT INTO employee_office(employee, office) VALUES ('user5',5);

-- Office -> specializations
INSERT INTO office_specialization(office, specialization) VALUES (1,1);
INSERT INTO office_specialization(office, specialization) VALUES (2,1);
INSERT INTO office_specialization(office, specialization) VALUES (3,3);
INSERT INTO office_specialization(office, specialization) VALUES (4,4);
INSERT INTO office_specialization(office, specialization) VALUES (5,5);


-- Opening Hours
INSERT INTO opening_hours(id,date, reservation_from, reservation_morning_from, reservation_morning_to, reservation_to, office) VALUES (1,'1','780','420','720','900',1);
INSERT INTO opening_hours(id,date, reservation_from, reservation_morning_from, reservation_morning_to, reservation_to, office) VALUES (2,2,780,420,720,900,1);
INSERT INTO opening_hours(id,date, reservation_from, reservation_morning_from, reservation_morning_to, reservation_to, office) VALUES (3,3,780,420,720,900,1);
INSERT INTO opening_hours(id,date, reservation_from, reservation_morning_from, reservation_morning_to, reservation_to, office) VALUES (4,4,780,420,720,900,1);
INSERT INTO opening_hours(id,date, reservation_from, reservation_morning_from, reservation_morning_to, reservation_to, office) VALUES (5,5,780,420,720,900,1);





