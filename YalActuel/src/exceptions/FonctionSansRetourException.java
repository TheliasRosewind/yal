package exceptions;

public class FonctionSansRetourException extends AnalyseSemantiqueException{

	/**
	 * Constructeur de l'exception
	 *
	 * @param ligne   ligne du fichier ayant généré l'erreur
	 * @param message message associé à l'erreur
	 */
	public FonctionSansRetourException(int ligne, String message) {
		super(ligne, message + "fonction sans retour");
	}
}
