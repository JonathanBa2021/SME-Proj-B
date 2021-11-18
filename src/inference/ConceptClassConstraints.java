package inference;

import java.util.ArrayList;
import java.util.List;

public class ConceptClassConstraints {
    List<IRelation> relations = new ArrayList<>();
    List<Word> inferredEntities = new ArrayList<>();

    /**
     * Generates the concept class constraints for a given @EntitiesAndRelations
     * 
     * @param entitiesAndRelations
     * @return ConceptClassConstraints
     */
    public static ConceptClassConstraints generateConceptClassConstrainsts(EntitiesAndRelations entitiesAndRelations) {
        ConceptClassConstraints c = new ConceptClassConstraints();

        c.relations.addAll(entitiesAndRelations.constraints);

        List<Word> entities = new ArrayList<>();
        entities.addAll(entitiesAndRelations.namedEntities);
        entities.addAll(entitiesAndRelations.unidentifiedEntities);

        for (Word w : entities) {
            for (Word v : entitiesAndRelations.unnamnedEntities) {
                int distance = Math.abs(w.placeInSentence - v.placeInSentence);
                if (distance == 1) {
                    c = addAndRelations(c, w, v);
                }
            }
            if (!c.inferredEntities.contains(w)) {
                for (Word v : entitiesAndRelations.unnamnedEntities) {
                    // TODO Fix Implementation
                    boolean vIsUsed = false;
                    for (IRelation relation : c.relations) {
                        if (relation.containsWord(v)) {
                            vIsUsed = true;
                            break;
                        }
                    }
                    if (vIsUsed)
                        continue;

                    c = addAndRelations(c, w, v);
                }
            }
        }

        return c;
    }

    /**
     * Adds the AND relations as detailed by Alogrithm 2 (Line 6,7 / 12,13) in Prof.
     * Wolters Paper
     * 
     * @param c
     * @param w
     * @param v
     * @return ConceptClassConstraints
     */
    private static ConceptClassConstraints addAndRelations(ConceptClassConstraints c, Word w, Word v) {
        for (IRelation r : c.relations) {
            if (!r.isWordRelation())
                continue;
            WordRelation rel = (WordRelation) r;
            if (rel.wordOne.equals(v) && rel.relation.equals("is")) {
                List<IRelation> newRelations = new ArrayList<>();
                newRelations.add(new WordRelation(w, rel.wordTwo, "is"));
                newRelations.add(new WordRelation(w, w, "has-name"));

                c.relations.add(new AndRelation(newRelations));

                c.inferredEntities.add(w);
            }
        }
        return c;
    }

    /**
     * Returns a representation of the object as string
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "ConceptClassConstraints:\n" + "\tinferredEntities:\n\t\t"
                + StringHelper.concatList(inferredEntities, "\n\t\t") + "\n\trelations:\n\t\t"
                + StringHelper.concatList(relations, "\n\t\t");
    }
}
