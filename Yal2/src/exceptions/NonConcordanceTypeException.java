package exceptions;

public class NonConcordanceTypeException extends AnalyseSemantiqueException {

    public NonConcordanceTypeException(int ligne, String m) {
        super(ligne, m+" : types non concordants");
    }
}
