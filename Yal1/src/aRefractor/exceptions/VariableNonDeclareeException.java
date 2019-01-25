package aRefractor.exceptions;

import exceptions.AnalyseSemantiqueException;

public class VariableNonDeclareeException extends AnalyseSemantiqueException {

	public VariableNonDeclareeException(int ligne, String m) {
		super(ligne, m);
	}

}
