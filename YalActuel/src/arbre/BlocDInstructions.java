package arbre;

import tds.TDS;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {

	protected ArrayList<ArbreAbstrait> instructions ;

	public BlocDInstructions(int n) {
		super(n) ;
		instructions = new ArrayList<>() ;
	}

	public void ajouter(ArbreAbstrait a) {
		instructions.add(a) ;
	}

	@Override
	public String toString() {
		return instructions.toString() ;
	}

	@Override
	public void verifier() {
		for (ArbreAbstrait a : instructions) {
			a.verifier() ;
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("") ;
		for (ArbreAbstrait a : instructions) {
			sb.append(a.toMIPS()) ;
		}
		return sb.toString() ;
	}

}
