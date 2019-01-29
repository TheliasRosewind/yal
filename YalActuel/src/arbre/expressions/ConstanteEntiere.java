package arbre.expressions;

import tds.types.Type;
import tds.types.TypesVariable;

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder("") ;
        sb.append("    li $v0, ") ;
        sb.append(cste) ;
        sb.append("\n") ;
        return sb.toString() ;
    }

    @Override
    public Type getType() {
        return new Type(TypesVariable.ENTIER);
    }
}
