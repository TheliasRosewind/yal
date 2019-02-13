package tds.entrees;

public abstract class Entree {

	protected String nom;

	protected int noLigne;

	/**
	 * Constructeur d'une entrée
	 * @param nom nom de l'entrée
	 * @param noLigne numéro de ligne de l'entrée
	 */
	public Entree(String nom, int noLigne){
		this.nom = nom;
		this.noLigne = noLigne;
	}

	/**
	 * Renvoie le nom de l'entrée
	 * @return le nom de l'entrée
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Renvoie le numéro de ligne de l'entrée
	 * @return le numéro de ligne de l'entrée
	 */
	public int getNoLigne() {
		return noLigne;
	}
}
