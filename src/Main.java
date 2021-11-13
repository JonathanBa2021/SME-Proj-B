import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> file = ReadInputFile.readFile("files/input3.txt.out");
        file = FormatConverter.stanfordNLPToOur(file);
        // System.out.println(StringHelper.concatList(file));

        List<Word> words = FormatConverter.convertToWords(file);
        // System.out.println(StringHelper.concatList(words));

        EntitiesAndRelations entitiesAndRelations = EntitiesAndRelations.extractEntitiesAndRelations(words);

        System.out.println(entitiesAndRelations);
    }
}