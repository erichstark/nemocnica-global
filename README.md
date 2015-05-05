Global Server - Timovy projekt
=============================
- `application.properties` je smerodajny subor
- nastaveny port 8180

Priprava localhostu
-------------------
- Gradle
 - nainstalovat GVM: curl -s get.gvmtool.net | bash
 - naistalovat Gradle: gvm install gradle
- v pripade, ze chcete pouzit maven, tak si spravit pom ako klon gradle configu
- PostgreSQL - localhost, 5432, DB: postgres, user: postgres, password: postgres, schema: global

Spustenie na localhoste
-----------------------

- Najprv spravit `gradle bootRun`
- Nie je potrebna ziadna dalsia instalacia
- pokial chcete nejake cistenie, alebo len build, tak `gradle clean`, `gradle build`

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
