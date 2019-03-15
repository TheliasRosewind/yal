package arbre.expressions.binaires.logiques;

import arbre.expressions.Expression;
import arbre.expressions.binaires.ExpressionBinaire;
import arbre.expressions.binaires.logiques.ExpressionLogique;
import tds.TDS;
import tds.types.TypesCompteurs;

public class EtLogique extends ExpressionBinaire {

    public EtLogique(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public String toMIPS() {
        String s = super.toMIPS();
        int i = TDS.getInstance().nextCompteur(TypesCompteurs.CONDITIONNELLES);
        return  "          # Début et logique\n" +
                s +
                "          # Exécution et logique\n" +
                "     and $v0, $t8, $v0\n" +
                "     beq $v0, $zero, cond" + i + "\n" +
                "     li $v0, 1\n" +
                "     j fcond" + i + "\n" +
                "     cond" + i + ":\n" +
                "     li $v0, 0\n" +
                "     fcond" + i + ":\n\n";
    }
}