package lp.daemon;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SimpleTestThread testThread  = new SimpleTestThread();
        testThread.setDaemon(false);
        testThread.start();

        System.out.println("isDaemon" + testThread.isDaemon()); //true

        try {
            int read = System.in.read();
            System.out.println("read " + read);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}