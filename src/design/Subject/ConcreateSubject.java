package design.Subject;

public class ConcreateSubject extends Subject {

    @Override
    public void doSomething() {
        System.out.println("目标发生变化");
        this.notifyObserver();
    }
}
