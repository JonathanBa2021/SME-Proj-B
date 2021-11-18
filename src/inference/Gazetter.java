package inference;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class loads and handles the gazetter
 */
public class Gazetter {
    private static HashMap<String, String> gazetter;

    private static void loadSpacialRelationsFromFile() {
        List<String> strings = null;
        try {
            strings = ReadInputFile.readFile("files/gazetter.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (strings == null)
            return;
        gazetter = new HashMap<>();
        for (String s : strings) {
            String[] split = s.split(",");
            gazetter.put(split[0].trim(), split[1].trim());
        }
    }

    /**
     * Returns the full gazetter
     * 
     * @return Map<String, String>
     */
    public static Map<String, String> getAllSpacialRelations() {
        if (gazetter == null)
            loadSpacialRelationsFromFile();
        return gazetter;
    }

    /**
     * Returns the category of the given string s. If s is not listed, it returns
     * null.
     * 
     * @param s
     * @return String
     */
    public static String getCategory(String s) {
        if (gazetter == null)
            loadSpacialRelationsFromFile();
        return gazetter.get(s);
    }
}
