package lp.lock.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lvpeng01 on 2019/4/15.
 */
public class StringReentrantLock implements Runnable {

    String str = "hello";
    private static final ReentrantLock lock = new ReentrantLock();

    public StringReentrantLock() {
    }

    public StringReentrantLock(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(str + " " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println(str + " " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new StringReentrantLock(), "one").start();
        new Thread(new StringReentrantLock(), "two").start();
    }
}
