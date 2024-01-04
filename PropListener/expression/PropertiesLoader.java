package expression;

import org.antlr.v4.runtime.*; 
import java.util.*;

import antlr.PropertiesParser;
import antlr.PropertiesBaseListener;


public class PropertiesLoader extends PropertiesBaseListener {
    Map<String, String> props = new HashMap<String, String>();

    @Override public void exitProp(PropertiesParser.PropContext ctx) { 
       String id = ctx.ID().getText();
       String value = ctx.STRING().getText();
       props.put(id, value);
    }

    public Map<String, String> getProps() {
        return props;
    }

}
