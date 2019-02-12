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
		return  "          #Début Si Alors Sinon\n" +
				"     si" + identifiant + ":\n" +
				e.toMIPS() +
				"     beq $v0 , $zero ,sinon" + identifiant + "\n" +
				si.toMIPS() +
				"     b fsi" + identifiant + "\n" +
				"     sinon" + identifiant + ":\n" +
				sinon.toMIPS() +
				"     fsi" + identifiant + ":\n" +
				"\n";
	}

}
