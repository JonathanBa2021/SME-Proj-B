import java.io.IOException;
import java.util.List;

public class SpacialRelations {
    private static List<String> spacialRelations;

    private static void loadSpacialRelationsFromFile() {
        try {
            spacialRelations = ReadInputFile.readFile("files/spacialRelations.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getAllSpacialRelations() {
        if (spacialRelations == null)
            loadSpacialRelationsFromFile();
        return spacialRelations;
    }
    
    public static boolean isSpacialRelation(String s) {
        if(spacialRelations == null)
            loadSpacialRelationsFromFile();
        return spacialRelations.contains(s);
    }
}
