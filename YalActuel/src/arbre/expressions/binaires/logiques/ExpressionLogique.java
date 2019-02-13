package arbre.expressions.binaires.logiques;

import arbre.expressions.Expression;
import arbre.expressions.binaires.ExpressionBinaire;
import exceptions.NonConcordanceTypeException;
import tds.types.Type;
import tds.types.TypesVariable;

public abstract class ExpressionLogique extends ExpressionBinaire {

    public ExpressionLogique(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public void verifier() {
        super.verifier();
        if(!(gauche.getType().concorde(droite.getType()))){
            throw new NonConcordanceTypeException(noLigne, "Expression logique nécessite deux expressions du même type");
        }
    }

    @Override
    public Type getType() {
        return new Type(TypesVariable.BOOLEEN);
    }
}
