# Squelete de webapp (Spring Boot / appli JS)

![Dev-Mind](dm-client/app/images/logo_new.png)

Ce projet est là pour illustrer l'article sur le même sujet sur le blog [http://javamind-fr.blogspot.fr/](http://javamind-fr.blogspot.fr/).

En gros je partage ce starter qui m'aide à initier une webapp Spring Boot. Il existe plusieurs stratégies pour intégrer une application web à une application. Personnellement je préfère développer les écrans web dans un module séparer et utiliser Spring Dev Tools pour optimiser l'expérience de développement et recharger automatiquement ma webapp sans avoir à redémarrer sans cesse un serveur quelconque.

Dans cet exemple la partie client utilise le kit Google Web Start permettant d'avoir une progressive webapp sans effort. La partie JS est écrite en ES6 et je lance un script gulp
```
gulp watch
```

Ce script permet de scrupter les ressources et les compiler si nécéssaires (transformation Sass to Css et transformation ES6 to ES5).

Le serveur web est en fait le serveur d'application associé à la webapp Spring. Et si vous voulez en savoir plus rendez vous sur le blog [http://javamind-fr.blogspot.fr/](http://javamind-fr.blogspot.fr/).
