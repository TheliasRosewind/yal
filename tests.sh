#!/usr/bin/env bash

cd YalActuel/src/analyse/

java -jar /opt/depot/projetToucan/java-cup-11a.jar -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup

java -jar /opt/depot/projetToucan/jflex-1.6.1.jar AnalyseurLexical.jflex

cd ../../..

ant -buildfile yal.xml

java -cp out/production/YalActuel/:/opt/depot/projetToucan/java-cup-11a.jar:/opt/depot/projetToucan/jflex-1.6.1.jar Yal assets/test2.yal
