package aRefractor;

import aRefractor.exceptions.DoubleDeclarationException;
import aRefractor.exceptions.VariableNonDeclareeException;

import java.util.HashMap;

public class TDS {

	private HashMap<Entree, Symbole> tds;

	private static TDS instance = new TDS();

	private TDS(){}

	public static TDS getInstance(){
		return instance;
	}

	public void ajouter(Entree e, Symbole s) throws DoubleDeclarationException {}

	public Symbole identifier(Entree e) throws VariableNonDeclareeException {
		return null;
	}

	public int getTailleZoneVariable(Entree e, Symbole s) {
		return 0;
	}

}
