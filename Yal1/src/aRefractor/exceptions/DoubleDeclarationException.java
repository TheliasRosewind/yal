package aRefractor.exceptions;

import exceptions.AnalyseSemantiqueException;

public class DoubleDeclarationException extends AnalyseSemantiqueException {

	public DoubleDeclarationException(int ligne, String m) {
		super(ligne, m);
	}

}
