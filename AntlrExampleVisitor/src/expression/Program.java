package expression;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public List<Expression> expressions;
	
	//constructor 
	public Program() {
		this.expressions = new ArrayList<Expression>();
	}
	
	public void addExpression(Expression e) {
		expressions.add(e);
	}

}
