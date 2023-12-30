
package apps;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import antlr.LabeledCalculatorLexer; 
import antlr.LabeledCalculatorParser;
import expression.EvalVisitor;

public class LabeledCalculator{
    public static void main(String[] args) throws Exception {
        // charstream 
        String fileName = args[0];
        CharStream input = CharStreams.fromFileName(fileName);
        // lexer
        LabeledCalculatorLexer lexer = new LabeledCalculatorLexer(input);
        // tokenstream 
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // parser 
        LabeledCalculatorParser parser = new LabeledCalculatorParser(tokens);
        //parse tree
        ParseTree tree = parser.prog();
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }
}
