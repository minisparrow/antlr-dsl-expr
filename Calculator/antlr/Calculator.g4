grammar Calculator; 
import CommonLexerRules;

@header {package antlr;}

prog: stat+
    ; 

stat: expr NEWLINE
    | ID '=' expr NEWLINE
    | NEWLINE
    ; 

expr: expr '*' expr 
    | expr '/' expr 
    | expr '+' expr 
    | expr '-' expr 
    | INT
    | ID 
    | '(' expr ')'
    ;