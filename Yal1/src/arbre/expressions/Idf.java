package arbre.expressions;

import tds.TDS;
import tds.entrees.EntreeVariable;
import tds.symboles.Symbole;
import tds.types.Type;

public class Idf extends Expression {

	private String nom;

	private int dep;

	public Idf(String nom, int n) {
		super(n);
		this.nom = nom;
	}

	@Override
	public void verifier() {
		Symbole s = TDS.getInstance().identifier(new EntreeVariable(nom,noLigne));
		dep = s.getDeplacement();
	}

	@Override
	public String toMIPS() {
		return null;
	}

	public String getNom() {
		return nom;
	}

	public Type getType(){
		//return TDS.getInstance().identifier(new EntreeVariable(this.getNom(), this.getNoLigne()));
		return null;
	}
}
