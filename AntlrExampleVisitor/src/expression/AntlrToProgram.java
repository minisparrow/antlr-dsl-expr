package expression;

import java.util.ArrayList;
import java.util.List;

import antlr.ExprBaseVisitor;
import antlr.ExprParser.ProgramContext;

public class AntlrToProgram extends ExprBaseVisitor<Program> {

	
	public List<String> semanticErrors; 
	@Override
	public Program visitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub

		Program prog = new Program();
		
	    semanticErrors = new ArrayList<String>();
	    
	    AntlrToExpression exprVisitor = new AntlrToExpression(semanticErrors); 
	    for (int i = 0; i < ctx.getChildCount(); i++) {
	    	if (i == ctx.getChildCount() - 1) {
	    		/* last child of prog is EOF*/
	    	} 
	    	else {
	    		prog.addExpression(exprVisitor.visit(ctx.getChild(i)));
	    	}
	    }
	    
	    return prog; 
	}
}
