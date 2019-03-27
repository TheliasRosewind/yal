package analyse ;

import java_cup.runtime.*;
import exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{

  private StringBuilder chaine ;

  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

idf = [A-Za-z_][A-Za-z_0-9]*

csteE = [0-9]+
commentaire = [/][/].*

finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

%%

"programme"            { return symbol(CodesLexicaux.PROGRAMME); }
"debut"                { return symbol(CodesLexicaux.DEBUT); }
"fin"              	   { return symbol(CodesLexicaux.FIN); }
"fonction"             { return symbol(CodesLexicaux.FONCTION); }
"retourne"             { return symbol(CodesLexicaux.RETOURNE); }

"ecrire"               { return symbol(CodesLexicaux.ECRIRE); }

","                    { return symbol(CodesLexicaux.VIRGULE); }
";"                    { return symbol(CodesLexicaux.POINTVIRGULE); }

"="                    { return symbol(CodesLexicaux.EGAL); }
"+"                    { return symbol(CodesLexicaux.PLUS); }
"-"                    { return symbol(CodesLexicaux.MOINS); }
"*"                    { return symbol(CodesLexicaux.MULT); }
"/"                    { return symbol(CodesLexicaux.DIV); }
"=="                   { return symbol(CodesLexicaux.EGALEGAL); }
"!="                   { return symbol(CodesLexicaux.DIFF); }
"<"                    { return symbol(CodesLexicaux.INF); }
">"                    { return symbol(CodesLexicaux.SUPP); }
"et"                   { return symbol(CodesLexicaux.ET); }
"ou"                   { return symbol(CodesLexicaux.OU); }
"si"                   { return symbol(CodesLexicaux.SI); }
"alors"                { return symbol(CodesLexicaux.ALORS); }
"sinon"                { return symbol(CodesLexicaux.SINON); }
"finsi"                { return symbol(CodesLexicaux.FINSI); }
"non"                  { return symbol(CodesLexicaux.NON); }
"("                    { return symbol(CodesLexicaux.POUV); }
")"                    { return symbol(CodesLexicaux.PFER); }
"["                    { return symbol(CodesLexicaux.COUV); }
"]"                    { return symbol(CodesLexicaux.CFER); }

"tantque"              { return symbol(CodesLexicaux.TANTQUE); }
"repeter"              { return symbol(CodesLexicaux.REPETER); }
"fintantque"           { return symbol(CodesLexicaux.FINTANTQUE); }

"entier"               { return symbol(CodesLexicaux.TYPE, yytext()); }

"lire"                 { return symbol(CodesLexicaux.LIRE); }

{commentaire}          { }

{csteE}      	       { return symbol(CodesLexicaux.CSTENTIERE, yytext()); }

{idf}      	           { return symbol(CodesLexicaux.IDF, yytext()); }

{espace}               { }

.                      { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }

