package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * 多窗口卖票
 */
public class SellTicket {
    public static void main(String[] args) {
      TicketWindow ticketWindow = new TicketWindow(2000);
      List<Thread> list = new ArrayList<>();
      List<Thread> list1 = new ArrayList<>();
      // 用来存储买出去多少张票
      List<Integer> sellCount = new Vector<>();
      for (int i = 0; i < 2000; i++) {
        Thread t = new Thread(() -> {
          // 分析这里的竞态条件
          int count = ticketWindow.sell(randomAmount());
          sellCount.add(count);
        });
        list.add(t);
        t.start();
      }
      list.forEach((t) -> {
        try {
          t.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
      // 卖出去的票求和
      System.out.format("selled count:%d\n",sellCount.stream().mapToInt(c -> c).sum());
      // 剩余票数
      System.out.format("remainder count:%d\n", ticketWindow.getCount());
    }
    // Random 为线程安全
    static Random random = new Random();
    // 随机 1~5
    public static int randomAmount() {
      return random.nextInt(5) + 1;
    }
  }


class TicketWindow {
    private int count;
    public TicketWindow(int count) {
      this.count = count;
    }

    public int getCount() {
      return count;
    }

    // protected by this
    public synchronized int sell(int amount) {
      if (this.count >= amount) {
        this.count -= amount;
        return amount;
      } else {
        return 0;
      }
    }
}
