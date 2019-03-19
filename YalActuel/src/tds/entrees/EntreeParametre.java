package tds.entrees;

import java.util.Objects;

/**
 * Entrée associée à un parametre dans la tds
 */
public class EntreeParametre extends Entree {

	/**
	 * Constructeur d'une entrée
	 * @param nom     nom de l'entrée
	 * @param noLigne numéro de ligne de l'entrée
	 */
	public EntreeParametre(String nom, int noLigne) {
		super(nom, noLigne);
	}

	@Override
	public boolean equals(Object o){
		if(getClass() != o.getClass())
			return false;
		EntreeParametre e = (EntreeParametre) o;
		return this.nom.equals(e.nom);
	}

	@Override
	public int hashCode(){
		return Objects.hash(nom+"_par");
	}
}
