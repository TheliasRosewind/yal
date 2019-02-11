package arbre.expressions.binaires.arithmetiques;

import arbre.expressions.Expression;

public class Addition extends ExpressionArithmetique {

    public Addition(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return null;
    }
}
