package arbre;

import tds.TDS;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 *
 * @author brigitte wrobel-dautcourt
 */

public class Programme extends ArbreAbstrait {

	protected ArrayList<ArbreAbstrait> programme ;

	protected static String zoneData = ".data\n" +
											"finLigne:      .asciiz \"\\n\"\n" +
											"               .align 2\n" ;

	protected static String debutCode = ".text\n" +
										"main :\n" +
										"     move $s7,$sp                # initialiser $s7 avec $sp\n";
	protected static String finCode =   "end :\n" +
									    "     li $v0, 10                  # retour au système\n" +
									    "     syscall\n" ;

	public Programme() {
		super(1) ;
		programme = new ArrayList<>() ;
	}

	public void ajouter(ArbreAbstrait a) {
		programme.add(a) ;
	}

	@Override
	public String toString() {
		return programme.toString() ;
	}

	@Override
	public void verifier() {
		for (ArbreAbstrait a : programme) {
			a.verifier() ;
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("") ;
		sb.append(zoneData) ;
		sb.append(debutCode) ;
		sb.append("    add $sp, $sp, ");
		sb.append(TDS.getInstance().getSommetDePile());
		sb.append("            # réserver la place pour les variables\n");
		for (ArbreAbstrait a : programme) {
			sb.append(a.toMIPS()) ;
		}
		sb.append(finCode) ;
		return sb.toString() ;
	}

}
