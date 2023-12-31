package apps;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import antlr.RowEyesLexer; 
import antlr.RowEyesParser;

public class RowEyes{
    public static void main(String[] args) throws Exception {
        // charstream 
        String fileName = args[0];
        int col = Integer.valueOf(args[1]);
        System.out.println(col);
        CharStream input = CharStreams.fromFileName(fileName);
        // lexer
        RowEyesLexer lexer = new RowEyesLexer(input);
        // tokenstream 
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // parser 
        RowEyesParser parser = new RowEyesParser(tokens, col);
        //parse tree
        parser.setBuildParseTree(false);
        parser.file();
        //ParseTree tree = parser.file();
    }
}
