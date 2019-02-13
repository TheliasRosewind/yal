package tds.symboles;

import tds.types.Type;

public abstract class Symbole {

	/**
	 * Renvoie l'emplacement de la variable dans la pile, afin de la manipuler
	 * @return l'emplacement de la variable dans la pile
	 */
	public abstract int getDeplacement();

	/**
	 * Renvoie le type de la variable, afin de vérifier qu'il s'agit bien du type attendu
	 * @return le type de la variable
	 */
	public abstract Type getType();

}
