package arbre.instructions.boucle;

import arbre.ArbreAbstrait;
import arbre.expressions.Expression;
import arbre.instructions.conditionnelles.SiAlors;

public class Tantque extends SiAlors {

	public Tantque(Expression e, ArbreAbstrait tantque, int noLigne){
		super(e, tantque, noLigne);
	}

	@Override
	public String toMIPS() {
		String condition = super.toMIPS();
		return  "          # Début Tant Que\n" +
				condition.substring(condition.indexOf("\n") + 2, condition.indexOf("fsi" + identifiant + ":")) +
				"# retour au début de la boucle" +
				"     j si" + identifiant + "\n" +
				"     fsi" + identifiant + ":\n" +
				"\n";
	}
}