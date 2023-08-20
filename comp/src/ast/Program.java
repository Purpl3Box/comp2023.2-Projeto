package comp.src.ast;

import comp.src.datastructures.Simbolos;
import comp.src.datastructures.SimbolosTable;
import comp.src.datastructures.SimbolosTable;
import comp.src.datastructures.Simbolos;
import comp.src.datastructures.SimbolosTable;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Program {
    private SimbolosTable vartable;
    private ArrayList<AbstractCommand> comandos;
    private String programName;

    public void generateTarget(){
        String className = "Output";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("import java.util.Scanner;\n");
        stringBuilder.append("public class " + className + " {\n");
        stringBuilder.append("public static void main(String args[]){\n");
        stringBuilder.append("Scanner _keyScanner = new Scanner(System.in);\n");
        vartable.getAll().forEach(Simbolos -> stringBuilder.append(Simbolos.GerarCodigo() + "\n"));
        comandos.forEach(command -> stringBuilder.append(command.GerarCodigo()+"\n"));
        stringBuilder.append("}\n");
        stringBuilder.append("}\n");

        try {
            FileWriter fileWriter = new FileWriter(new File(className + ".java"));
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public SimbolosTable getVartable() {
        return vartable;
    }

    public void setVartable(SimbolosTable vartable) {
        this.vartable = vartable;
    }

    public ArrayList<AbstractCommand> getcomandos() {
        return comandos;
    }

    public void setcomandos(ArrayList<AbstractCommand> comandos) {
        this.comandos = comandos;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
