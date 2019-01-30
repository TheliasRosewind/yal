package arbre.expressions;

import tds.TDS;
import tds.entrees.EntreeVariable;
import tds.symboles.Symbole;
import tds.types.Type;

public class Idf extends Expression {

	private String nom;

	private int dep;

	private Type type;

	public Idf(String nom, int n) {
		super(n);
		this.nom = nom;
	}

	@Override
	public void verifier() {
		Symbole s = TDS.getInstance().identifier(new EntreeVariable(nom, noLigne));
		dep = s.getDeplacement();
		type = s.getType();
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("") ;
		sb.append("    lw $v0, ") ;
		sb.append(dep) ;
		sb.append("($s7)\n") ;
		return sb.toString() ;
	}

	public String getNom() {
		return nom;
	}

	public Type getType(){
		return type;
	}

	public int getDeplacement() {
		return dep;
	}
}
