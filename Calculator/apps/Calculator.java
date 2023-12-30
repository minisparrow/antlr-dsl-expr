
package apps;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import antlr.CalculatorLexer; 
import antlr.CalculatorParser;

public class Calculator{
    public static void main(String[] args) throws Exception {
        // charstream 
        String fileName = args[0];
        CharStream input = CharStreams.fromFileName(fileName);
        // lexer
        CalculatorLexer lexer = new CalculatorLexer(input);
        // tokenstream 
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // parser 
        CalculatorParser parser = new CalculatorParser(tokens);
        //parse tree
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }
}
