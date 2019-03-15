package arbre.instructions.fonctions;

import arbre.expressions.Expression;
import arbre.instructions.Instruction;
import exceptions.RetourSansFonctionException;
import tds.TDS;
import tds.types.TypesCompteurs;

public class Retourne extends Instruction {

	private Expression exp;
	private int fct;

	public Retourne(Expression e, int n) {
		super(n);
		exp = e;
	}

	@Override
	public void verifier() {
		if(TDS.getInstance().getProfondeurActuelle() == 0){
			throw new RetourSansFonctionException(noLigne, "");
		}
		fct = TDS.getInstance().getCompteur(TypesCompteurs.BLOCS);
		TDS.getInstance().addRetour();
		exp.verifier();
	}

	@Override
	public String toMIPS() {
		return (exp.toMIPS() + "j FIN_FCT_" + fct + "\n");
	}
}
