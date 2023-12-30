
package apps;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import antlr.ArrayInitLexer; 
import antlr.ArrayInitParser;

import expression.ShortintToUnicodeString;

public class Translator {
    public static void main(String[] args) throws Exception {
        // charstream 
        String fileName = args[0];
        CharStream input = CharStreams.fromFileName(fileName);
        // lexer
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        // tokenstream 
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // parser 
        ArrayInitParser parser = new ArrayInitParser(tokens);
        //parse tree
        ParseTree tree = parser.init();

        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(new ShortintToUnicodeString(), tree); 

        System.out.println();


    }
}
