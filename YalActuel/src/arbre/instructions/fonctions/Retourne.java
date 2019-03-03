package arbre.instructions.fonctions;

import arbre.expressions.Expression;
import arbre.instructions.Instruction;

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
