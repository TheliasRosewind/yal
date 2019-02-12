# Yal (*Yet Another Language*) #
Le langage YAL est un langage de programmation typé rudimentaire incluant les variables entières, les tableaux, les structures
de contrôle élémentaires et les fonctions.

## Commencer ##
### Prérequis ###
Vous devez avoir téléchargé les bibliothèques [JFlex](http://www.jflex.de/) et [Java CUP](http://www2.cs.tum.edu/projects/cup/) (voir section des [Outils utilisés](#outils-utilisés)).

### Installation sous [IntelliJ](https://www.jetbrains.com/idea/) ###

Lancer [IntelliJ](https://www.jetbrains.com/idea/), puis choisir *Check out from Version Control* puis *Git*. Remplissez la case URL avec l'adresse SSH ([git@github.com:TheliasRosewind/yal.git]()) ou l'adresse HTTPS (https://github.com/TheliasRosewind/yal.git).
Une fois le projet cloné et ouvert, allez dans *File > Project Structure*.
- Dans l'onglet *Libraries*, ajoutez les archives `.jar` de [JFlex](http://www.jflex.de/) et [Java CUP](http://www2.cs.tum.edu/projects/cup/).
- Dans l'onglet *Modules*, ajoutez les modules [`yal`](/) (il est recommandé d'exclure le dossier [`Versions`](Versions/) des sources du projet, via l'onglet *Sources*) et [`YalActuel`](YalActuel/), puis vérifiez que les librairies [JFlex](http://www.jflex.de/) et [Java CUP](http://www2.cs.tum.edu/projects/cup/) sont bien présentes dans l'onglet *Dependencies* du module [`YalActuel`](YalActuel/).

### Configuration de l'exécution ###
- **Ant Build (Linux uniquement)**

    Allez dans *Build > Generate Ant Build*. Cochez les cases *Generate single-file ant build*, *Overwrite previously generated files* et *Use JDK definitions from project files*. Vérifiez que le reste est bien décoché, puis `OK`. Ouvrez l'onglet *Ant Build*, et ajoutez  le fichier `yal.xml` tout juste créé.
- **Run (si vous n'utilisez pas Ant Build)**

    Allez dans *Run > Edit Configurations*. Ajoutez une configuration en choississant *Application*. Nommez la `Yal`, et choississez la classe principale [`Yal`](YalActuel/src/Yal.java) du module [`YalActuel`](YalActuel/). Dans *Program arguments*, entrez le nom du fichier `.yal` que vous souhaitez compiler en MIPS et choississez en *Working directory* le dossier [`yal/assets`](assets/) (dans lequel sont placé les fichiers `.yal`).
- **Artifact JAR (si vous n'utilisez ni Run, ni Ant Build)**

    Pour générer une archive exécutable, allez dans *File > Project Structure* puis dans l'onglet *Artifacts*. Ajoutez un *JAR* en choississant *From modules with dependencies*. Mettez [`YalActuel`](YalActuel/) en *Module* et [`Yal`](YalActuel/src/Yal.java) en *Main class*, puis `OK`. Remplacez le contenu de la case *Name*, par `yal:jar`, et modifiez le nom de l'exécutable en `yal.jar` (dans l'onglet *Output Layout*). Remplissez la case *Class Path* avec `.`, puis `OK`.
***
## Lancer les tests ##
- **Ant Build**
    
    Vous n'avez qu'à utiliser la commande `./tests.sh` dans le dossier [`yal`](/).
- **Run et Artifact JAR**

    Vous devrez exécuter systématiquement les commandes suivantes dans le package [`analyse`](YalActuel/src/analyse/) (si vous n'avez que les fichiers [`AnalyseurLexical.jflex`](YalActuel/src/analyse/AnalyseurLexical.jflex) et [`Grammaire.cup`](YalActuel/src/analyse/Grammaire.cup) à l'intérieur et/ou que vous les avez modifiés) :
    ```
    java -jar [archive jar Java CUP] -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup
    java -jar [archive jar JFlex] AnalyseurLexical.jflex
    ```
    en remplaçant [archive jar Java CUP] et [archive jar JFlex] par le chemin vers les archives [Java CUP](http://www2.cs.tum.edu/projects/cup/) et [JFlex](http://www.jflex.de/) stockées sur votre ordinateur.
    - **_Run_**
    
        Vous pourrez ensuite lancer le programme via le bouton *Run* après l'avoir compilé (via le bouton *Build*).
    - **_Artifact JAR_**
    
        Allez dans *Build > Build Artifacts*, puis faites *Build* (ou *Rebuild*) sur `yal:jar`.
        Exécutez ensuite la commande suivante à partir du dossier [`yal`](/) :
        ```
        java -jar out/artifacts/yal_jar/yal.jar assets/[nom fichier test].yal
        ```
        en remplaçant [nom fichier test] par le nom d'un fichier `.yal` présent dans le dossier [`assets`](assets/).

Les fichiers MIPS générés sont disponilbles dans le dossier [`assets`](assets/) et portent le même nom que le fichier `.yal` d'origine.
***
## Outils utilisés ##
* [IntelliJ](https://www.jetbrains.com/idea/) - IDE de développement
* [Java](https://docs.oracle.com/javase/7/docs/api/) - Langage utilisé
* [Java CUP](http://www2.cs.tum.edu/projects/cup/) - Bibliothèque de génération d'analyseur syntaxique
* [JFlex](http://www.jflex.de/) - Bibliothèque de génération d'analyseur lexical
***
## Versionnage ##
Les anciennes versions du projet sont disponibles dans le dossier [Versions](Versions/) puis dans les dossiers YalX (X étant un numéro de version et commençant à 0).
***
## Auteurs ##
* **Brigitte Wrobel-Dautcourt** - *Sources du projet*
* **Thelias Rosewind** - *Développement*
* **Cottens** - *Développement*
* **Sechsyo** - *Développement*
***
## À faire ##
- [x] README détaillé
- [ ] Documentation du langage yal
- [ ] Description des différentes versions
- [ ] Ajout de plus de fichiers tests
- [ ] Documentation du code