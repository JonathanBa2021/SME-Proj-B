package inference;

import java.util.List;

/**
 * This class gives some helpful methods for dealing with Strings, or for
 * turning complex objects into strings.
 */
public class StringHelper {

    /**
     * Returns a string containing all elements in the given list.
     * 
     * @param list      The List that will be turned into a string
     * @param delimiter The delimiter between entries in the list
     * @return String
     */
    public static <T> String concatList(List<T> list, String delimiter) {
        StringBuilder buffer = new StringBuilder();
        for (T elem : list)
            buffer.append(elem.toString() + delimiter);

        return buffer.toString();
    }

    /**
     * Returns a string containing all elements in the given list, with the
     * delimiter "\n"
     * 
     * @param list The List that will be turned into a string
     * @return String
     */
    public static <T> String concatList(List<T> list) {
        return concatList(list, "\n");
    }
}
