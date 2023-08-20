package comp.src.main;

import comp.src.parser.TypeCompLexer;
import comp.src.parser.TypeCompParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


public class MainClass {
    public static void main(String[] args) {
        try {
        	TypeCompLexer lexer  = new TypeCompLexer(CharStreams.fromFileName("input.txt"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            TypeCompParser parser = new TypeCompParser(tokenStream);
            parser.program();
            System.out.println("Validado com sucesso");
            parser.generateCode();
        }
        catch (Exception err) {
            System.err.println("Generic Error: " + err.getMessage());
        }

    }
}

