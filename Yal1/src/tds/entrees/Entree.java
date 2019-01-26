package tds.entrees;

public abstract class Entree {

	protected String nom;
	protected int noLigne;

	public Entree(String nom, int noLigne){
		this.nom = nom;
		this.noLigne=noLigne;
	}

	public String getNom() {
		return nom;
	}

	public int getNoLigne() {
		return noLigne;
	}
}
