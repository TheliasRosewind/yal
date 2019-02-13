package arbre.instructions.conditionnelles;

import arbre.ArbreAbstrait;
import arbre.expressions.Expression;
import arbre.instructions.Instruction;
import exceptions.NonConcordanceTypeException;
import tds.TDS;
import tds.types.Type;
import tds.types.TypesCompteurs;
import tds.types.TypesVariable;

public class SiAlors extends Instruction {

    protected Expression e;
    protected ArbreAbstrait si;
	protected ArbreAbstrait sinon;
    protected int identifiant;
    private boolean aSinon;

    public SiAlors(Expression e, ArbreAbstrait si, int noLigne){
        super(noLigne);
        this.si = si;
        this.e = e;
        this.aSinon = false;
    }

    public SiAlors(Expression e, ArbreAbstrait si, ArbreAbstrait sinon, int noLigne){
    	super(noLigne);
	    this.si = si;
	    this.e = e;
	    this.sinon = sinon;
	    this.aSinon = true;
    }

    @Override
    public void verifier() {
        e.verifier();
        si.verifier();
        if (this.aSinon) sinon.verifier();
        if(!e.getType().concorde(new Type(TypesVariable.BOOLEEN))){
            throw new NonConcordanceTypeException(noLigne, "Condition nécessite un booléen");
        }
        identifiant = TDS.getInstance().nextCompteur(TypesCompteurs.CONDITIONNELLES);
    }

    @Override
    public String toMIPS() {
	    String condition = "          # Début Si Alors" + (aSinon ? " Sinon" : "") + "\n" +
			    "     si" + identifiant + ":\n" +
			    e.toMIPS() +
			    "     beq $v0, $zero, " + (aSinon ? "sinon" : "fsi") + identifiant + "\n" +
			    si.toMIPS();

	    if (aSinon) {
		    condition +=   "     b fsi" + identifiant + "\n" +
				    "     sinon" + identifiant + ":\n" +
				    sinon.toMIPS();
	    }

	    condition += "     fsi" + identifiant + ":\n\n";
	    return condition;
    }
}
