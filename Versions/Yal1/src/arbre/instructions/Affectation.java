package arbre.instructions;

import arbre.expressions.Idf;
import exceptions.NonConcordanceTypeException;
import arbre.expressions.Expression;

public class Affectation extends Instruction {

	private Idf idf;

	private Expression exp;

	public Affectation(String idf, Expression exp, int n){
		super(n);
		this.idf = new Idf(idf, n);
		this.exp=exp;
	}

	@Override
	public void verifier() {
		idf.verifier();
		exp.verifier();
		/*if (!idf.getType().concorde(exp.getType())){
			throw new NonConcordanceTypeException(noLigne, idf.getNom());
		}*/
	}

	@Override
	public String toMIPS() {
		return  "                   # affectation de la variable\n" +
				exp.toMIPS() +
				"    sw $v0, " + idf.getDeplacement() + "($s7)\n";
	}
}
