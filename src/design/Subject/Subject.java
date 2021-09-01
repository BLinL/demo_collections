package design.Subject;

import java.util.Vector;

/**
 * 被观察者
 */
abstract class Subject {

    /*
     * 存储观察者
     * */
    private Vector<Observer> obs = new Vector();

    /*
    * 添加观察者
    * */
    public void addObserver(Observer obs){
        this.obs.add(obs);
    }
    public void delObserver(Observer obs){
        this.obs.remove(obs);
    }

    //通知观察者
    protected void notifyObserver(){
        for(Observer o: obs){
            o.update();
        }
    }
    public abstract void doSomething();
}
