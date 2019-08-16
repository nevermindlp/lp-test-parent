package lp.lock.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lvpeng01 on 2019/4/15.
 */
public class ReadWriteReentrantLock implements Runnable {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();
    String str = "hello";

    @Override
    public void run() {
        readLock.lock();
        try {
            System.out.println(str + " " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println(str + " " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new ReadWriteReentrantLock(), "one").start();
        new Thread(new ReadWriteReentrantLock(), "two").start();
    }
}
