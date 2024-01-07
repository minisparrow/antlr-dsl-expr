
package listeners;

import org.antlr.v4.runtime.misc.*; 

import antlr.tinycBaseListener;
import antlr.tinycParser;

import graph.Graph;

public class FunctionListener extends tinycBaseListener {
  public Graph graph = new Graph();
  String currentFunctionName = null;
  
	@Override public void enterFunctionDecl(tinycParser.FunctionDeclContext ctx) { 
    currentFunctionName = ctx.ID().getText();
    graph.nodes.add(currentFunctionName);
  }

	@Override public void exitCall(tinycParser.CallContext ctx) {
    String target = ctx.ID().getText();   
    graph.edge(currentFunctionName, target);
  }
}
