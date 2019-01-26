package arbre.instructions;

import arbre.expressions.Idf;
import exceptions.NonConcordanceTypeException;
import arbre.expressions.Expression;

public class Affectation extends Instruction {

	private Idf idf;

	private Expression exp;

	public Affectation(Idf idf, Expression exp, int n){
		super(n);
		this.idf=idf;
		this.exp=exp;
	}

	@Override
	public void verifier() {
		idf.verifier();
		exp.verifier();
		if (!idf.getType().concorde(exp.getType())){
			throw new NonConcordanceTypeException(noLigne,idf.getNom());
		}
	}

	@Override
	public String toMIPS() {
		return null;
	}
}
