package cs652.cdecl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Tool {
	public static void main(String[] args) {
		 Tool translator = new Tool();
		 String input = "int *(*f[])();";
		 String output = translator.translate(input);
		 System.out.println(output);
	}
	public static String translate(String cdeclText) {
		ANTLRInputStream input = new ANTLRInputStream(cdeclText);
		CDeclLexer lexer = new CDeclLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CDeclParser parser = new CDeclParser(tokens);
		CDeclParser.DeclarationContext tree = parser.declaration();
		EnglishGenerator visitor = new EnglishGenerator();
		String visittree = visitor.visit(tree);
		String output = visittree.replace("void", "nothing");
		return output;
	}
}
