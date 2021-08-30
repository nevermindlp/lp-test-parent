package lp.mainthread;

/**
 * jvm 在所有线程都是守护线程的时候，就会退出，存在非守护线程就不会退出。
 *
 * @author : lvpeng01
 * @since : 2020/4/29
 **/
public class MainThreadTest {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("main thread begin , name is : " + threadName);

        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());

        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();
        System.out.println("main thread end , name is : " + threadName);
    }

    public static class MyThread implements Runnable {
        private String threadName = Thread.currentThread().getName();
        @Override
        public void run() {

            System.out.println("my thread begin , name is : " + threadName);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("my thread end , name is : " + threadName);
        }
    }
}
