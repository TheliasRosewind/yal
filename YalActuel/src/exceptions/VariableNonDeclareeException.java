package exceptions;

/**
 * Exception levée lorsque le programme tente d'utiliser une variable qui n'a pas été déclarée précédemment
 */
public class VariableNonDeclareeException extends AnalyseSemantiqueException {

	/**
	 * Constructeur de l'exception
	 * @param ligne ligne du fichier ayant généré l'erreur
	 * @param message message associé à l'erreur
	 */
	public VariableNonDeclareeException(int ligne, String message) {
		super(ligne, message + " n'est pas déclarée dans le contexte");
	}

}
