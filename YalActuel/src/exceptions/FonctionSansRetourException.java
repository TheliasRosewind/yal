package exceptions;

/**
 * Exception levée lorsque le programme tente d'utiliser une variable qui n'a pas été déclarée précédemment
 */
public class FonctionSansRetourException extends AnalyseSemantiqueException {

	/**
	 * Constructeur de l'exception
	 * @param ligne ligne du fichier ayant généré l'erreur
	 * @param message message associé à l'erreur
	 */
	public FonctionSansRetourException(int ligne, String message) {
		super(ligne, message + " la fonction n'a pas de retour");
	}

}
