package arbre.expressions.binaires.arithmetiques;

import arbre.expressions.Expression;
import arbre.expressions.binaires.ExpressionBinaire;
import exceptions.NonConcordanceTypeException;
import tds.types.Type;
import tds.types.TypesVariable;

public abstract class ExpressionArithmetique extends ExpressionBinaire {

    public ExpressionArithmetique(Expression g, Expression d, int n){
        super(g,d,n);
    }

    @Override
    public void verifier() {
        gauche.verifier();
        droite.verifier();
        if(!gauche.getType().concorde(new Type(TypesVariable.ENTIER)) && droite.getType().concorde(new Type(TypesVariable.ENTIER))){
            throw new NonConcordanceTypeException(noLigne," addition requiert deux entiers");
        }
    }

    @Override
    public String toMIPS() {
        StringBuilder sb=new StringBuilder();
        sb.append("     # Chargement de l'expression gauche dans $v0\n" +
                gauche.toMIPS() +
                "   # Empilage de l'expression de gauche\n" +
                "   sw $v0, 0($sp)\n" +
                "   addi $sp,$sp,-4\n" +
                "   # Chargement de l'expression de droite dans $v0\n" +
                droite.toMIPS() +
                "   # Dépilage de l'expression de gauche dans $t8\n" +
                "   lw $t8, 4($sp)\n" +
                "   addi $sp, $sp, 4\n");
        return sb.toString();
    }
}
