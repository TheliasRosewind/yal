package exceptions;

import exceptions.AnalyseSemantiqueException;

public class DoubleDeclarationException extends AnalyseSemantiqueException {

	public DoubleDeclarationException(int ligne, String m) {
		super(ligne, m+" existe déjà dans ce contexte");
	}

}
