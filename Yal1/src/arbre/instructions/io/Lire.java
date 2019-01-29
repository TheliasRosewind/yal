package arbre.instructions.io;

import arbre.expressions.Idf;
import arbre.instructions.Instruction;

public class Lire extends Instruction {

    protected Idf idf ;

    public Lire(Idf i, int n) {
        super(n) ;
        idf = i ;
    }

    @Override
    public void verifier() {
        idf.verifier();
    }

    @Override
    public String toMIPS() {
        return  "                   # lecture au clavier\n" +
                "    li $v0 , 5\n" +
                "    syscall" +
                "    sw $v0, " + idf.getDeplacement() + "($s7)\n" ;
    }

}
