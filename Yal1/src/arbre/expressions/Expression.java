package arbre.expressions;

import tds.types.Type;
import arbre.ArbreAbstrait;

public abstract class Expression extends ArbreAbstrait {
    
    protected Expression(int n) {
        super(n) ;
    }

    public abstract Type getType();

}
