package exceptions;

/**
 * Exception levée lorsque le fichier contient un caractère non reconnu par le langage
 */
public class AnalyseLexicaleException extends AnalyseException {

	/**
	 * Constructeur de l'exception
	 * @param ligne ligne du fichier ayant généré l'erreur
	 * @param colonne colonne où est située l'erreur
	 * @param message message associé à l'erreur
	 */
    public AnalyseLexicaleException(int ligne, int colonne, String message) {
        super("ERREUR LEXICALE :\n\tligne " + ligne + " colonne " + colonne + "\n\t" + message + " : caractère non reconnu") ;
    }

}
