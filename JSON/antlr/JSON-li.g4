grammar JSON;
@header{ package antlr;}


json: object 
    | array
    ; 

object: '{' pair (',' pair)* '}'
      | '{' '}'
      ; 
pair: STRING ':' value;

array: '[' value (',' value)* ']'
      | '[' ']'
      ;
  


value: STRING
     | NUMBER
     | object 
     | array 
     | 'true'
     | 'false'
     | 'null'
     ;

STRING: '"' (ESC|~["\\])* '"';

// framgent ESC: '\\'(["\\/bfnrt]|UNICODE);
fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE: 'u' HEX HEX HEX HEX;
fragment HEX: [0-9a-fA-F];

NUMBER
: '-'? INT '.' INT EXP? // 1.34 1.35E-9 -4.5
| '-'? INT EXP //1e10 -3e4
| '-'? INT //-3, 45
;

fragment INT: '0'|[1-9][0-9]*;
fragment EXP: [Ee][+\-]?INT;
WS: [\t\n\r]+ -> skip;
