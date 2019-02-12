package tds;

import tds.entrees.Entree;
import tds.symboles.Symbole;
import exceptions.DoubleDeclarationException;
import exceptions.VariableNonDeclareeException;
import tds.types.TypesCompteurs;

import java.util.HashMap;

public class TDS {

	private HashMap<Entree, Symbole> tds;
	private int sommetDePile;
	private HashMap<TypesCompteurs, Integer> compteurs;

	private static TDS instance = new TDS();

	private TDS(){
		this.tds=new HashMap<>();
		this.sommetDePile = 0;
		this.compteurs = new HashMap<>();
		compteurs.put(TypesCompteurs.CONDITIONNELLES,0);
		compteurs.put(TypesCompteurs.BLOCS,0);
	}

	public static TDS getInstance(){
		return instance;
	}

	public void ajouter(Entree e, Symbole s) throws DoubleDeclarationException {
		if(tds.containsKey(e)){
			throw new DoubleDeclarationException(e.getNoLigne(),e.getNom());
		}
		tds.put(e,s);
	}

	public Symbole identifier(Entree e) throws VariableNonDeclareeException {
		if(!tds.containsKey(e)){
			throw new VariableNonDeclareeException(e.getNoLigne(),e.getNom());
		}
		return tds.get(e);
	}

	public int newDeplacement(){
		int dep = sommetDePile;
		sommetDePile -= 4;
		return dep;
	}

	public int getSommetDePile() {
		return sommetDePile;
	}

	public int nextCompteur(TypesCompteurs compteur){
		int i = compteurs.get(compteur);
		compteurs.replace(compteur, i + 1);
		return i;
	}

	public int getTailleZoneVariable(Entree e, Symbole s) {
		return 0;
	}

}
