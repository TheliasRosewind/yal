package tds.symboles;

import tds.types.Type;
import tds.types.TypesVariable;

/**
 * Symbole associé à un parametre dans la tds
 */
public class SymboleParametre extends Symbole {

	private int deplacement;
	private Type type;

	public SymboleParametre(int dep, String t){
		this.deplacement = dep;
		this.type = new Type(TypesVariable.valueOf(t.toUpperCase()));
	}

	@Override
	public int getDeplacement() {
		return deplacement;
	}

	@Override
	public Type getType() {
		return type;
	}
}
