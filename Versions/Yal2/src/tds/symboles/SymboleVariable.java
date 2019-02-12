package tds.symboles;

import tds.types.Type;
import tds.types.TypesVariable;

public class SymboleVariable extends Symbole {

	private int deplacement;

	private Type type;

	public SymboleVariable(int deplacement, String type){
		this.deplacement = deplacement;
		this.type = new Type(TypesVariable.valueOf(type.toUpperCase()));
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
