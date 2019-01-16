# Projet Compilation

## Commandes utiles
* Refaire l'analyseur syntaxique
java -jar /opt/depot/projetToucan/java-cup-11a.jar -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup

* Refaire l'analyseur lexical
java -jar /opt/depot/projetToucan/jflex-1.6.1.jar AnalyseurLexical.jflex