package arbre.instructions.declarations;

import arbre.expressions.Expression;
import arbre.expressions.Idf;
import arbre.instructions.Instruction;
import tds.types.Type;
import tds.types.TypesVariable;

public class DeclarationTableau extends Instruction {

    private Type type;
    private Idf idf;
    private Expression size;

    public DeclarationTableau(String t, String i, Expression size, int n){
        super(n);
        this.type = new Type(TypesVariable.valueOf(t.toUpperCase()));
        this.idf = new Idf(i, n);
        this.size=size;
    }

    @Override
    public void verifier() {size.verifier();}

    @Override
    public String toMIPS() {
        return "#allocation de la mémoire pour le tableau\n" +
                size.toMIPS()+"\n" +
                "li $t8, -4\n" +
                "mul $v0, $v0, $t8\n" +
                "add $sp, $sp, $v0\n"
                ;
    }
}
