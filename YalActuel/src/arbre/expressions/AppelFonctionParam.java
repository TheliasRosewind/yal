package arbre.expressions;

import tds.TDS;
import tds.entrees.EntreeFonction;
import tds.entrees.EntreeParametre;
import tds.symboles.Symbole;
import tds.types.Type;
import tds.types.TypesVariable;

public class AppelFonctionParam extends Expression{

	private String idf;
	private Expression parametre;

	public AppelFonctionParam(String i, Expression param, int n) {
		super(n);
		this.idf = i;
		this.parametre = param;
	}

	@Override
	public Type getType() {
		return new Type(TypesVariable.ENTIER);
	}

	@Override
	public void verifier() {
		Symbole s = TDS.getInstance().identifier(new EntreeParametre(idf,noLigne));
	}

	@Override
	public String toMIPS() {
		return null;
	}
}
