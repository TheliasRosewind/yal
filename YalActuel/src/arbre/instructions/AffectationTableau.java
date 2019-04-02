package arbre.instructions;

import arbre.expressions.Expression;
import arbre.expressions.Idf;
import exceptions.NonConcordanceTypeException;

public class AffectationTableau extends Instruction {

	private Idf idf;

	private Expression exp;

	private Expression index;

	public AffectationTableau(String idf, Expression exp, Expression index, int n){
		super(n);
		this.idf = new Idf(idf, n);
		this.exp = exp;
		this.index=index;
	}

	@Override
	public void verifier() {
		idf.verifier();
		exp.verifier();
		index.verifier();
		if (!idf.getType().concorde(exp.getType())){
			throw new NonConcordanceTypeException(noLigne, idf.getNom());
		}
	}

	@Override
	public String toMIPS() {
		return  "          # récupération de la valeur\n" +
				exp.toMIPS() +
				"	  sw $v0, 0($sp) #empilage de v0\n" +
				"	  addi $sp, $sp, -4\n" +
				"	  #récupération de l'index\n" +
				index.toMIPS() +
				"	  li $t8, -4\n" +
				"	  mul $v0, $v0, $t8\n" +
				"	  addi $v0, $v0, " + idf.getDeplacement() + "\n" +
				"	  addi $v0, $v0, $s7\n" +
				"	  lw $t8, 4($sp)\n" +
				"	  addi $sp, $sp, 4\n" +
				"     sw $t8, " + idf.getDeplacement() + "0($v0)\n" +
				"\n";
	}
}
