package design.Subject;

public class Client {
    public static void main(String[] args) {
        Subject sb = new ConcreateSubject();
        sb.addObserver(new ConcreteObserver1());
        sb.addObserver(new ConcreteObserver2());
        sb.doSomething();
    }
}
