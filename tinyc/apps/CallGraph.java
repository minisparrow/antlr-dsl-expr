package apps;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import antlr.tinycLexer;
import antlr.tinycParser;

import listeners.FunctionListener;
import graph.Graph;

public class CallGraph{
  public static void main(String[] args) throws Exception {
    // charstream 
    String fileName = args[0];
    CharStream input = CharStreams.fromFileName(fileName);
    // lexer
    tinycLexer lexer = new tinycLexer(input);
    // tokenstream 
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    // parser 
    tinycParser parser = new tinycParser(tokens);
    ParseTree tree = parser.file();

    FunctionListener collector = new FunctionListener();
    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(collector, tree);

    System.out.println(collector.graph.toDot());
    String dotString =  collector.graph.toDot(); 
    collector.graph.drawDot(dotString);
  }
}
