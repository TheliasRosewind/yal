#!/usr/bin/env bash

rm -r assets/MIPS/*

find assets/ -name "*.mips" -type f -delete

cd YalActuel/src/analyse/

java -jar /opt/depot/projetToucan/java-cup-11a.jar -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup

java -jar /opt/depot/projetToucan/jflex-1.6.1.jar AnalyseurLexical.jflex

cd ../../..

ant -buildfile yal.xml

for filename in `find assets/yal/ -name "*.yal" -type f`; do
    java -cp out/production/YalActuel/:/opt/depot/projetToucan/java-cup-11a.jar:/opt/depot/projetToucan/jflex-1.6.1.jar Yal "$filename"
done

mkdir `find assets/yal/ -type d -name "*" | sed -e 's/^assets\/yal\/$//' | sed -e 's/yal\//MIPS\//g' | sed '/^$/d'`

mv `find assets/yal/ -type f -name "*.mips" | sed -e 's/^.\///'` `find assets/yal/ -type f -name "*.mips" | sed -e 's/yal\//MIPS\//g' | sed -e 's/\/[a-zA-Z1-9]*.mips//'`