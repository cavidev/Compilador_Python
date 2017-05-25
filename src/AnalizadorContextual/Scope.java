package AnalizadorContextual;

/**
 * Carlos Mario Villafuerte Díaz
 * Esteban Gabriel Blanco Espinoza
 */
public class Scope {
    private int profundidadScope;
    private TablaSimbolos tablaSimbolos;

    public Scope(int scope, TablaSimbolos tablaSimbolos) {
        this.profundidadScope = scope;
        this.tablaSimbolos = tablaSimbolos;
    }

    public int getScope() {
        return profundidadScope;
    }

    public void setScope(int scope) {
        this.profundidadScope = scope;
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    public void setTablaSimbolos(TablaSimbolos tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }
}
