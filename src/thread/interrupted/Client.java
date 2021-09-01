package thread.interrupted;

public class Client {
    public static void main(String[] args) {
        Runnable target = new MyTask();
        Thread thread = new Thread(target);
        thread.start();
//        System.out.println("Interrupted "+thread.interrupted());

        thread.interrupt();
        System.out.println("isInterrupted "+thread.isInterrupted());

    }
}
