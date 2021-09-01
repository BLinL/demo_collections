package design.template;

public class ConcreteTemplate extends AbstractTemplate {

    @Override
    public void hookMethod() {
        System.out.println("ConcreteTemplate 执行");
    }
}
