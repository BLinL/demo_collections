package design.Subject;

public class ConcreteObserver2 implements Observer {
    @Override
    public void update() {
        System.out.println("观察者1收到信息，并进行处理");
    }
}
