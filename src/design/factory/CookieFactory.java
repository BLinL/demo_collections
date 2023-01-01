package design.factory;

public class CookieFactory implements Factory{
    @Override
    public Production create() {
        return new Cookie("奥利奥", "100g");
    }
}
