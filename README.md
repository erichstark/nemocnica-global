Global Server - Timovy projekt
=============================

Priprava localhostu
-------------------
- je potrebna enviroment premenna `DATABASE_URL` - `DATABASE_URL=postgres://postgres:postgres@localhost:5432/postgres`
- databaza `postgres` a uzivatel `postgres`, musi byt prava!

Spustenie na localhoste
-----------------------

- Najprv spravit `mvn clean package`
- Potom sa server pusta runnerom: `java -jar target/dependency/jetty-runner.jar target/*.war`
- Nie je potrebna ziadna dalsia instalacia

Heroku
------

- Autodeploy je nastaveny na *master* branch
- Build a deploy trva od par sec do minuty
- logy je mozne si pozriet (je potrebne mat heroku toolbelt):
 - prikaz `heroku login` a prihlasenie s nemocnica.openshift@gmail.com a heslo
 - prikaz `heroku logs -n 500 --app nemocnica-global` - prepinac n je na pocet riadkov, max. 1500

Git Flow
--------

- http://danielkummer.github.io/git-flow-cheatsheet/
