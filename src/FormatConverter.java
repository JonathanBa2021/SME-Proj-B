import java.util.ArrayList;
import java.util.List;

class FormatConverter {
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

            /*if (word.equals("."))
                continue;*/

            result.add(word + "#" + partOfSpeech);
        }

        return result;
    }
    
    public static List<Word> convertToWords(List<String> in) {
        List<Word> result = new ArrayList<>();

        for (int i = 0; i < in.size(); i++) {
            String[] split = in.get(i).split("#");
            Word newWord = new Word(split[0].trim(), split[1].trim(), i);

            result.add(newWord);
        }

        return result;
    }
}