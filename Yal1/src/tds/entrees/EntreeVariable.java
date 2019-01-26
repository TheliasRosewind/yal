package tds.entrees;

import java.util.Objects;

public class EntreeVariable extends Entree {

	public EntreeVariable(String nom, int noLigne){
		super(nom,noLigne);
	}

	public boolean equals(Object o){
		if(getClass()!=o.getClass()) return false;
		EntreeVariable e = (EntreeVariable) o;
		return this.nom.equals(e.nom);
	}

	public int hashCode(){
		return Objects.hash(nom);
	}

}
