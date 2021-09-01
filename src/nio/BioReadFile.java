package nio;

import java.io.*;

public class BioReadFile {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("E:\\upload\\1577670105884.jpg");
        OutputStream outputStream = new FileOutputStream("E:\\upload\\ccc.jpg");
        byte[] buf = new byte[1024];
        int len;
        int available  = inputStream.available();

        if(available != 0) {
            while ((len = inputStream.read(buf, 0 ,1024)) != -1) {
                System.out.println(len);
                outputStream.write(buf,0,buf.length);
            }
        }
//        while((len = inputStream.read(buf, 0 ,1024)) != -1) {
//            outputStream.write(buf,0,len);
//        }

        try {
            inputStream.close();
            outputStream.close();
        } catch (IOException ioException) {

        }

        System.out.println("copy finished!");
    }
}
