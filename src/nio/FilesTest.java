package nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

public class FilesTest {
    public static void main(String[] args) {
       Path p1 = Paths.get("g://a.txt");
       System.out.println(p1.getFileName());
       System.out.println("is file ? "+Files.isRegularFile(p1));

       if(! Files.exists(p1)){
           try {
               Files.createFile(p1);
               System.out.println("新建文件");
           } catch (IOException e) {
               if(e instanceof NoSuchFileException) {
                   System.out.println("此路径不存在");
               }
               e.printStackTrace();
               return;
           }
       }

       //read
        try(BufferedReader bufferedReader = Files.newBufferedReader(p1, StandardCharsets.UTF_8);) {
            String str;
            while((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //write
//        try(BufferedWriter writer = Files.newBufferedWriter(p1)) {
//           writer.write("hi 中国");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //copy
//        try {
//            Files.copy(p1, Paths.get("g://bb.txt") , StandardCopyOption.REPLACE_EXISTING);//覆盖
//            System.out.println("copy file ok");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //delete file
//        try {
//            Files.delete(p1);
//            System.out.println("delete file ok");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //遍历单层目录 newDirectoryStream()
        /**
         *      * @throws  NotDirectoryException
         *      *          if the file could not otherwise be opened because it is not
         *      *          a directory <i>(optional specific exception)</i>
         *      * @throws  IOException
         *      *          if an I/O error occurs
         *      * @throws  SecurityException
         *      *          In the case of the default provider, and a security manager is
         *      *          installed, the {@link SecurityManager#checkRead(String) checkRead}
         *      *          method is invoked to check read access to the directory.
         *
         */
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("g://book"))){
//            for (Path path : stream) {
//                System.out.println(path.getFileName());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //遍历目录包含子目录
//        try {
//            Files.walkFileTree(Paths.get("G:\\db\\data"), new SimpleFileVisitor<Path>(){
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                    System.out.println(file.getFileName());
//                    return FileVisitResult.CONTINUE;
//                }
//
//                @Override
//                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//                    System.out.println("==" + dir.getFileName());
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //create sub dir
//        Path dir = Paths.get("g://");
//        Path subDir = dir.resolve("subDir");
//
//        System.out.println(Files.exists(subDir));
//
//        try {
//            Files.createDirectories(subDir);
//            System.out.println(Files.exists(subDir));
//
//            System.out.println("sub dir create ok");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //create temp file
//        Path p = Paths.get("g://");
//        try {
//            Files.createTempFile(p,null,null);
//            System.out.println(Files.exists(p));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
