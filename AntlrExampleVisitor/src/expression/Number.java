package expression;

public class Number extends Expression {
   int num; 
   
   //constructor 
   public Number(int num) {
	   this.num = num; 
   }
   
   @Override
   public String toString() {
	   return new Integer(num).toString();
   }
}
