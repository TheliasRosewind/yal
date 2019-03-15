package arbre.instructions.fonctions;

import arbre.ArbreAbstrait;
import tds.TDS;
import tds.entrees.EntreeFonction;
import tds.symboles.SymboleFonction;

public class Fonction extends ArbreAbstrait{

	protected ArbreAbstrait instruction;

	protected Retourne ret;

	protected String nom;

	public Fonction(String nom, ArbreAbstrait a, Retourne r, int n) {
		super(n);
		this.nom=nom;
		this.instruction=a;
		this.ret=r;
	}

	@Override
	public void verifier() {
		TDS.getInstance().entreeBloc();
		instruction.verifier();
		ret.verifier();
		TDS.getInstance().sortieBloc();
	}

	@Override
	public String toMIPS() {
		SymboleFonction sf=(SymboleFonction)TDS.getInstance().identifier(new EntreeFonction(nom,noLigne));
		StringBuilder sb=new StringBuilder();
		sb.append("FCT_" + sf.getNum() + ":\n" +
				"	sw $ra, 0($sp) #Empilage de l'adresse de retour\n" +
				"	addi $sp, $sp, -4\n" +
				//"	sw $s7, 0($sp) #Empilage de la base locale précédente\n" +
				//"	addi $sp, $sp, -4\n" +
				//"	move $s7, $sp #Mise en place de la nouvelle base locale\n" +
				"	#Corps de la fonction\n");
				sb.append(instruction.toMIPS());
				sb.append(ret.toMIPS());
				sb.append("		#Fin de la fonction\n" +
				"	FIN_FCT_" + sf.getNum() + ":\n" +
				"	addi $sp, $sp, 4 #Remise en place du sommet de pile\n" +
				//"	lw $s7, -4($sp) #Récupération de la base locale précédente\n" +
				"	sw $v0, 4($sp) #Stockage de la valeur de retour\n" +
				"	lw $v0, 0($sp) #Récupération de l'adresse de retour\n" +
				"	jr $v0 #Retour\n");
		return sb.toString();
	}

}
