package arbre.instructions.boucle;

import arbre.ArbreAbstrait;
import arbre.expressions.Expression;
import arbre.instructions.Instruction;
import exceptions.NonConcordanceTypeException;
import tds.types.Type;
import tds.types.TypesVariable;

public class Tantque extends Instruction {

	protected Expression e;
	protected ArbreAbstrait tantque;

	public Tantque(Expression e, ArbreAbstrait si, int noLigne){
		super(noLigne);
		this.tantque=si;
		this.e=e;
	}

	@Override
	public void verifier() {
		e.verifier();
		tantque.verifier();
		if(!e.getType().concorde(new Type(TypesVariable.BOOLEEN))){
			throw new NonConcordanceTypeException(noLigne, " condition nécessite un booléen");
		}
	}

	@Override
	public String toMIPS() {
		return null;
	}
}