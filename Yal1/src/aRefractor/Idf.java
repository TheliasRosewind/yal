package aRefractor;

import arbre.expressions.Expression;

public class Idf extends Expression {

	private String nom;

	private int dep;

	@Override
	public void verifier() {
		Symbole s = TDS.getInstance().identifier(new EntreeVariable(nom));
		dep = s.getDeplacement();
	}

	@Override
	public String toMIPS() {
		return null;
	}

	public Type getType(){
		return null;
	}
}
