grammar tinyc; 

@header {package antlr; }

file
   : (functionDecl | varDecl)+ ; //one program includes at least one function or one var declaration

varDecl
   : type ID ('=' expr)? ';'
   ; 

functionDecl
   : type ID '(' formalParameters? ')' block 
   ; 

formalParameters
   : formalParameter (',' formalParameter)*
   ; 

formalParameter
   : type ID
   ; 

type
   : 'float' 
   | 'int'
   | 'half'
   | 'void'
   ; 

block
   : '{' stat* '}'
   ; 

stat
   : block
   | varDecl
   | ifstat
   | whilestat
   | assignstat
   | funccallstat
   | returnstat
   ; 

ifstat
   : 'if'  expr  '{' stat+ '}' ('else' '{' stat+ '}')?
   ;

whilestat
   : 'while' expr '{' stat '}'
   ;

assignstat
   : expr '=' expr ';'
   ; 

funccallstat
   : expr
   ;


returnstat
   : 'return' expr? ';'
   ;
   
//: ID '(' exprList? ')' # Call   // f() f(x) f(x,y)

expr
   : ID '(' exprList? ')' ';'?  #Call  // f() f(x) f(x,y)
   | expr '[' expr ']' # Index  //array index a[i], a[i][j]
   | '-' expr # Negate // -5
   | '!' expr # Not // boolean not
   | '(' expr ')' # Parens 
   | expr '*' expr  # Mult 
   | expr '/' expr  # Div 
   | expr '+' expr  # Add
   | expr '-' expr  # Sub 
   | expr '==' expr  # IsEqual
   | ID   # Var 
   | INT  # Int
   ; 

exprList
   : expr (',' expr)*
   ;

ID
   : [a-zA-Z]+
   ;

INT 
   : [0-9]+;

WS 
   : [\n\r ]+ -> skip;
