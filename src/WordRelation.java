/**
 * This class represents a relation between two words. It includes:
 * <ul>
 * <li>wordOne and wordTwo: The words the relation relates</li>
 * <li>relation: The relation between the words</li>
 * </ul>
 */
public class WordRelation implements IRelation {
    public Word wordOne;
    public Word wordTwo;

    public String relation;

    public WordRelation(Word wordOne, Word wordTwo, String relation) {
        this.wordOne = wordOne;
        this.wordTwo = wordTwo;
        this.relation = relation;
    }

    /**
     * Returns a string representing this relation
     * 
     * @return String
     */
    @Override
    public String toString() {
        return relation + "(" + wordOne.word + ", " + wordTwo.word + ")";
    }

    /**
     * Checks whether the Relation uses a given word v
     * 
     * @param v
     * @return boolean
     */
    @Override
    public boolean containsWord(Word v) {
        return wordOne.equals(v) || wordTwo.equals(v);
    }

    /**
     * Returns true, because this object is of type @WordRelation
     * 
     * @return boolean
     */
    @Override
    public boolean isWordRelation() {
        return true;
    }

    /**
     * Returns false, because this object is not of type @ANDRelation
     * 
     * @return boolean
     */
    @Override
    public boolean isANDRelation() {
        return false;
    }
}