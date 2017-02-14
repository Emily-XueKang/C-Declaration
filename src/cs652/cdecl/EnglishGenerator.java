package cs652.cdecl;

import cs652.cdecl.CDeclBaseVisitor;

public class EnglishGenerator extends CDeclBaseVisitor<String> {

    public String visitVar(CDeclParser.VarContext ctx) {
        return ctx.getText() + " is a ";
        //return visit(ctx.declarator()) + " is a ";
    }

    public String visitTypename(CDeclParser.TypenameContext ctx) {
        return ctx.getText();
    }

    public String visitArray(CDeclParser.ArrayContext ctx) {
        return visit(ctx.declarator()) + "array of " ;
    }

    public String visitFunc(CDeclParser.FuncContext ctx) {
        return visit(ctx.declarator()) + "function returning ";
    }

    public String visitPointer(CDeclParser.PointerContext ctx) {
        return visit(ctx.declarator()) + "pointer to ";
    }

    public String visitGrouping(CDeclParser.GroupingContext ctx) {
        return visit(ctx.declarator());
    }

    public String visitDeclaration(CDeclParser.DeclarationContext ctx) {
        return visit(ctx.declarator()) + ctx.typename().getText();
    }

}
