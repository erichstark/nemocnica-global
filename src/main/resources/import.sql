-- Insurances
insert into insurance(name,enabled,updated) VALUES('Dôvera',true,now());
insert into insurance(name,enabled,updated) VALUES('Všeobecná zdravotná poistovňa',true,now());
insert into insurance(name,enabled,updated) VALUES('Apollo',false,now());

-- Specializations
INSERT INTO specialization ( id, name, enabled, updated ) VALUES (1, 'vnútorné lekárstvo', true, now() ),(2, 'infektológia', true, now() ),(3, 'pneumológia a ftizeológia', true, now() ),(4, 'neurológia', true, now() ),(5, 'psychiatria', true, now() ),(6, 'pracovné lekárstvo', true, now() ),(7, 'pediatria', true, now() ),(8, 'všeobecná starostlivosť o deti a dorast', true, now() ),(9, 'gynekológia a pôrodníctvo', true, now() ),(10, 'chirurgia', true, now() ),(11, 'ortopédia', true, now() ),(12, 'urológia', true, now() ),(13, 'úrazová chirurgia', true, now() ),(14, 'otorinolaryngológia', true, now() ),(15, 'oftalmológia', true, now() ),(17, 'pediatrická gynekológia', true, now() ),(18, 'dermatovenerológia', true, now() ),(19, 'klinická onkológia', true, now() ),(20, 'všeobecné lekárstvo', true, now() ),(22, 'dorastové lekárstvo', true, now() ),(23, 'rádiológia', true, now() ),(24, 'klinická biochémia', true, now() ),(25, 'anestéziológia a intenzívna medicína', true, now() ),(26, 'telovýchovné lekárstvo', true, now() ),(27, 'fyziatria, balneológia a liečebná rehabilitácia', true, now() ),(28, 'súdne lekárstvo', true, now() ),(29, 'patologická anatómia', true, now() ),(31, 'hematológia a transfuziológia', true, now() ),(32, 'urgentná medicína', true, now() ),(34, 'klinická mikrobiológia', true, now() ),(37, 'neurochirurgia', true, now() ),(38, 'plastická chirurgia', true, now() ),(39, 'ortopedická protetika', true, now() ),(40, 'klinická imunológia a alergológia', true, now() ),(43, 'radiačná onkológia', true, now() ),(44, 'foniatria', true, now() ),(45, 'reumatológia', true, now() ),(46, 'algeziológia', true, now() ),(47, 'nukleárna medicína', true, now() ),(48, 'gastroenterológia', true, now() ),(49, 'kardiológia', true, now() ),(50, 'diabetológia, poruchy látkovej premeny a výživy', true, now() ),(51, 'neonatológia', true, now() ),(52, 'hygiena detí a mládeže', true, now() ),(56, 'angiológia', true, now() ),(57, 'hygiena životného prostredia', true, now() ),(58, 'hygiena výživy', true, now() ),(59, 'epidemiológia', true, now() ),(60, 'geriatria', true, now() ),(61, 'medicínska informatika a bioštatistika', true, now() ),(62, 'lekárska genetika', true, now() ),(63, 'nefrológia', true, now() ),(64, 'endokrinológia', true, now() ),(65, 'klinická farmakológia', true, now() ),(66, 'zdravotnícka informatika', true, now() ),(67, 'gynekologická sexuológia', true, now() ),(68, 'cievna chirurgia', true, now() ),(69, 'kardiochirurgia', true, now() ),(70, 'maxilofaciálna chirurgia', true, now() ),(73, 'medicína drogových závislostí', true, now() ),(74, 'gerontopsychiatria', true, now() ),(76, 'letecké lekárstvo', true, now() ),(88, 'lekár bez špecializácie', true, now() ),(99, 'lekár predpisujúci lieky pre seba a osoby blízke', true, now() ),(100, 'posudkové lekárstvo', true, now() ),(102, 'ochrana zdravia pred ionizujúcim žiarením', true, now() ),(104, 'pediatrická neurológia', true, now() ),(105, 'detská psychiatria', true, now() ),(106, 'hrudníková chirurgia', true, now() ),(107, 'detská chirurgia', true, now() ),(108, 'pediatrická ortopédia', true, now() ),(109, 'pediatrická urológia', true, now() ),(114, 'pediatrická otorinolaryngológia', true, now() ),(130, 'materno', true, now() ),(131, 'výchova k zdraviu', true, now() ),(140, 'pediatrická imunológia a alergiológia', true, now() ),(145, 'pediatrická reumatológia', true, now() ),(153, 'pediatrická endokrinológia', true, now() ),(154, 'pediatrická gastroenterológia, hepatológia a výživa', true, now() ),(155, 'pediatrická kardiológia', true, now() ),(156, 'pediatrická pneumológia a ftizeológia', true, now() ),(163, 'pediatrická nefrológia', true, now() ),(216, 'hepatológia', true, now() ),(222, 'gastroenterologická chirurgia', true, now() ),(223, 'neuropsychiatria', true, now() ),(225, 'laboratórna medicína', true, now() ),(226, 'tropická medicína', true, now() ),(227, 'verejné zdravotníctvo', true, now() ),(229, 'onkológia v gynekológii', true, now() ),(231, 'psychosomatická a behaviorálna medicína', true, now() ),(247, 'ultrazvuk v gynekológii a pôrodníctve', true, now() ),(258, 'špeciálne laboratórne a diagnostické metódy v hematológii a transfúziológii', true, now() ),(271, 'mamológia', true, now() ),(289, 'reprodukčná medicína', true, now() ),(299, 'akupunktúra', true, now() ),(302, 'andrológia', true, now() ),(306, 'klinické pracovné lekárstvo a klinická toxikológia', true, now() ),(312, 'gynekologická urológia', true, now() ),(319, 'onkológia v chirurgii', true, now() ),(322, 'onkológia v urológii', true, now() ),(323, 'pediatrická anestéziológia', true, now() ),(329, 'pediatrická hematológia a onkológia', true, now() ),(331, 'pediatrická infektológia', true, now() ),(332, 'pediatrická intenzívna medicína', true, now() ),(334, 'paliatívna medicína', true, now() ),(336, 'pediatrická oftalmológia', true, now() ),(340, 'sexuológia', true, now() ),(341, 'pediatrická urgentná medicína', true, now() ),(353, 'zdravotnícka ekológia', true, now() ),(356, 'revízne lekárstvo', true, now() ),(366, 'preventívne pracovné lekárstvo a toxikológia', true, now() ),(367, 'psychiatrická sexuológia', true, now() ),(377, 'služby zdravia pri práci', true, now() ),(16, 'stomatológia', true, now() ),(53, 'čeľustná ortopédia', true, now() ),(115, 'detské zubné lekárstvo', true, now() ),(361, 'revízne zubné lekárstvo', true, now() ),(803, 'farmácia – vysokoškolské magisterské štúdium', true, now() ),(119, 'diagnostické zdravotnícke pomôcky in vitro', true, now() ),(122, 'technológia rádiofarmák', true, now() ),(125, 'farmakológioa a technológia liečiv', true, now() ),(157, 'farmaceutická kontrola a zabezpečovanie kvality liekov', true, now() ),(158, 'farmaceutická technológia', true, now() ),(159, 'klinická farmácia', true, now() ),(160, 'lekárenstvo', true, now() ),(363, 'klinické skúšanie produktov a liekov', true, now() ),(364, 'príprava cytostatík', true, now() ),(371, 'revízne lekárenstvo', true, now() ),(375, 'zabezpečovanie kvality transfúznych liekov', true, now() ),(411, 'odborník na riadenie vo verejnom zdravotníctve master of public health', true, now() ),(497, 'sociálna farmácia a organizácia zdravotníctva', true, now() ),(589, 'farmakoekonomika', true, now() ),(161, 'sestra', true, now() ),(193, 'ošetrovateľstvo – bakalárske štúdium', true, now() ),(804, 'ošetrovateľstvo', true, now() ),(805, 'diplomovaná všeobecná sestra', true, now() ),(240, 'ošetrovateľstvo v zdraví pri práci', true, now() ),(242, 'revízne ošetrovateľstvo', true, now() ),(325, 'anestéziológia a intenzívna starostlivosť', true, now() ),(243, 'operačné stredisko záchrannej zdravotnej služby', true, now() ),(244, 'intenzívna ošetrovateľská starostlivosť o dospelých', true, now() ),(245, 'intenzívna ošetrovateľská starostlivosť v pediatrii', true, now() ),(246, 'intenzívna ošetrovateľská starostlivosť v neonatológii', true, now() ),(129, 'inštrumentovanie v operačnej sále', true, now() ),(248, 'ošetrovateľská starostlivosť o dialyzovaných pacientov', true, now() ),(249, 'ošetrovateľská starostlivosť v odboroch vnútorného lekárstva', true, now() ),(250, 'ošetrovateľská starostlivosť v odboroch chirurgie', true, now() ),(251, 'ošetrovateľská starostlivosť v pediatrii', true, now() ),(252, 'ošetrovateľská starostlivosť v psychiatrii', true, now() ),(253, 'ošetrovateľská starostlivosť v komunite', true, now() ),(254, 'ošetrovateľská starostlivosť v onkológii', true, now() ),(255, 'špecializovaná urgentná starostlivosť', true, now() ),(557, 'audiometria', true, now() ),(558, 'endoskopické vyšetrovacie metódy v jednotlivých odboroch', true, now() ),(559, 'funkčné vyšetrovacie metódy', true, now() ),(560, 'invazívne a intervenčné diagnostické a terapeutické metódy', true, now() ),(561, 'kalmetizácia', true, now() ),(562, 'kardiologické vyšetrovacie metódy', true, now() ),(565, 'ošetrovateľská starostlivosť o diabetikov', true, now() ),(566, 'ošetrovateľská starostlivosť v multikultúrnych komunitách', true, now() ),(564, 'organizácia a techniky v tkanivových bunkách', true, now() ),(563, 'organizácia a riadenie starostlivosti o zdravotnícke pomôcky', true, now() ),(568, 'starostlivosť o drogovo závislých', true, now() ),(569, 'vyšetrovacie metódy v klinickej neurofyziológii a neurodiagnostike', true, now() ),(241, 'psychoterapia', true, now() ),(496, 'manažment v ošetrovateľstve', true, now() ),(605, 'pôrodná asistentka', true, now() ),(806, 'pôrodná asistencia', true, now() ),(807, 'diplomovaná pôrodná asistentka', true, now() ),(256, 'intenzívna starostlivosť v gynekológii a pôrodníctve', true, now() ),(224, 'inštrumentovanie v operačnej sále v gynekológii a pôrodníctve', true, now() ),(257, 'pôrodná asistencia a starostlivosť o ženu v rodine a komunite', true, now() ),(570, 'plánované rodičovstvo a antikoncepcia', true, now() ),(492, 'manažment v pôrodnej asistencii', true, now() ),(666, 'technik laboratórnej medicíny', true, now() ),(667, 'medicínsko', true, now() ),(808, 'laboratórne vyšetrovacie metódy – vysokoškolské magisterské štúdium', true, now() ),(809, 'diplomovaný medicínsko', true, now() ),(810, 'zdravotnícky laborant – úplné stredné odborné štúdium', true, now() ),(811, 'farmaceutický laborant – úplné stredné odborné štúdium', true, now() ),(493, 'manažment v odboroch kategórie laborant', true, now() ),(239, 'laboratórne a diagnostické metódy v klinickej genetike', true, now() ),(259, 'laboratórne a diagnostické metódy v hematológii a transfúziológii', true, now() ),(262, 'vyšetrovacie metódy v klinickej mikrobiológii', true, now() ),(266, 'vyšetrovacie metódy v klinickej genetike', true, now() ),(269, 'laboratórne a diagnostické metódy v klinickej biochémii', true, now() ),(313, 'laboratórne a diagnostické metódy v klinickej mikrobiológii', true, now() ),(314, 'laboratórne a diagnostické metódy v biológii životného prostredia', true, now() ),(315, 'laboratórne a diagnostické metódy v mikrobiológii životného prostredia', true, now() ),(320, 'laboratórne a diagnostické metódy v oblasti fyzikálnych a chemických analýz a faktorov', true, now() ),(324, 'vyšetrovacie metódy v klinickej biochémii', true, now() ),(346, 'laboratórne a diagnostické metódy v klinickej imunológii a alergológii', true, now() ),(333, 'vyšetrovacie metódy v chemickej a fyzikálnej analýze v hygiene', true, now() ),(260, 'vyšetrovacie metódy v mikrobiológii a biológii životného prostredia', true, now() ),(261, 'vyšetrovacie metódy v klinickej cytológii', true, now() ),(263, 'vyšetrovacie metódy v toxikológii a farmakológii', true, now() ),(294, 'vyšetrovacie metódy v histopatológii', true, now() ),(265, 'vyšetrovacie metódy v ochrane zdravia pred ionizujúcim žiarením', true, now() ),(814, 'diplomovaný rádiologický asistent – vyššie odborné štúdium', true, now() ),(815, 'diplomovaný zdravotnícky záchranár – vyššie odborné štúdium', true, now() ),(816, 'diplomovaná dentálna hygienička – vyššie odborné štúdium', true, now() ),(817, 'asistent výživy – úplné stredné odborné štúdium', true, now() ),(818, 'masér – úplné stredné odborné štúdium', true, now() ),(819, 'zdravotnícky asistent – úplné stredné odborné štúdium', true, now() ),(820, 'zdravotnícky záchranár', true, now() ),(674, 'rádiologický asistent', true, now() ),(675, 'zdravotnícky záchranár', true, now() ),(680, 'sanitár – stredné odborné štúdium', true, now() ),(679, 'zdravotnícky asistent', true, now() ),(821, 'sanitár – stredné odborné štúdium', true, now() ),(343, 'špeciálna rádiológia', true, now() ),(574, 'digitálna substrakčná angiografia', true, now() ),(575, 'mamografia', true, now() ),(576, 'počítačová tomografia', true, now() ),(272, 'liečebná výživa', true, now() ),(494, 'manažment v odboroch kategórie asistent', true, now() ),(685, 'fyzioterapeut', true, now() ),(827, 'rehabilitácia – vysokoškolské magisterské štúdium', true, now() ),(844, 'fyzioterapia – vysokoškolské bakalárske štúdium', true, now() ),(846, 'diplomovaný fyzioterapeut – vyššie odborné štúdium', true, now() ),(273, 'fyzioterapia porúch psychomotorického vývoja', true, now() ),(274, 'fyzioterapia funkčných a štrukturálnych porúch pohybového systému', true, now() ),(275, 'fyzioterapia porúch CNS', true, now() ),(276, 'fyzioterapia v športe a telovýchove', true, now() ),(277, 'ergonomika a rehabilitačné inžinierstvo', true, now() ),(278, 'fyzioterapia vybraných ochorení pohybového systému', true, now() ),(288, 'fyzioterapia respiračných ochorení', true, now() ),(282, 'fyzioterapia psychosomatických a civilizačných ochorení', true, now() ),(135, 'ergoterapia', true, now() ),(581, 'mobilizačné techniky', true, now() ),(582, 'reflexná terapia podľa Vojtu', true, now() ),(583, 'techniky terapie lymfedému', true, now() ),(291, 'liečebná rehabilitácia a fyzioterapia porúch vybraných systémov', true, now() ),(525, 'klinická psychofyziológia (neurofeedback a biofeedback)', true, now() ),(829, 'psychológia – vysokoškolské magisterské štúdium', true, now() ),(144, 'klinická psychológia', true, now() ),(295, 'poradenská psychológia', true, now() ),(296, 'pracovná a organizačná psychológia', true, now() ),(297, 'školská psychológia', true, now() ),(578, 'drogové závislosti', true, now() ),(580, 'dopravná psychológia', true, now() ),(828, 'logopédia – vysokoškolské magisterské štúdium', true, now() ),(141, 'klinická logopédia', true, now() ),(577, 'afaziológia', true, now() ),(499, 'manažment v príslušnom odbore', true, now() ),(830, 'liečebná pedagogika – vysokoškolské magisterské štúdium', true, now() ),(831, 'špeciálna pedagogika – vysokoškolské magisterské štúdium', true, now() ),(143, 'liečebná pedagogika', true, now() ),(142, 'špeciálna pedagogika', true, now() ),(843, 'sociálna práca – vysokoškolské magisterské štúdium', true, now() ),(283, 'sociálna práca v zdravotníctve', true, now() ),(832, 'biomedicínska fyzika – vysokoškolské inžinierske štúdium', true, now() ),(833, 'biológia so zameraním na bunkovú a molekulárnu biológiu – vysokoškolské inžinierske štúdium', true, now() ),(834, 'biológia so zameraním na fyziológiu živočíchov a človeka – vysokoškolské inžinierske štúdium', true, now() ),(835, 'fyzika so zameraním na biofyziku a chemickú fyziku – vysokoškolské inžinierske štúdium', true, now() ),(836, 'chémia so zameraním na biochémiu – vysokoškolské inžinierske štúdium', true, now() ),(837, 'biotechnológia – vysokoškolské inžinierske štúdium', true, now() ),(838, 'hygiena potravín – vysokoškolské inžinierske štúdium', true, now() ),(839, 'biochémia a biotechnológia – vysokoškolské inžinierske štúdium', true, now() ),(840, 'chémia a technológia životného prostredia', true, now() ),(841, 'biomedicínske inžinierstvo– vysokoškolské inžinierske štúdium', true, now() ),(842, 'výživa ľudí', true, now() ),(845, 'potravinárstvo – biochémia', true, now() ),(853, 'fyzika so zameraním na lekársku fyziku alebo na dozimetriu – vysokoškolské inžinierske štúdium', true, now() ),(854, 'chémia so zameraním na kvasnú chémiu – vysokoškolské inžinierske štúdium', true, now() ),(847, 'chémia – chémia liečiv – úplné stredné odborné štúdium', true, now() ),(848, 'chémia – analytická chémia – úplné stredné odborné štúdium', true, now() ),(849, 'chémia – monitorovanie životného prostredia – úplné stredné odborné štúdium', true, now() ),(850, 'chémia – sanácia životného prostredia – úplné stredné odborné štúdium', true, now() ),(851, 'chemická technológia– úplné stredné odborné štúdium', true, now() ),(280, 'hygiena pracovných podmienok', true, now() ),(146, 'klinická fyzika', true, now() ),(133, 'vyšetrovacie metódy v patológii a súdnom lekárstve', true, now() ),(286, 'vyšetrovacie metódy v preventívnom pracovnom lekárstve a toxikológii', true, now() ),(287, 'vyšetrovacie metódy v hygiene životného prostredia', true, now() ),(316, 'vyšetrovacie metódy v oblasti fyzikálnych a chemických analýz a faktorov', true, now() ),(186, 'vedúci centrálnej sterilizácie', true, now() ),(184, 'vedúci centrálneho príjmu', true, now() );

-- Patients
insert into patient(username,account_non_expired,account_non_locked,credentials_non_expired,email,enabled,first_name,password,phone,surname,updated) VALUES('admin',true,true,true,'admin@easycare.sk',true,'Admin','1000:670cf1510ec7137f59a409c5c3af8533f34a93496e4c77a5:4c1ca5b461e019c831ec38da6a9e4c3086fc158136b6c1ee','+42108080808','Admin',now());

-- Authorities
insert into patient_authorities(username, authority) VALUES ('admin','ADMIN');

-- Facilities
insert into facility(city,street_and_number,zip,enabled,name) VALUES('Bratislava','Mickiewiczova 13','81369',true,'Nemocnica Staré Mesto');
insert into facility(city,street_and_number,zip,enabled,name) VALUES('Bratislava','Hlboká 7','81104',false,'1. ortopedická klinika');