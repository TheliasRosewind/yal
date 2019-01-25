package aRefractor;

import aRefractor.exceptions.NonConcordanceTypeException;
import arbre.expressions.Expression;
import arbre.instructions.Instruction;

public class Affectation extends Instruction {

	private Idf idf;

	private Expression exp;

	@Override
	public void verifier() {
		idf.verifier();
		exp.verifier();
		if (!idf.getType().concorde(exp.getType())){
			throw new NonConcordanceTypeException();
		}
	}

	@Override
	public String toMIPS() {
		return null;
	}
}
