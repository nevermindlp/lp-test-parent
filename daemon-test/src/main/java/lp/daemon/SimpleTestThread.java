package lp.daemon;

public class SimpleTestThread extends Thread {
    public static boolean run = true;

    public SimpleTestThread() {
        super("simpleTestThreat");
    }

    public void run() {
        while(run) {
            try {
                System.out.println("I am alive.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
