package lan;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("s = " + s);

        Path filePath = Paths.get(s, "/src/lan/FileReader.java");
//        Stream<String> lines = Files.lines(filePath);
//
//        // 按行的顺序
//        lines.forEachOrdered(System.out::println);
        long l1 = System.currentTimeMillis();

        // 读小文件更快
        byte[] fileBytes = Files.readAllBytes(filePath);
        String content = new String(fileBytes, Charset.forName("utf-8"));
        System.out.println(content);
        System.out.println(l1 - l);

    }
}
