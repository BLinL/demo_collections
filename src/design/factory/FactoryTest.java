package design.factory;

public class FactoryTest {
    public static void main(String[] args) {
        Factory milkFactory = new MilkFactory();
        Production milk = milkFactory.create();
        milk.op();

        Factory cookieFactory = new CookieFactory();
        Production cookie = cookieFactory.create();
        cookie.op();
    }
}
