package design.strategry;

public class Context {
    private AbstractStrategy strategy;

    public Context(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
