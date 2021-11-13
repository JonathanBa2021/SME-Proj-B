import java.util.Comparator;

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

    public boolean isNoun() {
        return partOfSpeech.startsWith("NN");
    }

    public boolean isBefore(Word w) {
        return placeInSentence < w.placeInSentence;
    }

    public boolean isAfter(Word w) {
        return placeInSentence > w.placeInSentence;
    }

    public boolean isIs() {
        return word.equals("is");
    }

    public boolean isSpacialRelation() {
        return SpacialRelations.isSpacialRelation(word);
    }

    @Override
    public String toString() {
        return word + "#" + partOfSpeech;
    }

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
