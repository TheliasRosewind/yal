package tds;

import tds.entrees.Entree;
import tds.symboles.Symbole;
import exceptions.DoubleDeclarationException;
import exceptions.VariableNonDeclareeException;
import tds.types.TypesCompteurs;

import java.util.HashMap;

/**
 * Table des symboles
 */
public class TDS {
	/*
	 * Association entre les entrées et leur symbole
	 */
	private HashMap<Entree, Symbole> tds;
	/*
	 * Sauvegarde l'emplacement du sommet de pile
	 */
	private int sommetDePile;
	/*
	 * Permet de compter le nombre de bloc de chaque type, afin d'avoir des identifiants uniques
	 */
	private HashMap<TypesCompteurs, Integer> compteurs;

	/*
	 * Instance de la table des symboles
	 */
	private static TDS instance = new TDS();

	/**
	 * Constructeur de la table
	 */
	private TDS(){
		this.tds = new HashMap<>();
		this.sommetDePile = 0;
		this.compteurs = new HashMap<>();
		compteurs.put(TypesCompteurs.CONDITIONNELLES, 0);
		compteurs.put(TypesCompteurs.BLOCS, 0);
	}

	/**
	 * Permet d'accèder à la table depuis n'importe quelle classe
	 * @return la table des symboles
	 */
	public static TDS getInstance(){
		return instance;
	}

	/**
	 * Ajoute une entrée et son symbole dans la table
	 * @param entree l'entrée à ajouter
	 * @param symbole symbole associé à l'entrée
	 * @throws DoubleDeclarationException si l'entrée existe déjà, une exception est levée
	 */
	public void ajouter(Entree entree, Symbole symbole) throws DoubleDeclarationException {
		if (tds.containsKey(entree)){
			throw new DoubleDeclarationException(entree.getNoLigne(),entree.getNom());
		}
		tds.put(entree, symbole);
	}

	/**
	 * Permet de récupèrer le symbole associé à une entrée
	 * @param entree entrée dont on veut le symbole
	 * @return le symbole associé à l'entrée
	 * @throws VariableNonDeclareeException si l'entrée spécifiée n'existe pas dans la table, une exception est levée
	 */
	public Symbole identifier(Entree entree) throws VariableNonDeclareeException {
		if(!tds.containsKey(entree)){
			throw new VariableNonDeclareeException(entree.getNoLigne(), entree.getNom());
		}
		return tds.get(entree);
	}

	/**
	 * Déplace le sommet de pile pour accorder une position dans la pile à une variable
	 * @return l'emplacement de la variable dans la pile
	 */
	public int newDeplacement(){
		int dep = sommetDePile;
		sommetDePile -= 4;
		return dep;
	}

	/**
	 * Renvoie l'emplacement actuel du sommet de pile, afin de réserver l'espace nécessaire à la déclaration des variables
	 * @return l'emplacement actuel du sommet de pile
	 */
	public int getSommetDePile() {
		return sommetDePile;
	}

	/**
	 * Renvoie un nouveau numéro de bloc pour avoir des identifiants uniques
	 * @param compteur type du compteur pour lequel on veut un numéro
	 * @return numéro de bloc suivant
	 */
	public int nextCompteur(TypesCompteurs compteur){
		int i = compteurs.get(compteur);
		compteurs.replace(compteur, i + 1);
		return i;
	}

	/*
	public int getTailleZoneVariable(Entree e, Symbole s) {
		return 0;
	}
	*/

}
