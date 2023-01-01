package design.factory;

public class Milk implements Production{

    private String name;

    private String volume;

    public Milk(String name, String volume) {
        this.name = name;
        this.volume = volume;
    }

    @Override
    public void op() {
        System.out.println("打开"+volume+"的"+ name +"牛奶");
    }
}
