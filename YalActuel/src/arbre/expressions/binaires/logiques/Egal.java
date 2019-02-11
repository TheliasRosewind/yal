package arbre.expressions.binaires.logiques;

import arbre.expressions.Expression;

public class Egal extends ExpressionLogique {

    public Egal(Expression g, Expression d, int n){
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