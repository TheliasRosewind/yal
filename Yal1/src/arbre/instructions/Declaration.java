package arbre.instructions;

import arbre.expressions.Idf;
import tds.types.Type;
import tds.types.TypesVariable;

public class Declaration extends Instruction {

    private Type type;
    private Idf idf;

    public Declaration(String t, String i, int n){
        super(n);
        this.type = new Type(TypesVariable.valueOf(t.toUpperCase()));
        this.idf = new Idf(i, n);
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "";
    }
}
