package expression;

public class Addition extends Expression {
   Expression lhs;
   Expression rhs; 
   
   public Addition(Expression lhs, Expression rhs) {
	   this.lhs = lhs;
	   this.rhs = rhs;
   }
   
   @Override
   public String toString() {
	   return lhs.toString() + "+" + rhs.toString(); 
   }
}
