package exceptions;

/**
 * Exception levée lorsque le type ne correspond pas à celui attendu
 */
public class NonConcordanceTypeException extends AnalyseSemantiqueException {

	/**
	 * Constructeur de l'exception
	 * @param ligne ligne du fichier ayant généré l'erreur
	 * @param message message associé à l'erreur
	 */
    public NonConcordanceTypeException(int ligne, String message) {
        super(ligne, message + " : types non concordants");
    }

}
