package arbre.expressions.binaires.arithmetiques;

import arbre.expressions.Expression;
import arbre.expressions.binaires.ExpressionBinaire;
import exceptions.NonConcordanceTypeException;
import tds.types.Type;
import tds.types.TypesVariable;

public abstract class ExpressionArithmetique extends ExpressionBinaire {

    public ExpressionArithmetique(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public void verifier() {
        super.verifier();
        if(!(gauche.getType().concorde(new Type(TypesVariable.ENTIER)) && droite.getType().concorde(new Type(TypesVariable.ENTIER)))){
            throw new NonConcordanceTypeException(noLigne, " expression arithmétique requiert deux entiers");
        }
    }
}
