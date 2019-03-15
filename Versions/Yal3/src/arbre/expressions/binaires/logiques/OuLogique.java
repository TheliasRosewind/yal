package arbre.expressions.binaires.logiques;

import arbre.expressions.Expression;
import arbre.expressions.binaires.ExpressionBinaire;
import exceptions.NonConcordanceTypeException;
import tds.TDS;
import tds.types.Type;
import tds.types.TypesCompteurs;
import tds.types.TypesVariable;

public class OuLogique extends ExpressionBinaire {

    public OuLogique(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public void verifier() {
        super.verifier();
        if(!(gauche.getType().concorde(new Type(TypesVariable.BOOLEEN)) && droite.getType().concorde(new Type(TypesVariable.BOOLEEN)))){
            throw new NonConcordanceTypeException(noLigne, "OuLogique logique nécessite deux booléens");
        }
    }

    @Override
    public String toMIPS() {
        String s = super.toMIPS();
        int i = TDS.getInstance().nextCompteur(TypesCompteurs.CONDITIONNELLES);
        return  "          # Début ou logique\n" +
                s +
                "          # Exécution ou logique\n" +
                "     or $v0, $t8, $v0\n" +
                "     beq $v0, $zero, cond" + i + "\n" +
                "     li $v0, 1\n" +
                "     j fcond" + i + "\n" +
                "     cond" + i + ":\n" +
                "     li $v0, 0\n" +
                "     fcond" + i + ":\n\n";
    }
}