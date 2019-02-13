package arbre.expressions.unaires;

import arbre.expressions.Expression;
import exceptions.NonConcordanceTypeException;
import tds.TDS;
import tds.types.Type;
import tds.types.TypesCompteurs;
import tds.types.TypesVariable;

public class NonLogique extends Expression {

    protected Expression exp;

    public NonLogique(Expression g, int n){
        super(n);
        this.exp=g;
    }

    @Override
    public void verifier() {
        exp.verifier();
        if(!exp.getType().concorde(new Type(TypesVariable.BOOLEEN))){
            throw new NonConcordanceTypeException(noLigne, "Non logique nécessite un booléen ");
        }
    }

    @Override
    public Type getType() {
        return new Type(TypesVariable.BOOLEEN);
    }

    @Override
    public String toMIPS() {
        int i = TDS.getInstance().nextCompteur(TypesCompteurs.CONDITIONNELLES);
        return  "          # Début du non logique \n" +
                exp.toMIPS() +
                "     beq $v0, $zero, cond" + i + "\n" +
                "     li $v0, 0\n" +
                "     j fcond" + i + "\n" +
                "     cond" + i + ":\n" +
                "     li $v0, 1\n" +
                "     fcond" + i + ":\n\n";
    }
}
