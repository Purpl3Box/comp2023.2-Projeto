package comp.src.ast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comp.src.datastructures.Simbolos;
import comp.src.datastructures.Variaveis;

public class cmdAtribui extends AbstractCommand {

    private String id;
    private String exp;
    private final String regexIdentifier = "[a-z]([a-z]|[A-Z]|[0-9])*";
    private final String regexNumber = "[0-9]+(\\.[0-9]+)?";
    private final String idOrNumber = regexIdentifier + "|" + regexNumber;
    
    public cmdAtribui(String id, String exp) {
        this.id = id;
        this.exp = exp;
    }

    private String potenciaMath(String exp) {
        final String regex = "(?<base>"+ idOrNumber +")\\*\\*(?<potencia>"+ idOrNumber +")";
        final String subst = "Math.pow(${base},${potencia})";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(exp);
        final String modifiedexp = matcher.replaceAll(subst);
        return modifiedexp;
    }

    private String raizMath(String exp) {
        final String regex = "raiz(?<radicando>[0-9]+(\\.[0-9]+)*)";
        final String subst = "Math.sqrt(${radicando})";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(exp);
        final String modifiedexp = matcher.replaceAll(subst);
        return modifiedexp;
    }

    @Override
    public String GerarCodigo() {
        exp = potenciaMath(exp);
        exp = raizMath(exp);
        return id + " =" + exp + ";";
    }

    @Override
    public String toString() {
        return "cmdAtribui{" +
                "id='" + id + '\'' +
                ", exp='" + exp + '\'' +
                '}';
    }
}
