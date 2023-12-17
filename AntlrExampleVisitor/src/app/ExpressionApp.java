package app;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ExprLexer;
import antlr.ExprParser;

import expression.AntlrToProgram;
import expression.ExpressionProcessor;
import expression.MyErrorListener;
import expression.Program;



public class ExpressionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1) {
			System.err.print("Usage : file name\n"); 
		} else {
			String fileName = args[0]; 
			ExprParser parser = getParser(fileName);
			
			//build a parse tree, parse from start symbol 'prog'
			ParseTree antlrAST = parser.prog();
			
			if (MyErrorListener.hasError) {
				/* let the syntax error be reported */
			} else {
				// antlr AST to program/expression object AST -> program
				AntlrToProgram progVisitor = new AntlrToProgram();
				Program prog = progVisitor.visit(antlrAST);
				
				
				if (progVisitor.semanticErrors.isEmpty()) {
					ExpressionProcessor ep = new ExpressionProcessor(prog.expressions); 
					for(String evaluation: ep.getEvaluationResults())  {
						System.out.println(evaluation);
					}
					
					
				} else {
					for (String err: progVisitor.semanticErrors) {
						System.out.println(err);
					}
				}				
			}
			

		}

	}
	
	
	// charstream -> lexer -> [tokens] ->  parser -----> [ast]
	public static ExprParser getParser(String fileName) {
		ExprParser parser = null; 
		try {
			CharStream input = CharStreams.fromFileName(fileName);
			ExprLexer lexer = new ExprLexer(input); 
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new ExprParser(tokens);
			
			//syntax error handling 
			parser.removeErrorListeners();
			parser.addErrorListener(new MyErrorListener());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parser;
	}

}
