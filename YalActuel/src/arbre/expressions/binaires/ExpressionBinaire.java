package arbre.expressions.binaires;

import tds.types.Type;
import arbre.expressions.Expression;

public abstract class ExpressionBinaire extends Expression {

	protected Expression droite;

	protected Expression gauche;

	public ExpressionBinaire(Expression g, Expression d, int n){
		super(n);
		droite = d;
		gauche = g;
	}

	@Override
	public Type getType() {
		return gauche.getType();
	}

	@Override
	public void verifier() {
		gauche.verifier();
		droite.verifier();
	}

	@Override
	public String toMIPS() {
		return "     # Chargement de l'expression gauche dans $v0\n" +
				gauche.toMIPS() +
				"     # Empilage de l'expression de gauche\n" +
				"     sw $v0, 0($sp)\n" +
				"     addi $sp,$sp,-4\n" +
				"     # Chargement de l'expression de droite dans $v0\n" +
				droite.toMIPS() +
				"     # Dépilage de l'expression de gauche dans $t8\n" +
				"     lw $t8, 4($sp)\n" +
				"     addi $sp, $sp, 4\n";
	}

}
