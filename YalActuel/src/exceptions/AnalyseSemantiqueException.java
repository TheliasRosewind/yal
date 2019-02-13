package exceptions;

/**
 * Exception levée lorsqu'une erreur sémantique est détectée
 */
public class AnalyseSemantiqueException extends AnalyseException {

	/**
	 * Constructeur de l'exception
	 * @param ligne ligne du fichier ayant généré l'erreur
	 * @param message message associé à l'erreur
	 */
    public AnalyseSemantiqueException(int ligne, String message) {
        super("ERREUR SEMANTIQUE : ligne " + ligne + "\n\t" + message + "\n") ;
    }

}
