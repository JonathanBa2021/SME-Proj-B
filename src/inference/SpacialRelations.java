package inference;

import java.io.IOException;
import java.util.List;

/**
 * This class loads and handles the list of spacial relations
 */
public class SpacialRelations {
    private static List<String> spacialRelations;

    private static void loadSpacialRelationsFromFile() {
        try {
            spacialRelations = ReadInputFile.readFile("files/spacialRelations.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns all spacial relations
     * 
     * @return List<String>
     */
    public static List<String> getAllSpacialRelations() {
        if (spacialRelations == null)
            loadSpacialRelationsFromFile();
        return spacialRelations;
    }

    /**
     * Checks whether a given string s is a spatial relation
     * 
     * @param s
     * @return boolean
     */
    public static boolean isSpacialRelation(String s) {
        if (spacialRelations == null)
            loadSpacialRelationsFromFile();
        return spacialRelations.contains(s);
    }
}
