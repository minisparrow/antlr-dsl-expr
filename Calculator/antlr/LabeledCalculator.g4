grammar LabeledCalculator; 
import CommonLexerRules;

@header {package antlr;}

prog: stat+
    ; 

stat: expr NEWLINE         # printExpr
    | ID '=' expr NEWLINE  # assign
    | NEWLINE              # blank
    ; 

expr: expr '*' expr        # Mul
    | expr '/' expr        # Div 
    | expr '+' expr        # Add
    | expr '-' expr        # Minus
    | INT                  # int  
    | ID                   # id
    | '(' expr ')'         # parens
    ;