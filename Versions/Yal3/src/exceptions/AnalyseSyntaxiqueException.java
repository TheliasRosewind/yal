package exceptions;

/**
 * Exception levée lorsque l'analyse syntaxique n'est pas correcte
 */
public class AnalyseSyntaxiqueException extends AnalyseException {

	/**
	 * Constructeur de l'exception
	 * @param message message associé à l'erreur
	 */
    public AnalyseSyntaxiqueException(String message) {
        super("ERREUR SYNTAXIQUE :\n\t" + message) ;
    }

}
