package comp.src.ast;

import java.util.ArrayList;

public class cmdIf extends AbstractCommand {

    private String condicao;
    private ArrayList<AbstractCommand> TipoLista;
    private ArrayList<AbstractCommand> NaoLista;

    public cmdIf(String condicao, ArrayList<AbstractCommand> TipoLista, ArrayList<AbstractCommand> NaoLista) {
        this.condicao = condicao;
        this.TipoLista = TipoLista;
        this.NaoLista = NaoLista;
    }

    @Override
    public String GerarCodigo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("if (");
        stringBuilder.append(condicao);
        stringBuilder.append(") {\n");
        TipoLista.forEach(command -> stringBuilder.append(command.GerarCodigo() + "\n"));
        stringBuilder.append("}\n");
        if(!NaoLista.isEmpty()) {
            stringBuilder.append("else {\n");
            NaoLista.forEach(command -> stringBuilder.append(command.GerarCodigo() + "\n"));
            stringBuilder.append("}\n");
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "cmdIf{" +
                "condicao='" + condicao + '\'' +
                ", TipoLista=" + TipoLista +
                ", NaoLista=" + NaoLista +
                '}';
    }
}
