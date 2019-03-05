package tds.symboles;

import tds.types.Type;
import tds.types.TypesVariable;

/**
 * Symbole associé à une fonction dans la tds
 */
public class SymboleFonction extends Symbole {

	private int num;

	/**
	 * Constructeur du symbole
	 * @param num numéro de la fonction dans la TDS
	 */
	public SymboleFonction(int num){
		this.num = num;
	}

	@Override
	public int getDeplacement() {
		return 12;
	}

	@Override
	public Type getType() {
		return new Type(TypesVariable.ENTIER);
	}

	public int getNum() {
		return num;
	}
}
