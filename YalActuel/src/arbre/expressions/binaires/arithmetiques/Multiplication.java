package arbre.expressions.binaires.arithmetiques;

import arbre.expressions.Expression;

public class Multiplication extends ExpressionArithmetique {

    public Multiplication(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public String toMIPS() {
        String s=super.toMIPS();
        StringBuilder sb=new StringBuilder();
        sb.append("    # Début de la multiplication\n" +
                s +
                "     # Execution de la multiplication\n" +
                "     mul $v0, $t8, $v0\n" +
                "     #Fin de la multiplication\n");
        return sb.toString();
    }
}
