package arbre.instructions;

import arbre.expressions.Idf;
import tds.types.Type;

public class Declaration extends Instruction {

    private Type type;
    private Idf idf;

    public Declaration(Type t, Idf i, int n){
        super(n);
        this.type=t;
        this.idf=i;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return null;
    }
}
