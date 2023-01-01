package design.factory;

public class MilkFactory implements Factory{
    @Override
    public Production create() {
        Milk milk = new Milk("伊利", "250ML");
        return milk;
    }
}
