package arbre.instructions.io;

import arbre.expressions.Idf;
import arbre.instructions.Instruction;

public class Lire extends Instruction {

    protected Idf idf ;

    public Lire(String i, int n) {
        super(n) ;
        idf = new Idf(i,n) ;
    }

    @Override
    public void verifier() {
        idf.verifier();
    }

    @Override
    public String toMIPS() {
        return  "                                # lecture au clavier\n" +
                "    li $v0 , 5\n" +
                "    syscall\n" +
                "    sw $v0, " + idf.getDeplacement() + "($s7)\n" ;
    }

}
