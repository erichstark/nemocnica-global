-- Insurances
insert into insurance(name,enabled,updated) VALUES('Dôvera',true,now());
insert into insurance(name,enabled,updated) VALUES('Všeobecná zdravotná poistovňa',true,now());
insert into insurance(name,enabled,updated) VALUES('Apollo',false,now());

-- Specializations
insert into specialization(enabled, name, updated) VALUES(TRUE,'Oftalmológia',now());
insert into specialization(enabled, name, updated) VALUES(TRUE,'Chirurgia',now());
insert into specialization(enabled, name, updated) VALUES(TRUE,'Anesteziológia',now());
insert into specialization(enabled, name, updated) VALUES(TRUE,'Všeobecný pre dospelých',now());
insert into specialization(enabled, name, updated) VALUES(FALSE,'Hepatológia',now());

-- Patients
insert into patient(username,account_non_expired,account_non_locked,credentials_non_expired,email,enabled,first_name,password,phone,surname,updated) VALUES('admin',true,true,true,'admin@easycare.sk',true,'Admin','1000:670cf1510ec7137f59a409c5c3af8533f34a93496e4c77a5:4c1ca5b461e019c831ec38da6a9e4c3086fc158136b6c1ee','+42108080808','Admin',now());

-- Authorities
insert into patient_authorities(username, authority) VALUES ('admin','ADMIN');

-- Facilities
insert into facility(city,street_and_number,zip,enabled,name) VALUES('Bratislava','Mickiewiczova 13','81369',true,'Nemocnica Staré Mesto');
insert into facility(city,street_and_number,zip,enabled,name) VALUES('Bratislava','Hlboká 7','81104',false,'1. ortopedická klinika');