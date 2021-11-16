import java.util.List;

public class AndRelation implements IRelation {
    List<IRelation> relations;

    public AndRelation(List<IRelation> relations) {
        this.relations = relations;
    }

    /**
     * Checks whether this relation uses a given word v
     * 
     * @param v
     * @return boolean
     */
    @Override
    public boolean containsWord(Word v) {
        for (IRelation relation : relations) {
            if (relation.containsWord(v))
                return true;
        }
        return false;
    }

    /**
     * Returns false, because this object is not a word relation
     * 
     * @return boolean
     */
    @Override
    public boolean isWordRelation() {
        return false;
    }

    /**
     * Returns this object represented as a string
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "HGEGEG";
    }
}