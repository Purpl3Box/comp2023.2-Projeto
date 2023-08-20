package comp.src.ast;

import java.util.ArrayList;

public class cmdWhile extends AbstractCommand{

    private String condicao;
    private ArrayList<AbstractCommand> whileList;

    public cmdWhile(String condicao, ArrayList<AbstractCommand> whileList) {
        this.condicao = condicao;
        this.whileList = whileList;
    }

    @Override
    public String GerarCodigo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("while (");
        stringBuilder.append(condicao);
        stringBuilder.append(") {\n");
        whileList.forEach(command -> stringBuilder.append(command.GerarCodigo() + "\n"));
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }
}
