package thread.wait;

public class WaitTest {
    public static void main(String[] args) {
        PrintService printService = new PrintService();
        new Thread(printService::printChar).start();
        new Thread(printService::printNumber).start();
    }
}

class PrintService {
    private int number = 0;

    public PrintService() {}

    public void increment() {
        this.number = number + 1;
    }

    // 等待唤醒机制 wait，notify 必须和锁一起使用
    // 这是因为 等待还是唤醒是根据condition决定的 并且状态在线程间需要同步改变（假如两个线程看到的条件处于不一致状态 必然会产生混乱 那么根据条件来决定是否阻塞还是唤醒 就没有意义了）
    // 而使用同一把对象锁（就可以保证同一时间只能有一个线程修改条件） 线程间观测到的条件自然就是一致的
    // 为什么条件不一致会产生混乱？ 假如存在 A，B两个线程 A线程判断条件满足才wait ，（这里进行说明A wait之后势必要唤醒其他线程的因为自己要靠其他线程在某个时刻唤醒 所以A要
    //改变条件并唤醒其他线程） 假如只有两个线程这里就是B，假如A正要执行wait还没有执行的时候，B突然获得时间片并把条件修改了 ，由于条件只有两种状态对应是否wait，那么A再次判断条件是就不满足wait
    //此时就会执行修改状态的操作 条件就被修改了两次 等于没有被修改一样， A就会永远wait
    public synchronized void printChar() {
        for (int i = 1; i <= 52; i+=2) {
            if(number % 2 != 0) { //跟 printNumber 条件相反
                try {
                    wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            System.out.println(i);
            System.out.println(i + 1);
            increment();//改变条件
            notify();
        }
    }

    public synchronized void printNumber() {
        for (int i = 65; i <= 90; i++) {
            if(number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            System.out.println((char) i);
            increment();
            notify();
        }
    }
}

