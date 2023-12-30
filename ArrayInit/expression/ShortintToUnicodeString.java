package expression;

import antlr.ArrayInitBaseListener;
import antlr.ArrayInitParser;

public class ShortintToUnicodeString extends ArrayInitBaseListener {
	@Override public void enterInit(ArrayInitParser.InitContext ctx) { 
    System.out.print('"');
  }
	@Override public void enterValue(ArrayInitParser.ValueContext ctx) {
    int value = Integer.valueOf(ctx.INT().getText());
    System.out.printf("\\u%04x", value);
  }
	@Override public void exitInit(ArrayInitParser.InitContext ctx) { 
    System.out.print('"');
  }
}
