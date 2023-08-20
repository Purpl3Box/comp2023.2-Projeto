package comp.src.datastructures;


public abstract class Simbolos {

    protected String name;

    public abstract String GerarCodigo();

    public Simbolos(String name) {
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
        return "Simbolos [name=" + name + "]";
    }


}