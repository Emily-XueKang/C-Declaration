package cs652.cdecl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Tool {
	public static void main(String[] args) {
		String read = "int *f();";
		ANTLRInputStream input = new ANTLRInputStream(read);
		CDeclLexer lexer = new CDeclLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CDeclParser parser = new CDeclParser(tokens);
		CDeclParser.DeclarationContext tree = parser.declaration();
		EnglishGenerator visitor = new EnglishGenerator();
		//String text = tree.toStringTree(parser);
		//System.out.println(text);
		String visitree = visitor.visit(tree);
		System.out.println(visitree);

		String output = translate(visitree);
		System.out.println(visitree);

	}

	public static String translate(String cdeclText) {
		String result = "";
		result = cdeclText.replace("void", "nothing");
		return result;
	}
}
