#!/usr/bin/env bash

rm assets/*.mips

cd YalActuel/src/analyse/

java -jar /opt/depot/projetToucan/java-cup-11a.jar -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup

java -jar /opt/depot/projetToucan/jflex-1.6.1.jar AnalyseurLexical.jflex

cd ../../..

ant -buildfile yal.xml

for filename in assets/*.yal; do
    java -cp out/production/YalActuel/:/opt/depot/projetToucan/java-cup-11a.jar:/opt/depot/projetToucan/jflex-1.6.1.jar Yal "$filename"
done
