package arbre.expressions;

import tds.types.Type;
import tds.types.TypesVariable;

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public String toMIPS() {
        return "" + "     li $v0, " +
                cste +
                "\n";
    }

    @Override
    public Type getType() {
        return new Type(TypesVariable.ENTIER);
    }
}
