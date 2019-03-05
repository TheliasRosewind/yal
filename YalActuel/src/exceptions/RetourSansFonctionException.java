package exceptions;

/**
 * Exception levée lorsque le programme tente d'utiliser "retourne" alors qu'il n'est pas dans une fonction
 */
public class RetourSansFonctionException extends AnalyseSemantiqueException {

	/**
	 * Constructeur de l'exception
	 * @param ligne ligne du fichier ayant généré l'erreur
	 * @param message message associé à l'erreur
	 */
	public RetourSansFonctionException(int ligne, String message) {
		super(ligne, message + " retour n'est pas dans une fonction");
	}

}
