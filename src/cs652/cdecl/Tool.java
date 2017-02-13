//package cs652.cdecl;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Tool {
	public static void main(String[] args) {
		String read = "sentence";
		ANTLRInputStream input = new ANTLRInputStream(read);

		// create a lexer that feeds off of input CharStream
		CDeclLexer lexer = new CDeclLexer(input);
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// create a parser that feeds off the tokens buffer
		CDeclParser parser = new CDeclParser(tokens);

		CDeclParser.EContext tree = parser.e();
		//System.out.println(tree.toStringTree(parser));

		EnglishGenerator visitor = new EnglishGenerator();
		int v = visitor.visit(tree);
		System.out.println(v);
		// YOU MUST FILL THIS IN
	}

	public static String translate(String cdeclText) {
		// YOU MUST FILL THIS IN
	}
}
