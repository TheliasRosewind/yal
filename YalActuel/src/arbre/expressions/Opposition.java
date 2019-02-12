package arbre.expressions;

import exceptions.NonConcordanceTypeException;
import tds.types.Type;
import tds.types.TypesVariable;

public class Opposition extends Expression {

    protected Expression exp;

    public Opposition(Expression g, int n){
        super(n);
        this.exp=g;
    }

    @Override
    public void verifier() {
        exp.verifier();
        if(!exp.getType().concorde(new Type(TypesVariable.ENTIER))){
            throw new NonConcordanceTypeException(noLigne,"Opposition nécessite un entier ");
        }
    }

    @Override
    public Type getType() {
        return new Type(TypesVariable.ENTIER);
    }

    @Override
    public String toMIPS() {
        StringBuilder sb=new StringBuilder();
        sb.append("    # Début de l'opposée \n" +
                exp.toMIPS() +
                "     # Execution de l'opposée\n" +
                "     subu $v0, $zero, $t8\n" +
                "     #Fin de l'opposition\n");
        return sb.toString();
    }
}
