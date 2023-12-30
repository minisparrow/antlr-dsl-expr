grammar ArrayInit; 

@header {  package antlr; }

init: '{' value (',' value)* '}';

value: init | INT; 

INT: [0-9]+; 

WS: [ \t\r\n]+ -> skip; 
