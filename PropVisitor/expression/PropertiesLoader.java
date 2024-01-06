package expression;

import org.antlr.v4.runtime.*; 
import java.util.*;

import antlr.PropertiesParser;
import antlr.PropertiesBaseVisitor;


public class PropertiesLoader extends PropertiesBaseVisitor<Void> {
    Map<String, String> props = new HashMap<String, String>();

	@Override public Void visitProp(PropertiesParser.PropContext ctx) { 
       String id = ctx.ID().getText();
       String value = ctx.STRING().getText();
       props.put(id, value);
       return null;
    }
    public Map<String, String> getProps() {
        return props;
    }

}
