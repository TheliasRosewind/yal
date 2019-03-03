package arbre.instructions.declarations;

import arbre.ArbreAbstrait;

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
		return null; // TODO
	}

}
