package inference;

import java.io.IOException;
import java.util.List;

/**
 * This class loads and handles the list of spacial categories
 */
public class SpatialCategories {
    private static List<String> spatialCategories;

    private static void loadSpacialCategoriesFromFile() {
        try {
            spatialCategories = ReadInputFile.readFile("files/spatialCategorys.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns all spacial categories
     * 
     * @return List<String>
     */
    public static List<String> getAllSpacialCategories() {
        if (spatialCategories == null)
            loadSpacialCategoriesFromFile();
        return spatialCategories;
    }

    /**
     * Checks whether a given string s is a spatial category
     * 
     * @param s
     * @return boolean
     */
    public static boolean isSpacialCategory(String s) {
        if (spatialCategories == null)
            loadSpacialCategoriesFromFile();
        return spatialCategories.contains(s);
    }
}
