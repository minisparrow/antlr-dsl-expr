package expression;

public class VariableDeclaration extends Expression {
     String id; 
     String type; 
     int value; 
    
    //constructor
    public VariableDeclaration(String id, String type, int value) {
    	this.id = id; 
    	this.type = type;
    	this.value = value; 
    }
}
