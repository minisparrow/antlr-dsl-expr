
package apps;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import antlr.CSVLexer; 
import antlr.CSVParser;
import listeners.Loader;

public class LoadCSVApp {
    public static void main(String[] args) throws Exception {
        // charstream 
        String fileName = args[0];
        CharStream input = CharStreams.fromFileName(fileName);
        // lexer
        CSVLexer lexer = new CSVLexer(input);
        // tokenstream 
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // parser 
        CSVParser parser = new CSVParser(tokens);
        //parse tree
        ParseTreeWalker walker = new ParseTreeWalker();
        ParseTree tree = parser.file();
        Loader loader = new Loader();
        walker.walk(loader, tree);
        System.out.println(loader.getRows());
    }
}
