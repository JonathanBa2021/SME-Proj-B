import java.util.List;

public class StringHelper {
    public static <T> String concatList(List<T> list, String between) {
        StringBuilder buffer = new StringBuilder();
        for (T elem : list)
            buffer.append(elem.toString() + between);

        return buffer.toString();
    }
    
    public static <T> String concatList(List<T> list) {
        return concatList(list, "\n");
    }
}
