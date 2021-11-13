import java.io.IOException;
import java.util.List;

public class SpatialCategories {
    private static List<String> spatialCategories;

    private static void loadSpacialCategoriesFromFile() {
        try {
            spatialCategories = ReadInputFile.readFile("files/spatialCategorys.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getAllSpacialCategories() {
        if (spatialCategories == null)
            loadSpacialCategoriesFromFile();
        return spatialCategories;
    }
    
    public static boolean isSpacialCategory(String s) {
        if(spatialCategories == null)
            loadSpacialCategoriesFromFile();
        return spatialCategories.contains(s);
    }
}
