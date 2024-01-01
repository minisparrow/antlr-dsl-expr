
grammar CSV;

@header {package antlr;}

file: header row+; 

header: row; 

row: field (','  field)* '\r'? '\n'; 

field: TEXT
    | STRING
    |
    ; 


TEXT: ~[,\r\n]+; // one or more none , or none \r or none \n
STRING: '"'  ('""'|~'"')* '"';