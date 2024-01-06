package apps;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import antlr.PropertiesLexer;
import antlr.PropertiesParser;

import expression.PropertiesLoader;

public class TestVisitor{
    public static void main(String[] args) throws Exception {
        // charstream 
        String fileName = args[0];
        CharStream input = CharStreams.fromFileName(fileName);
        // lexer
        PropertiesLexer lexer = new PropertiesLexer(input);
        // tokenstream 
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // parser 
        PropertiesParser parser = new PropertiesParser(tokens);
        ParseTree tree = parser.file();

        PropertiesLoader loader = new PropertiesLoader();
        // ParseTreeWalker walker = new ParseTreeWalker();
        // walker.walk(loader, tree);
        loader.visit(tree); //visitor 不需要ParseTreeWalker

        System.out.println(loader.getProps());
    }
}
