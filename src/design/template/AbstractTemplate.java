package design.template;

public abstract class AbstractTemplate {

    public void funA(){
        System.out.println("执行A");
    }

    public void funB(){
        System.out.println("执行B");

    }

    public void funC(){
        System.out.println("执行C");
    }

    public abstract void hookMethod();


    /**
     * 替换中间某一动态部分
     */
    public void templateMethod() {
        funA();
        funB();
        funC();
        hookMethod();
    }
}
