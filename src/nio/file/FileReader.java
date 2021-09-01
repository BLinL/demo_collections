package nio.file;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author bliu
 * @date 2021-03-15 14:05
 */
public class FileReader {
    public static void main(String[] args) throws IOException, URISyntaxException {
//read small file
        Path path = Paths.get("src/nio/file/FileReader.java");
        List<String> read = Files.readAllLines(path);
        for(String line : read) {
            System.out.println(line);
        }

//        readLageFile();
    }

    public static void readLageFile() throws URISyntaxException, IOException {
        Path path = Paths.get(FileReader.class.getResource("src/nio/file/FileReader.java").toURI());
        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();

        System.out.println(data);
    }
}
