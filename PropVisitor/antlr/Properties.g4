
grammar Properties; 

@header {package antlr;}

file :  prop+;

prop : ID '=' STRING '\n'; 

ID : [a-zA-Z]+;
STRING : '"' ('""'|~'"')* '"';
WS : [\t\n\r ]+ -> skip;
