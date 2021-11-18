package inference;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * This class reads files
 */
class ReadInputFile {

    /**
     * Returns the given input file as a list of strings
     * 
     * @param file
     * @return List<String>
     * @throws IOException
     */
    public static List<String> readFile(String file) throws IOException {
        Path filePath = Path.of(file);

        return Files.readAllLines(filePath, StandardCharsets.UTF_8);
    }
}