package tds;

import tds.entrees.Entree;
import tds.symboles.Symbole;
import exceptions.DoubleDeclarationException;
import exceptions.VariableNonDeclareeException;

import java.util.HashMap;

public class TDS {

	private HashMap<Entree, Symbole> tds;

	private static TDS instance = new TDS();

	private TDS(){
		this.tds=new HashMap<>();
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

	public int getTailleZoneVariable(Entree e, Symbole s) {
		return 0;
	}

}
