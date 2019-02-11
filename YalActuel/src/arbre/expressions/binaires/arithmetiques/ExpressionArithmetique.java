package arbre.expressions.binaires.arithmetiques;

import arbre.expressions.Expression;
import arbre.expressions.binaires.ExpressionBinaire;

public abstract class ExpressionArithmetique extends ExpressionBinaire {

    public ExpressionArithmetique(Expression g, Expression d, int n){
        super(g,d,n);
    }
}
