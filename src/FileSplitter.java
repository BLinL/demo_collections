import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件拆分
 */
public class FileSplitter {
    private final String source;
    private final String destination;
    private BufferedWriter curWriter;
    private Path newFilePath;

    // 设置每个文件行数
    private final static int fLine = 10000;
    // 分割后文件前缀
    private final static String outFilePrefix = "out_";

    public FileSplitter(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public static void main(String[] args) {
        String source = "D:\\work&task\\xms_xls_download\\9月\\sql\\bi_report_stock_detail_m9.sql";
        // target folder
        String destination = "D:\\work&task\\xms_xls_download\\9月\\sql\\stock_detail_split";
        new FileSplitter(source, destination).doSplit();
    }

    private void doSplit() {
        BufferedReader bufferReader = getReader(source);
        if (bufferReader == null) {
            System.out.printf("file [%s] is not exists \r\n", source);
            return;
        }

        // init dest folder
        newFilePath = Paths.get(destination);
        if (initDestFolder(newFilePath)) {
            return;
        }
        // init first file
        int lineNumber = 0;
        String newFileName = setFileName((lineNumber + 1) + "_" + fLine);
        if(!changeCurWriter(newFileName)) {
            return;
        }

        try {
            String lineContent;
            int fileIndex = 1;
            while ((lineContent = bufferReader.readLine()) != null) {
                doWrite(curWriter, lineContent);
                lineNumber++;
                if (lineNumber == fLine) {
                    curWriter.close();
                    newFileName =  setFileName((fileIndex * fLine + 1) + "_" + (fileIndex * fLine + fLine));
                    if(!changeCurWriter(newFileName)) {
                        return;
                    }
                    lineNumber = 0;
                    fileIndex++;
                }
            }
            System.out.printf("new file: %d \r\n", fileIndex);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                bufferReader.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    private boolean changeCurWriter(String newFileName) {
        BufferedWriter writer = getWriter(newFileName);
        if (writer == null) {
            return false;
        }else {
            this.curWriter = writer;
            return true;
        }
    }

    private String setFileName(String fileName) {
        return newFilePath.toAbsolutePath()
                + File.separator
                + outFilePrefix + fileName + "_" + getFileSuffix(source);
    }

    private static boolean initDestFolder(Path newFilePath) {
        File outDir = newFilePath.toFile();
        if (!outDir.exists()) {
            if (outDir.mkdir()) {
                return true;
            }
        } else {
            if (!outDir.isDirectory()) {
                return false;
            }
        }
        return false;
    }

    private static File getFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            return null;
        }
        return file;
    }

    private static BufferedReader getReader(String fileName) {
        try {
            File file = getFile(fileName);
            if (file == null) {
                return null;
            }

            return new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    private static BufferedWriter getWriter(String fileName) {
        try {
//            File file = getFile(fileName);
//            if (file == null) {
//                return null;
//            }

            return new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    private static String getFileSuffix(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index != -1) {
            return fileName.substring(index);
        } else {
            return "";
        }
    }

    private static void doWrite(BufferedWriter writer, String lineContent) throws IOException {
        boolean isError = false;
        try {
            writer.write(lineContent);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            isError = true;
        } finally {
            if (isError) {
                writer.close();
            }
        }
    }
}
