package scoket;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {

    public static void main(String[] args) {

        int count = 0;

        ExecutorService executor = Executors.newFixedThreadPool(4);
        try {
            //创建套接字 监听请求
            ServerSocket serverSocket = new ServerSocket(9000);
            //serverSocket.setSoTimeout(5000);
            System.out.println("server start on 9000");
            while (true) {
                //阻塞 等待连接建立
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(5000);
                executor.execute(new ServerHandleTask(socket));
                count++;
                System.out.println("connected count :" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class ServerHandleTask implements Runnable {

        private final Socket socket;

        ServerHandleTask(@NotNull Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            handlerSocket(socket);
        }

        private static void handlerSocket(Socket socket) {
            OutputStream output = null;
            System.out.println(socket.getInetAddress());
//            int timeLimit = 1000;
//            long endTime = System.currentTimeMillis() + timeLimit;

//            try {
//                socket.setSoTimeout(timeLimit);
//            } catch (SocketException e) {
//                System.out.println("set sotimeout ");
//                e.printStackTrace();
//            }
            try {
//                Thread.sleep(10000);
                InputStream input = socket.getInputStream();
                output = socket.getOutputStream();
                ObjectInputStream ois = new ObjectInputStream(input);
                while(true){
                    Student obj = (Student)ois.readObject();
                    System.out.println(obj.getName());
                }

//                byte[] bytes = new byte[1024];
//                int len;
//                while ((len = input.read(bytes)) != -1) { //阻塞
//                    System.out.println("收到数据");
//                    System.out.println(new String(bytes, 0, len));
//
////                    timeLimit = (int)(endTime - System.currentTimeMillis());
////                    socket.setSoTimeout(timeLimit);
//
//                    output.write(bytes, 0 ,len);//发回客户端
//                    output.flush();
//                }
//                System.out.println("=======");
            } catch (IOException e) {
                if(e instanceof SocketTimeoutException){
                    System.out.println("1 set sotimeout ");

                }
                e.printStackTrace();
                try {
                    if(output != null) {
                        output.close();
                        System.out.println("连接关闭");
                    }
                } catch (IOException e1) {
                    System.out.println("连接失败");
                    e1.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
