package design.template;

public class ConcreteTemplate1 extends AbstractTemplate{
    @Override
    public void hookMethod() {
        System.out.println("ConcreteTemplate1 执行");
    }
}
