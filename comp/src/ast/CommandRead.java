package comp.src.ast;

import comp.src.datastructures.TypeCompVariable;

public class CommandRead extends AbstractCommand {

    private String id;
    private TypeCompVariable var;

    public CommandRead(String id, TypeCompVariable var) {
        this.id = id;
        this.var = var;
    }

    @Override
    public String generateJavaCode() {
        String scannerMethod;
        if (var.getType() == TypeCompVariable.NUMBER){
            scannerMethod = "nextDouble()";
        } else if (var.getType()  == TypeCompVariable.BOOLEAN) {
            scannerMethod = "nextBoolean()";
        } else {
            scannerMethod = "nextLine()";
        }
        return id + " = _keyScanner." + scannerMethod + ";";
    }

    @Override
    public String toString() {
        return "CommandRead{" +
                "id='" + id + '\'' +
                '}';
    }
}
