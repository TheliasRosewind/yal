package exceptions;

/**
 * Exception levée lorsqu'une entrée de la tds est en double
 */
public class DoubleDeclarationException extends AnalyseSemantiqueException {

	/**
	 * Constructeur de l'exception
	 * @param ligne ligne du fichier ayant généré l'erreur
	 * @param message message associé à l'erreur
	 */
	public DoubleDeclarationException(int ligne, String message) {
		super(ligne, message + " existe déjà dans ce contexte");
	}

}
