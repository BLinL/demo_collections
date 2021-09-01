package design;

public class TransportContext {

    private Transport transport;

    public TransportContext(Transport transport) {
        this.transport = transport;
    }

    public void run(){
        transport.run();
    }
}
