Global Server - Timovy projekt
=============================

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
