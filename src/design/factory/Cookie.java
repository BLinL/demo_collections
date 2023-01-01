package design.factory;

public class Cookie implements Production{

    private String name;

    private String weight;

    public Cookie(String name, String weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public void op() {
        System.out.println("打开"+weight+"的" + name + "饼干");
    }
}
