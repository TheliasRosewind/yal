package arbre.instructions;

import arbre.expressions.Expression;

public class Retourne extends Instruction {

	private Expression exp;

	public Retourne(Expression e, int n) {
		super(n);
		exp = e;
	}

	@Override
	public void verifier() {
		exp.verifier();
	}

	@Override
	public String toMIPS() {
		return null; // TODO
	}
}
