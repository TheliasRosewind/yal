package arbre.instructions.boucle;

import arbre.ArbreAbstrait;
import arbre.expressions.Expression;
import arbre.instructions.Instruction;
import arbre.instructions.conditionnelles.SiAlors;
import exceptions.NonConcordanceTypeException;
import tds.types.Type;
import tds.types.TypesVariable;

public class Tantque extends SiAlors {

	public Tantque(Expression e, ArbreAbstrait tantque, int noLigne){
		super(e, tantque, noLigne);
	}

	@Override
	public String toMIPS() {
		String condition = super.toMIPS();
		return  "          #Début Tant Que\n" +
				condition.substring(condition.indexOf("\n") + 2, condition.indexOf("fsi" + identifiant + ":")) +
				"j si" + identifiant + "\n" +
				"     fsi" + identifiant + ":\n" +
				"\n";
	}
}