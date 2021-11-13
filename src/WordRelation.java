/**
 * This class represents a relation between two words. It includes:
 * <ul>
 * <li>wordOne and wordTwo: The words the relation relates</li>
 * <li>relation: The relation between the words</li>
 * </ul>
 */
public class WordRelation {
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
}