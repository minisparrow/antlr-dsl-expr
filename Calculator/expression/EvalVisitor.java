package expression;
import antlr.LabeledCalculatorLexer;
import antlr.LabeledCalculatorParser;
import antlr.LabeledCalculatorBaseVisitor;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.Map;
import java.util.HashMap;

public class EvalVisitor extends LabeledCalculatorBaseVisitor<Integer> {
    Map<String, Integer> memory = new HashMap<String, Integer>();
	@Override public Integer visitPrintExpr(LabeledCalculatorParser.PrintExprContext ctx) { 
        Integer value = visit(ctx.expr());
        System.out.println(value);
        return 0;
    }
	@Override public Integer visitAssign(LabeledCalculatorParser.AssignContext ctx) { 
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }
	@Override public Integer visitMul(LabeledCalculatorParser.MulContext ctx) { 
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return left * right;
    }
	@Override public Integer visitDiv(LabeledCalculatorParser.DivContext ctx) { 
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return left / right;
    }
	@Override public Integer visitAdd(LabeledCalculatorParser.AddContext ctx) { 
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return left + right;
    }
	@Override public Integer visitMinus(LabeledCalculatorParser.MinusContext ctx) { 
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        return left - right;
    }
	@Override public Integer visitId(LabeledCalculatorParser.IdContext ctx) { 
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        return 0;
    }
	@Override public Integer visitInt(LabeledCalculatorParser.IntContext ctx) { 
        return Integer.valueOf(ctx.INT().getText());
    }
	@Override public Integer visitParens(LabeledCalculatorParser.ParensContext ctx) { 
        return visit(ctx.expr());
    }
}
