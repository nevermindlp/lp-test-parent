package lp.lock.originalLock;

/**
 * Created by lvpeng01 on 2019/4/15.
 */
public class StringLock implements Runnable {

    String str = "hello";

    public StringLock() {
    }

    public StringLock(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        synchronized(str) {
            System.out.println(str + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(str + " " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        new Thread(new StringLock("one"), "one").start();
        new Thread(new StringLock("two"), "two").start();
    }
}
