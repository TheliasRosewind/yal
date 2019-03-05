package tds.symboles;

import tds.types.Type;
import tds.types.TypesVariable;

/**
 * Symbole associé à une entrée dans la tds
 */
public class SymboleVariable extends Symbole {

	private int deplacement;
	private int imbrication;
	private Type type;

	/**
	 * Constructeur du symbole
	 * @param deplacement emplacement de la variable dans la pile
	 * @param type type de la variable
	 */
	public SymboleVariable(int deplacement, int imbrication, String type){
		this.deplacement = deplacement;
		this.imbrication = imbrication;
		this.type = new Type(TypesVariable.valueOf(type.toUpperCase()));
	}

	@Override
	public int getDeplacement() {
		return deplacement;
	}

	public int getImbrication() {
		return imbrication;
	}

	@Override
	public Type getType() {
		return type;
	}

}
