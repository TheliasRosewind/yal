package tds.entrees;

import java.util.Objects;

/**
 * Entrée associée à une fonction dans la tds
 */
public class EntreeFonction extends Entree {

	/**
	 * Constructeur d'une entrée de variable
	 * @param nom nom de la variable
	 * @param noLigne numéro de ligne de déclaration de la variable
	 */
	public EntreeFonction(String nom, int noLigne){
		super(nom, noLigne);
	}

	@Override
	public boolean equals(Object o){
		if(getClass() != o.getClass())
			return false;
		EntreeFonction e = (EntreeFonction) o;
		return this.nom.equals(e.nom);
	}

	@Override
	public int hashCode(){
		return Objects.hash(nom+"_fct");
	}

}
