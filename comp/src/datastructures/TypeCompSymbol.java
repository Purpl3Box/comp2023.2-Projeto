package comp.src.datastructures;


public abstract class TypeCompSymbol {

    protected String name;

    public abstract String generateJavaCode();

    public TypeCompSymbol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeCompSymbol [name=" + name + "]";
    }


}