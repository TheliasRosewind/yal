package arbre.instructions.conditionnelles;

import arbre.ArbreAbstrait;
import arbre.BlocDInstructions;
import arbre.expressions.Expression;
import arbre.instructions.Instruction;
import exceptions.NonConcordanceTypeException;
import tds.types.Type;
import tds.types.TypesVariable;

public class SiAlors extends Instruction {

    protected Expression e;
    protected ArbreAbstrait si;

    public SiAlors(Expression e, ArbreAbstrait si, int noLigne){
        super(noLigne);
        this.si=si;
        this.e=e;
    }

    @Override
    public void verifier() {
        e.verifier();
        si.verifier();
        if(!e.getType().concorde(new Type(TypesVariable.BOOLEEN))){
            throw new NonConcordanceTypeException(noLigne, " condition nécessite un booléen");
        }
    }

    @Override
    public String toMIPS() {
        return null;
    }
}
