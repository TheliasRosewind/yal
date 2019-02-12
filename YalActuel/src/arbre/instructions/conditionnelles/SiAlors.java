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
    protected int identifiant;

    public SiAlors(Expression e, ArbreAbstrait si, int noLigne){
        super(noLigne);
        this.si = si;
        this.e = e;
    }

    @Override
    public void verifier() {
        e.verifier();
        si.verifier();
        if(!e.getType().concorde(new Type(TypesVariable.BOOLEEN))){
            throw new NonConcordanceTypeException(noLigne, " condition nécessite un booléen");
        }
        identifiant = TDS.getInstance().nextCompteur(TypesCompteurs.CONDITIONNELLES);
    }

    @Override
    public String toMIPS() {
        return  "          #Début Si Alors\n" +
                "     si" + identifiant + ":\n" +
                e.toMIPS() +
                "     beq $v0 , $zero ,fsi" + identifiant + "\n" +
                si.toMIPS() +
                "     fsi" + identifiant + ":\n" +
                "\n";
    }
}
