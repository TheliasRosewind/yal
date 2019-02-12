package arbre.instructions.conditionnelles;

import arbre.ArbreAbstrait;
import arbre.expressions.Expression;
import tds.TDS;
import tds.types.TypesCompteurs;

public class SiSinon extends SiAlors {

	protected ArbreAbstrait sinon;

	public SiSinon(Expression e, ArbreAbstrait si, ArbreAbstrait sinon, int noLigne){
		super(e, si, noLigne);
		this.sinon = sinon;
	}

	@Override
	public String toMIPS() {
		int cond = TDS.getInstance().nextCompteur(TypesCompteurs.CONDITIONNELLES);
		return  "          #Début Si Alors Sinon" +
				"     si" + cond + ":\n" +
				e.toMIPS() +
				"     beq $v0 , $zero ,sinon" + cond + "\n" +
				si.toMIPS() +
				"     b finsi" + cond + "\n" +
				"     sinon" + cond + ":\n" +
				sinon.toMIPS() +
				"     fsi" + cond + ":\n" +
				"\n";
	}

}
