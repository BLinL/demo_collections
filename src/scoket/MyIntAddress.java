package scoket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyIntAddress {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress a = InetAddress.getByName("DESKTOP-G66FL2F");
        InetAddress local = InetAddress.getByName(null);
        System.out.println(a);
        System.out.println(local);
    }
}
