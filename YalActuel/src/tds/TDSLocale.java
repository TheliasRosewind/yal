package tds;

import exceptions.DoubleDeclarationException;
import exceptions.VariableNonDeclareeException;
import tds.entrees.Entree;
import tds.symboles.Symbole;
import tds.types.TypesCompteurs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Table des symboles
 */
public class TDSLocale {

	private TDSLocale root;
	private ArrayList<TDSLocale> children;

	/*
	 * Association entre les entrées et leur symbole
	 */
	private HashMap<Entree, Symbole> tds;
	/*
	 * Sauvegarde l'emplacement du sommet de pile
	 */
	private int sommetDePile;


	/**
	 * Constructeur de la table
	 */
	public TDSLocale(TDSLocale root){
		this.tds = new HashMap<>();
		this.children=new ArrayList<>();
		this.sommetDePile = 0;
		this.root = root;
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
			if(root != null){
				return root.identifier(entree);
			} else {
				throw new VariableNonDeclareeException(entree.getNoLigne(), entree.getNom());
			}
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


	public TDSLocale getRoot() {
		return root;
	}

	public ArrayList<TDSLocale> getChildren() {
		return children;
	}

	public TDSLocale getNextTDS() {
		return children.iterator().next();
	}

	public void addChildren(TDSLocale tdsLocale){
		this.children.add(tdsLocale);
	}
}
