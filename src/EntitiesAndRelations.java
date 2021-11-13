import java.util.ArrayList;
import java.util.List;

/**
 * This class is a container for the outputs of the entity and relation
 * extraction This includes:
 * <ul>
 * <li>contraints</li>
 * <li>variables</li>
 * <li>namedEntities</li>
 * <li>unnamnedEntities</li>
 * <li>unidentifiedEntities</li>
 * </ul>
 */
public class EntitiesAndRelations {
    List<WordRelation> constraints = new ArrayList<>();
    List<Word> variables = new ArrayList<>(); // V
    List<Word> namedEntities = new ArrayList<>(); // N
    List<Word> unnamnedEntities = new ArrayList<>(); // UN
    List<Word> unidentifiedEntities = new ArrayList<>(); // UI

    /**
     * Extracts Entities and Relations for a given sentence represented by a list of
     * words
     * 
     * @param in The list of words representing the input sentence
     * @return EntitiesAndRelations
     */
    public static EntitiesAndRelations extractEntitiesAndRelations(List<Word> in) {
        EntitiesAndRelations e = new EntitiesAndRelations();

        // Sort Word-List by place in sentence
        List<Word> words = new ArrayList<>();
        words.addAll(in);
        words.sort(new Word());

        // Add adjacent Nouns together
        words = concatAdjacentNouns(in);

        for (int i = 0; i < words.size(); i++) {
            Word w = words.get(i);
            if (w.isNoun()) {
                e.variables.add(w);
                String category = Gazetter.getCategory(w.word);
                if (category != null) { // If w is in gazetter
                    e.constraints.add(new WordRelation(w, w, "has-name"));
                    e.constraints.add(new WordRelation(w, new Word(category), "is"));
                    e.namedEntities.add(w);
                } else if (SpatialCategories.isSpacialCategory(w.word)) { // if w is in lexicon as a spacial category
                    e.constraints.add(new WordRelation(w, w, "is"));
                    e.unnamnedEntities.add(w);
                } else {
                    e.unidentifiedEntities.add(w);
                }
            } else {
                if (w.isSpacialRelation() || w.isIs()) {
                    // Adds relations using the word w as a relation, connecting all nouns before
                    // with all nouns after the word w
                    for (int j = i - 1; j >= 0; j--) {
                        Word leftWord = words.get(j);
                        if (!leftWord.isNoun())
                            continue;

                        for (int k = i + 1; k < words.size(); k++) {
                            Word rightWord = words.get(k);
                            if (!rightWord.isNoun())
                                continue;
                            e.constraints.add(new WordRelation(leftWord, rightWord, w.word));
                        }
                    }
                }
            }
        }

        return e;
    }

    /**
     * Concats adjacent nouns into a singular noun
     * 
     * @param words
     * @return List<Word>
     */
    private static List<Word> concatAdjacentNouns(List<Word> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            if (words.get(i).isNoun() && words.get(i + 1).isNoun()) {
                Word word = words.get(i + 1);
                words.remove(i + 1);

                words.get(i).word += " " + word.word;
                // words.get(i).partOfSpeech = "NN";
                i--;
            }
        }

        return words;
    }

    /**
     * Returns a string representing this @EntitiesAndRelations
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "EntitiesAndRelations:" + "\n\tconstraints:\n\t\t" + StringHelper.concatList(constraints, "\n\t\t")
                + "\n\tvariables:\n\t\t" + StringHelper.concatList(variables, "\n\t\t") + "\n\tnamedEntities:\n\t\t"
                + StringHelper.concatList(namedEntities, "\n\t\t") + "\n\tunnamnedEntities:\n\t\t"
                + StringHelper.concatList(unnamnedEntities, "\n\t\t") + "\n\tunidentifiedEntities:\n\t\t"
                + StringHelper.concatList(unidentifiedEntities, "\n\t\t");
    }
}