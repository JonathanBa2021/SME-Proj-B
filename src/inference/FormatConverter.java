package inference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains functions for converting files between different formats
 */
class FormatConverter {
    // The delimiter used in our annotation format
    public static final String DELIMITER = "#";

    /**
     * Transforms a list of strings in the StandfordNLP format to our annotation
     * format
     * 
     * @param in List of strings given in the StanfordNLP format
     * @return List<String>
     */
    public static List<String> stanfordNLPToOur(List<String> in) {
        List<String> result = new ArrayList<>();

        for (String s : in) {
            if (!s.startsWith("["))
                continue;

            int wordBeginIndex = s.indexOf("Text=") + "Text=".length();
            int wordEndIndex = s.indexOf("CharacterOffsetBegin=") - 1;
            String word = s.substring(wordBeginIndex, wordEndIndex);

            int posBeginIndex = s.indexOf("PartOfSpeech=") + "PartOfSpeech=".length();
            int posEndIndex = s.indexOf("Lemma=") - 1;
            String partOfSpeech = s.substring(posBeginIndex, posEndIndex);

            /*
             * if (word.equals(".")) continue;
             */

            result.add(word + DELIMITER + partOfSpeech);
        }

        return result;
    }

    /**
     * Turns the given list of strings into a list of type @Word. The strings have
     * to be formated in our notation
     * 
     * @param in
     * @return List<Word>
     * @throws IOException
     */
    public static List<Word> convertToWords(List<String> in) throws IOException {
        List<Word> result = new ArrayList<>();

        for (int i = 0; i < in.size(); i++) {
            String[] split = in.get(i).split(DELIMITER);
            if (split.length < 2)
                throw new IOException("Input for convertToWords is not in correct Format");

            Word newWord = new Word(split[0].trim(), split[1].trim(), i);

            result.add(newWord);
        }

        return result;
    }
}