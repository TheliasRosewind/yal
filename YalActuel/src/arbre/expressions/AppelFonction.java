package arbre.expressions;

import tds.TDS;
import tds.entrees.EntreeFonction;
import tds.symboles.Symbole;
import tds.types.Type;
import tds.types.TypesVariable;

public class AppelFonction extends Expression {

	private String idf;

	public AppelFonction(String idf, int n) {
		super(n);
		this.idf=idf;
	}

	@Override
	public void verifier() {
		Symbole s = TDS.getInstance().identifier(new EntreeFonction(idf,noLigne));
	}

	@Override
	public String toMIPS() {
		return null; // TODO
	}

	@Override
	public Type getType() {
		return new Type(TypesVariable.ENTIER);
	}
}
