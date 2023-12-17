package expression;

public class Multiplication extends Expression {
   Expression lhs; 
   Expression rhs; 
   
   public Multiplication(Expression lhs, Expression rhs) {
	   this.lhs = lhs; 
	   this.rhs = rhs; 
   }
   
   @Override
   public String toString() {
	   return this.lhs.toString() + "*" + this.rhs.toString(); 
   }
}
