package arbre.instructions.fonctions;

import arbre.ArbreAbstrait;
import tds.TDS;
import tds.entrees.EntreeFonction;
import tds.symboles.SymboleFonction;

public class Fonction extends ArbreAbstrait{

	protected ArbreAbstrait instruction;

	protected String nom;

	public Fonction(String nom, ArbreAbstrait ins, int n) {
		super(n);
		this.nom=nom;
		this.instruction=ins;
	}

	@Override
	public void verifier() {
		instruction.verifier();
	}

	@Override
	public String toMIPS() {
		SymboleFonction sf=(SymboleFonction)TDS.getInstance().identifier(new EntreeFonction(nom,noLigne));
		StringBuilder sb=new StringBuilder();
		sb.append("FCT_" +  + sf.getNum() + ":\n" +
				"	sw $ra, 0($sp) #Empilage de l'adresse de retour\n" +
				"	addi $sp, $sp, -4\n" +
				"	sw $s7, 0($sp) #Empilage de la base locale précédente\n" +
				"	addi $sp, $sp, -4\n" +
				"	move $s7, $sp #Mise en place de la nouvelle base locale\n" +
				"	#Corps de la fonction\n" +
				instruction.toMIPS() +
				"	#Fin de la fonction\n" +
				"	addi $sp, $sp, 8 #Remise en place du sommet de pile\n" +
				"	lw $s7, 4($sp) #Récupération de la base locale précédente\n" +
				"	lw $t2, 0($sp) #Récupération de l'adresse de retour\n" +
				"	jr $t2 #Retour\n");
		return sb.toString();
	}

}
