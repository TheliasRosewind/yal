package arbre.expressions.binaires.logiques;

import arbre.expressions.Expression;
import tds.TDS;
import tds.types.TypesCompteurs;

public class EgalLogique extends ExpressionLogique {

    public EgalLogique(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public String toMIPS() {
        String s = super.toMIPS();
        int i = TDS.getInstance().nextCompteur(TypesCompteurs.CONDITIONNELLES);
        return "     # Début égal\n" +
                s +
                "     # Exécution égal\n" +
                "     bne $v0, $t8, cond" + i + "\n" +
                "     li $v0, 1\n" +
                "     j fcond" + i + "\n" +
                "     cond" + i + ":\n" +
                "     li $v0, 0\n" +
                "     fcond" + i + ":\n" +
                "     #Fin égal\n";
    }
}