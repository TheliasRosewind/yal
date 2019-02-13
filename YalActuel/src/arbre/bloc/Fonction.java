package arbre.bloc;

import arbre.ArbreAbstrait;

public class Fonction extends ArbreAbstrait{

	protected ArbreAbstrait instruction;
	protected String nomFonc;

	protected Fonction(String nom, ArbreAbstrait ins, int n) {
		super(n);
	}

	@Override
	public void verifier() {
		instruction.verifier();
	}

	@Override
	public String toMIPS() {
		return null;
	}
}
