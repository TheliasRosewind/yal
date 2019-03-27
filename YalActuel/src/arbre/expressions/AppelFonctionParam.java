package arbre.expressions;

import arbre.ArbreAbstrait;
import tds.TDS;
import tds.entrees.EntreeFonction;
import tds.types.Type;
import tds.types.TypesVariable;

public class AppelFonctionParam extends Expression {

	private String idf;
	private ArbreAbstrait parametres;

	public AppelFonctionParam(String i, ArbreAbstrait param, int n) {
		super(n);
		this.idf = i;
		this.parametres = param;
	}

	@Override
	public Type getType() {
		return new Type(TypesVariable.ENTIER);
	}

	@Override
	public void verifier() {
		TDS.getInstance().identifier(new EntreeFonction(idf, noLigne));
		this.parametres.verifier();
	}

	@Override
	public String toMIPS() {
		return null;
	}
}
