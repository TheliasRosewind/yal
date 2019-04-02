package arbre.bloc;

import arbre.ArbreAbstrait;
import tds.TDS;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 *
 * @author brigitte wrobel-dautcourt
 */

public class Programme extends ArbreAbstrait {

	protected ArrayList<ArbreAbstrait> declarations;
	protected ArrayList<ArbreAbstrait> fonctions;
	protected ArrayList<ArbreAbstrait> programme ;

	protected static String zoneData = ".data\n" +
											"finLigne:      .asciiz \"\\n\"\n" +
											"               .align 2\n" +
											"\n" ;

	protected static String debutCode = "main :\n" +
										"	  li $v0, 0\n" +
										"	  sw $v0, 0($sp)\n" +
										"	  addi $sp, $sp, -4\n" +
										"     move $s7,$sp                # initialiser $s7 avec $sp\n" ;
	protected static String finCode =   "end :\n" +
									    "     li $v0, 10                  # retour au système\n" +
									    "     syscall\n" ;

	public Programme() {
		super(1) ;
		programme = new ArrayList<>() ;
		declarations = new ArrayList<>();
	}

	public void ajouter(ArbreAbstrait a) {
		programme.add(a) ;
	}

	public void ajouterDeclaration(ArbreAbstrait a) {declarations.add(a);}

	public void ajouterFonction(ArbreAbstrait a) {declarations.add(a);}

	@Override
	public String toString() {
		return programme.toString() ;
	}

	@Override
	public void verifier() {
		for(ArbreAbstrait d : declarations){
			d.verifier();
		}
		for (ArbreAbstrait a : programme) {
			a.verifier() ;
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("") ;
		sb.append(zoneData) ;
		sb.append(".text\n");
		sb.append(debutCode) ;
		sb.append("     add $sp, $sp, ");
		sb.append(TDS.getInstance().getSommetDePile());
		sb.append("           # réserver la place pour les variables\n\n");
		for(ArbreAbstrait e : declarations){
			sb.append(e.toMIPS());
		}
		for (ArbreAbstrait a : programme) {
			sb.append(a.toMIPS()) ;
		}
		sb.append(finCode) ;
		for(ArbreAbstrait d : fonctions){
			sb.append(d.toMIPS());
		}
		return sb.toString() ;
	}

}
