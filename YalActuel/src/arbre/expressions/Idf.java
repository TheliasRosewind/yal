package arbre.expressions;

import tds.TDS;
import tds.entrees.EntreeVariable;
import tds.symboles.Symbole;
import tds.symboles.SymboleVariable;
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
		SymboleVariable s = (SymboleVariable) TDS.getInstance().identifier(new EntreeVariable(nom, noLigne));
		dep = s.getDeplacement();
		type = s.getType();
	}

	@Override
	public String toMIPS() {
		return  "     lw $v0, " + dep + "($s7)\n";
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
