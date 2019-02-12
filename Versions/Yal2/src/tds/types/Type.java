package tds.types;

public class Type {

	private TypesVariable type;

	public Type(TypesVariable type){
		this.type=type;
	}

	public boolean concorde(Type t){
		return this.type == t.type;
	}

}
