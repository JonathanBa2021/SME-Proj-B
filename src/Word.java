import java.util.Comparator;

/**
 * This class represents a word in a sentence. It includes:
 * <ul>
 * <li>word: The word as a string</li>
 * <li>partOfSpeech: The Part ff Speech as a string</li>
 * <li>placeInSentence: The position at which the word was located in the
 * sentence</li>
 * </ul>
 */
public class Word implements Comparator<Word> {

    public String word;
    public String partOfSpeech;
    public int placeInSentence;

    public Word(String word, String partOfSpeech, int placeInSentence) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.placeInSentence = placeInSentence;
    }

    public Word() {
    }

    public Word(String word) {
        this(word, "", -1);
    }

    /**
     * Returns whether this word is a noun
     * 
     * @return boolean
     */
    public boolean isNoun() {
        return partOfSpeech.startsWith("NN");
    }

    /**
     * Returns whether this word comes before a different word in a sentence
     * 
     * @param w
     * @return boolean
     */
    public boolean isBefore(Word w) {
        return placeInSentence < w.placeInSentence;
    }

    /**
     * Returns whether this word comes after a different word in a sentence
     * 
     * @param w
     * @return boolean
     */
    public boolean isAfter(Word w) {
        return placeInSentence > w.placeInSentence;
    }

    /**
     * Returns whether this word is the verb "is"
     * 
     * @return boolean
     */
    public boolean isIs() {
        return word.equals("is");
    }

    /**
     * Returns whether this word is a spacial relation, given by @SpacialRelations
     * 
     * @return boolean
     */
    public boolean isSpacialRelation() {
        return SpacialRelations.isSpacialRelation(word);
    }

    /**
     * Returns a string representing this word
     * 
     * @return String
     */
    @Override
    public String toString() {
        return word + FormatConverter.DELIMITER + partOfSpeech;
    }

    /**
     * Compares two words by their place in a sentence
     * 
     * Returns -1, iff o1 comes before o2 Returns 0, iff o1 is at the same spot as
     * o2. This should never happen Returns 1, iff o1 comes after o2
     * 
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(Word o1, Word o2) {
        if (o1.placeInSentence < o2.placeInSentence) {
            return -1;
        }
        if (o1.placeInSentence > o2.placeInSentence) {
            return 1;
        }
        return 0;
    }
}
