package arbre.expressions.binaires.logiques;

import arbre.expressions.Expression;
import tds.TDS;
import tds.types.TypesCompteurs;

public class Inferieur extends ExpressionLogique {

    public Inferieur(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public String toMIPS() {
        String s = super.toMIPS();
        int i = TDS.getInstance().nextCompteur(TypesCompteurs.CONDITIONNELLES);
        return  "          # Début inférieur\n" +
                s +
                "          # Exécution inférieur\n" +
                "     bge $t8, $v0, cond" + i + "\n" +
                "     li $v0, 1\n" +
                "     j fcond" + i + "\n" +
                "     cond" + i + ":\n" +
                "     li $v0, 0\n" +
                "     fcond" + i + ":\n" +
                "          #Fin inférieur\n" +
                "\n";
    }
}