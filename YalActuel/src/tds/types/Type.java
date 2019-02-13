package tds.types;

public class Type {

	private TypesVariable type;

	/**
	 * Constructeur du type
	 * @param type le type de variable
	 */
	public Type(TypesVariable type){
		this.type = type;
	}

	/**
	 * Vérifie si deux types sont identiques
	 * @param type type à comparer
	 * @return vrai si les deux types sont identiques, faux sinon
	 */
	public boolean concorde(Type type){
		return this.type == type.type;
	}

}
