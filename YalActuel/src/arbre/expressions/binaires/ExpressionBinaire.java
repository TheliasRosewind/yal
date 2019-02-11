package arbre.expressions.binaires;

import tds.types.Type;
import arbre.expressions.Expression;

public abstract class ExpressionBinaire extends Expression {

	private Expression droite;

	private Expression gauche;

	public ExpressionBinaire(Expression g, Expression d, int n){
		super(n);
		droite = d;
		gauche = g;
	}

	@Override
	public Type getType() {
		return gauche.getType();
	}

}
