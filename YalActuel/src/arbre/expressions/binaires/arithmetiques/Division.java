package arbre.expressions.binaires.arithmetiques;

import arbre.expressions.Expression;

public class Division extends ExpressionArithmetique {

    public Division(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public String toMIPS() {
        String s = super.toMIPS();
        return "     # Début de la division\n" +
                s +
                "     # Execution de la division\n" +
                "     div $t8, $v0\n" +
                "     mflo $v0\n" +
                "     #Fin de la division\n";
    }
}
