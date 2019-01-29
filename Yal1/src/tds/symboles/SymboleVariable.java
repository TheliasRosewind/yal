package tds.symboles;

public class SymboleVariable extends Symbole {

	private int deplacement;

	public SymboleVariable(int deplacement){
		this.deplacement = deplacement;
	}

	@Override
	public int getDeplacement() {
		return deplacement;
	}
}
