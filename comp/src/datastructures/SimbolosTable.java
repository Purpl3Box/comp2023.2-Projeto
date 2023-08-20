package comp.src.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class SimbolosTable {
    private HashMap<String, Simbolos> symbols;

    public SimbolosTable() {
        symbols = new HashMap<String, Simbolos>();
    }

    public void add(Simbolos symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    public Simbolos get(String name) {
        return symbols.get(name);
    }

    public boolean exists(String name) {
        return symbols.containsKey(name);
    }

    public ArrayList<Simbolos> getAll() {
        return new ArrayList<>(symbols.values());
    }
}
