package tds.symboles;

import tds.types.Type;
import tds.types.TypesVariable;

/**
 * Symbole associé à une entrée dans la tds
 */
public class SymboleVariable extends Symbole {

	private int deplacement;
	private Type type;
	protected int depth;

	/**
	 * Constructeur du symbole
	 * @param deplacement emplacement de la variable dans la pile
	 * @param type type de la variable
	 */
	public SymboleVariable(int deplacement, int depth, String type){
		this.deplacement = deplacement;
		this.type = new Type(TypesVariable.valueOf(type.toUpperCase()));
		this.depth=depth;
	}

	@Override
	public int getDeplacement() {
		return deplacement;
	}

	@Override
	public Type getType() {
		return type;
	}

	public int getDepth() {
		return depth;
	}
}
