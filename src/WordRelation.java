public class WordRelation {
    public Word wordOne;
    public Word wordTwo;

    public String relation;

    public WordRelation(Word wordOne, Word wordTwo, String relation) {
        this.wordOne = wordOne;
        this.wordTwo = wordTwo;
        this.relation = relation;
    }

    @Override
    public String toString() {
        return relation + "(" + wordOne.word + ", " +  wordTwo.word + ")";
    }
}