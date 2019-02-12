package arbre.expressions.binaires.arithmetiques;

import arbre.expressions.Expression;

public class Soustraction extends ExpressionArithmetique {

    public Soustraction(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public String toMIPS() {
        String s = super.toMIPS();
        return  "          # Début de la soustraction\n" +
                s +
                "          # Execution de la soustraction\n" +
                "     sub $v0, $t8, $v0\n" +
                "          #Fin de la soustraction\n" +
                "\n";
    }
}
