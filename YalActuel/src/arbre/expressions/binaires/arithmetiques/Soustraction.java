package arbre.expressions.binaires.arithmetiques;

import arbre.expressions.Expression;

public class Soustraction extends ExpressionArithmetique {

    public Soustraction(Expression g, Expression d, int n){
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
