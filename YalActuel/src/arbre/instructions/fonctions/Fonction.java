package arbre.instructions.fonctions;

import arbre.ArbreAbstrait;
import exceptions.FonctionSansRetourException;
import tds.TDS;
import tds.entrees.EntreeFonction;
import tds.symboles.SymboleFonction;

import java.util.ArrayList;

public class Fonction extends ArbreAbstrait{

	protected ArbreAbstrait instruction;

	protected String nom;

	public Fonction(String nom, ArbreAbstrait a, int n) {
		super(n);
		this.nom = nom;
		this.instruction = a;
	}

	@Override
	public void verifier() {
		TDS.getInstance().entreeBloc();
		instruction.verifier();
		if(TDS.getInstance().nombreRetours() == 0){
			throw new FonctionSansRetourException(noLigne, "");
		}
		TDS.getInstance().sortieBloc();
	}

	@Override
	public String toMIPS() {
		SymboleFonction sf = (SymboleFonction)TDS.getInstance().identifier(new EntreeFonction(nom, noLigne));
		return  "FCT_" + sf.getNum() + ":\n" +
				"	sw $ra, 0($sp) #Empilage de l'adresse de retour\n" +
				"	addi $sp, $sp, -4\n" +
				//"	sw $s7, 0($sp) #Empilage de la base locale précédente\n" +
				//"	addi $sp, $sp, -4\n" +
				//"	move $s7, $sp #Mise en place de la nouvelle base locale\n" +
				"	#Corps de la fonction\n" +
				//"	sw $s7, 0($sp) #Empilage de la base locale précédente\n" +
				//"	addi $sp, $sp, -4\n" +
				//"	move $s7, $sp #Mise en place de la nouvelle base locale\n" +
				instruction.toMIPS() +
				"		#Fin de la fonction\n" +
				"	FIN_FCT_" + sf.getNum() + ":\n" +
				"	addi $sp, $sp, 4 #Remise en place du sommet de pile\n" +
				//"	lw $s7, -4($sp) #Récupération de la base locale précédente\n" +
				"	sw $v0, 4($sp) #Stockage de la valeur de retour\n" +
				"	lw $v0, 0($sp) #Récupération de l'adresse de retour\n" +
				"	jr $v0 #Retour\n"
				//"	lw $s7, -4($sp) #Récupération de la base locale précédente\n" +
				;
	}

}
