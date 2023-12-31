package expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionProcessor {
	List<Expression> list;
	public Map<String, Integer> values; 
	
	//constructor 
	public ExpressionProcessor(List<Expression> list) {
		this.list = list; 
		values = new HashMap<String, Integer>(); 
	}
	
	public List<String> getEvaluationResults(){
		List<String> evaluations = new ArrayList<>(); 
				
		for(Expression e: list) {
			if (e instanceof VariableDeclaration) {
				VariableDeclaration decl = (VariableDeclaration) e; 
				values.put(decl.id,  decl.value); 
			} else {// e instanceof Number, Variable, Addition, ...
				String input = e.toString();
				int result = getEvalResult(e);
				evaluations.add(input + " is " + result);
			}
		}
		
		return evaluations; 
	}

	private int getEvalResult(Expression e) {
		// TODO Auto-generated method stub
		int result = 0; 
		if (e instanceof Number) {
			Number num = (Number) e;
			result = num.num; 
		} else if (e instanceof Variable) {
			Variable var = (Variable) e; 
			result = values.get(var.id); 	
		} else if (e instanceof Addition) {
			Addition add = (Addition) e; 
			int left = getEvalResult(add.lhs);
			int right = getEvalResult(add.rhs);
			result = left + right; 
		} else if (e instanceof Multiplication) {
			Multiplication mul = (Multiplication) e; 
			int left = getEvalResult(mul.lhs);
			int right = getEvalResult(mul.rhs);
			result = left * right; 
		}
		
		return result;
	}
	

}
