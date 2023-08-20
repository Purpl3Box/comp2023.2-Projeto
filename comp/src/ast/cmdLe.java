package comp.src.ast;

import comp.src.datastructures.Variaveis;
import comp.src.datastructures.Variaveis;

public class cmdLe extends AbstractCommand {

    private String id;
    private Variaveis var;

    public cmdLe(String id, Variaveis var) {
        this.id = id;
        this.var = var;
    }

    @Override
    public String GerarCodigo() {
        String scannerMethod;
        if (var.getType() == Variaveis.NUMBER){
            scannerMethod = "nextDouble()";
        } else {
            scannerMethod = "nextLine()";
        }
        return id + " = _keyScanner." + scannerMethod + ";";
    }

    @Override
    public String toString() {
        return "cmdLe{" +
                "id='" + id + '\'' +
                '}';
    }
}
