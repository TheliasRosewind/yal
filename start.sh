#!/usr/bin/env bash

rm -r assets/MIPS/*

cd YalActuel/src/analyse/

java -jar /opt/depot/projetToucan/java-cup-11a.jar -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup

java -jar /opt/depot/projetToucan/jflex-1.6.1.jar AnalyseurLexical.jflex

cd ../../..

ant -buildfile yal.xml

for filename in `find assets/yal/ -name "*.yal" -type f`; do
    echo " "
    echo "$filename" | sed -e 's/^assets\/yal\///'
    java -cp out/production/YalActuel/:/opt/depot/projetToucan/java-cup-11a.jar:/opt/depot/projetToucan/jflex-1.6.1.jar Yal "$filename"
    sleep 0.001
done

for filename in `find assets/yal/ -name "*.mips" -type f`; do
    mkdir -p `echo "$filename" | sed -e 's/yal\//MIPS\//g' | sed -e 's/\/[a-zA-Z1-9(-)]*.mips//'`
    mv "$filename" `echo "$filename" | sed -e 's/yal\//MIPS\//g'`
done