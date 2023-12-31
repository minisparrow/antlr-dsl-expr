grammar RowEyes;
import CommonLexerRules;

@header {package antlr;}

@parser::members {
    int col; 
    public RowEyesParser(TokenStream input, int col) {
        this(input);
        this.col = col; 
    }
}

file: (row)+
    ; 

row
locals [int i] 
: (STUFF 
    {
        $i++;
        if($i == col) 
        {
            System.out.println($STUFF.text);
        }
    })+ NEWLINE
    ;

// row : STUFF+ ;
TAB: '\t' -> skip;
NEWLINE: '\r'? '\n';
//STUFF: ~[\t\r\n]+;
STUFF: ID 
     | INT
     ;