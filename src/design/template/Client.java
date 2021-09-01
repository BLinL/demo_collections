package design.template;

public class Client {
    public static void main(String[] args) {
        AbstractTemplate template = new ConcreteTemplate();
        template.templateMethod();

        AbstractTemplate template1 = new ConcreteTemplate1();
        template1.templateMethod();
    }
}
