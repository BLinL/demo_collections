package design.strategry;

public class Client {
    public static void main(String[] args) {
        AbstractStrategy strategyA = new ConcreteStrategyA();
        AbstractStrategy strategyB = new ConcreteStrategyB();

        Context context = new Context(strategyB);

        context.strategyMethod();
    }
}
