package comp.src.datastructures;

public class TypeCompVariable extends TypeCompSymbol{
    public static final int NUMBER = 0;
    public static final int TEXT = 1;
    public static final int BOOLEAN = 2;

    private  int type;
    private String value;

    public TypeCompVariable(String name, int type, String value) {
        super(name);
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String generateJavaCode() {
        String varType;
        if (type == NUMBER){
            varType = "double";
        } else if (type == BOOLEAN) {
            varType = "boolean";
        } else {
            varType = "String";
        }
        return varType + " " + name + ";";
    }

    @Override
    public String toString() {
        return "IsiVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
    }


}
