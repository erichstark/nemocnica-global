Local Server - Timovy projekt
=============================

Spustenie na localhoste
-----------------------

- Najprv spravit `mvn clean package`
- Potom sa server pusta runnerom: `java -jar target/dependency/jetty-runner.jar target/*.war`
- Nie je potrebna ziadna dalsia instalacia

Heroku autodeploy
-----------------

- Je nastaveny na *master* branch
- Build a deploy trva od par sec do minuty
