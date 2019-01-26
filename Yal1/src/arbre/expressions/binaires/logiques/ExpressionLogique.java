package arbre.expressions.binaires.logiques;

import arbre.expressions.Expression;
import arbre.expressions.binaires.ExpressionBinaire;

public abstract class ExpressionLogique extends ExpressionBinaire {

    public ExpressionLogique(Expression g, Expression d, int n){
        super(g,d,n);
    }
}
