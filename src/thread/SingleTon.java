package thread;

/**
 * 单例内部类
 */
public final class SingleTon {
  private SingleTon(){}

  private static class LazyLoder{
    static final SingleTon INSTANCE = new SingleTon();
  }

  public static SingleTon getInstance(){
    return LazyLoder.INSTANCE;
  }

  public static void main(String[] args) {
    SingleTon s1 = SingleTon.getInstance();
    SingleTon s2 = SingleTon.getInstance();

    System.out.println(s1 == s2);
  }
}
