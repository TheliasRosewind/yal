package aRefractor;

public abstract class Type {

	private String type; // peut être faire une enum

	public boolean concorde(Type t){
		return this.type.equals(t.type);
	}

}
