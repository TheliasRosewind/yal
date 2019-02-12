package arbre.expressions.binaires.logiques;

import arbre.expressions.Expression;
import tds.TDS;
import tds.types.TypesCompteurs;

public class Superieur extends ExpressionLogique {

    public Superieur(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public String toMIPS() {
        String s = super.toMIPS();
        int i = TDS.getInstance().nextCompteur(TypesCompteurs.CONDITIONNELLES);
        return  "          # Début supérieur\n" +
                s +
                "          # Exécution supérieur\n" +
                "     blt $t8, $v0, cond" + i + "\n" +
                "     li $v0, 1\n" +
                "     j fcond" + i + "\n" +
                "     cond" + i + ":\n" +
                "     li $v0, 0\n" +
                "     fcond" + i + ":\n" +
                "          #Fin supérieur\n" +
                "\n";
    }
}