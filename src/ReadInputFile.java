import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class ReadInputFile {

    public static List<String> readFile(String file) throws IOException {
        Path filePath = Path.of(file);

        return Files.readAllLines(filePath, StandardCharsets.UTF_8);
    }
}