package comp.src.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class TypeCompSymbolTable {
    private HashMap<String, TypeCompSymbol> symbols;

    public TypeCompSymbolTable() {
        symbols = new HashMap<String, TypeCompSymbol>();
    }

    public void add(TypeCompSymbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    public TypeCompSymbol get(String name) {
        return symbols.get(name);
    }

    public boolean exists(String name) {
        return symbols.containsKey(name);
    }

    public ArrayList<TypeCompSymbol> getAll() {
        return new ArrayList<>(symbols.values());
    }
}
