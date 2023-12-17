package expression;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import antlr.ExprBaseVisitor;
import antlr.ExprParser.AdditionContext;
import antlr.ExprParser.DeclarationContext;
import antlr.ExprParser.MultiplicationContext;
import antlr.ExprParser.NumberContext;
import antlr.ExprParser.VariableContext;

public class AntlrToExpression extends ExprBaseVisitor<Expression> {
	
	private List<String> vars; // store all the variables declared in the program so far 
	private List<String> semanticErrors; // 1. duplicate declaration  2. reference to undeclared variable 
	
	//Constructor 
	public AntlrToExpression(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors; 
		vars = new ArrayList<>(); 
	}

	@Override
	public Expression visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		// return super.visitDeclaration(ctx);
		// declaration context-> i : INT = 5 
		
		Token idToken = ctx.ID().getSymbol(); //equivalent to: ctx.getChild(0).getSymbol()
		int line = idToken.getLine(); 
		int column = idToken.getCharPositionInLine() + 1; 
		
		
		String id = ctx.getChild(0).getText();
		//Maintaining the vars list for semantic error reporting 
		if (vars.contains(id)) {
			semanticErrors.add("Error: variable " + id + " already declared (" + line + ", " + column + ")"); 
		} else {
			vars.add(id);
		}
		
		String type = ctx.getChild(2).getText();
		int value = Integer.parseInt(ctx.getChild(4).getText());
		return new VariableDeclaration(id, type, value);
	}

	@Override
	public Expression visitMultiplication(MultiplicationContext ctx) {
		// TODO Auto-generated method stub
		// return super.visitMultiplication(ctx);
		
		Expression left = visit(ctx.getChild(0)); 
		Expression right = visit(ctx.getChild(2));
		
		return new Multiplication(left, right);
	}

	@Override
	public Expression visitAddition(AdditionContext ctx) {
		// TODO Auto-generated method stub
		//return super.visitAddition(ctx);
		Expression left = visit(ctx.getChild(0)); 
		Expression right = visit(ctx.getChild(2));
		
		return new Addition(left, right);
	}

	@Override
	public Expression visitVariable(VariableContext ctx) {
		// TODO Auto-generated method stub
		// return super.visitVariable(ctx);
		Token idToken = ctx.ID().getSymbol();
		int line = idToken.getLine(); 
		int column = idToken.getCharPositionInLine() + 1; 
		// if reference the var before it's declared, report semantic error
		String id = ctx.getChild(0).getText();
		if(!vars.contains(id)) {
			semanticErrors.add("Error: variable "+ id + " not declared (" + line + ", " + column + ")" );
		}
		
		return new Variable(id);
	}

	@Override
	public Expression visitNumber(NumberContext ctx) {
		// TODO Auto-generated method stub
		String numText = ctx.getChild(0).getText();
		int num = Integer.parseInt(numText);
		return new Number(num);
		// return super.visitNumber(ctx);
	}

}
