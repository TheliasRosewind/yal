package arbre.expressions;

import tds.TDS;
import tds.entrees.EntreeFonction;
import tds.symboles.Symbole;
import tds.symboles.SymboleFonction;
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
		StringBuilder sb=new StringBuilder();
		sb.append("	#Appel de fonction\n" +
				"	addi $sp, $sp, -4 #Réservation de la place pour la valeur de retour\n" +
				"	jal FCT_" + ((SymboleFonction)TDS.getInstance().identifier(new EntreeFonction(idf,noLigne))).getNum() + "\n" +
				"	lw $v0, 4($sp)	#Récupération de la valeur de retour\n" +
				"	addi $sp, $sp, 4\n");
		return sb.toString();
	}

	@Override
	public Type getType() {
		return new Type(TypesVariable.ENTIER);
	}
}
