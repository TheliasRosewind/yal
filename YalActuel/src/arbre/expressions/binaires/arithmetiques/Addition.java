package arbre.expressions.binaires.arithmetiques;

import arbre.expressions.Expression;

public class Addition extends ExpressionArithmetique {

    public Addition(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public String toMIPS() {
        String s=super.toMIPS();
        StringBuilder sb=new StringBuilder();
        sb.append("    # Début de l'addition\n" +
                s +
                "     # Execution de l'addition\n" +
                "     add $v0, $t8, $v0\n" +
                "     #Fin de l'addition\n");
        return sb.toString();
    }
}
