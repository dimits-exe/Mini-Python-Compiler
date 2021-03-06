import java.io.*;
import minipython.lexer.Lexer;
import minipython.node.Token;

public class LexerTest {
	public static void main(String[] args) 	{
		try {
			Lexer lexer = new Lexer(
					new PushbackReader(
					new FileReader(args[0].toString()), 1024));

			Token token = lexer.next();
			while (!token.getText().equals("")) {
				// don't print blanks
				if (token.getClass() != minipython.node.TBlank.class)
					System.out.printf("%s:%s%n", token, token.getClass());

				token = lexer.next(); 
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
