package listeners;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import antlr.CSVParser;
import antlr.CSVBaseListener;

public static class Loader extends CSVBaseListener {
  public static final String EMPTY="";
  List<Map<String, String>> rows = new ArrayList<Map<String, String>>(); 

  List<String> header; 

  List<String> currentRowFieldValues; 

	@Override public void exitText(CSVParser.TextContext ctx) { 
    currentRowFieldValues.add(ctx.TEXT().getText());

  }

	@Override public void exitString(CSVParser.StringContext ctx) {
    currentRowFieldValues.add(ctx.STRING().getText());
  }

	@Override public void exitEmpty(CSVParser.EmptyContext ctx) { 
    currentRowFieldValues.add(EMPTY);
  }

	@Override public void exitHeader(CSVParser.HeaderContext ctx) { 
    header = new ArrayList<String>();
    header.addAll(currentRowFieldValues);
  }

	@Override public void enterRow(CSVParser.RowContext ctx) { 
    currentRowFieldValues = new List<String>(); 
  }

	@Override public void exitRow(CSVParser.RowContext ctx) { 
    // if this the header row, do nothing 

    if(ctx.getParent().getRuleindex == CSVParser.RULE_header) return;

    // it 's data now 
    //
    Map<String, String> map = new LinkedHashMap<String, String>();
    int i = 0; 

    for(String v: currentRowFieldValues) {
      map.put(header.get(i), v);
      i++;
    }

    rows.add(map);
  }

}
