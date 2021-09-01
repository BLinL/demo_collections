package scoket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Time;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class MyClient {

    public static void main(String[] args) throws InterruptedException {
        Socket socket = null;
        OutputStream output = null;
        InputStream inputStream = null;
        Future<?> future = null;
        InputStream input = System.in;
        try {
            socket = new Socket("localhost", 9000);
            output = socket.getOutputStream();
            inputStream = socket.getInputStream();

            InputStream finalInputStream = inputStream;

            //读取 服务端响应信息
            Runnable th = new Runnable() {
                @Override
                public void run() {
                    byte[] bytes = new byte[100];
                    int len = 0;
                    try {
                        while ((len = finalInputStream.read(bytes)) != -1) {
                            System.out.print("接收到服务器返回的消息：");
                            System.out.println(new String(bytes, 0, len));
                        }
                    } catch (IOException e) {
                        try {
                            finalInputStream.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
            };
            new Thread(th).start();
            OutputStream finalOutput = output;
            ObjectOutputStream objOutputStream = new ObjectOutputStream(finalOutput);

            //定时 任务发送‘你好’
            ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
            future = service.scheduleAtFixedRate(() -> {
                try {
//                    finalOutput.write("你好！".getBytes());
//                    finalOutput.flush();
                    System.out.println("client send");
                    objOutputStream.writeObject(new Student("张三"));
                    objOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }, 0, 3, TimeUnit.SECONDS);

        } catch (IOException e) {
            e.printStackTrace();
            try {
                assert output != null;
                output.close();
                input.close();
                System.out.println("关闭socket连接");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

//        Thread.sleep(3000);
//        future.cancel(true);
    }
}
