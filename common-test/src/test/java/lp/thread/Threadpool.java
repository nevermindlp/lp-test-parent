package lp.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * Created by lvpeng01 on 2018/12/28.
 */
public class Threadpool {

    ScheduledExecutorService expire = Executors.newSingleThreadScheduledExecutor(r -> {
                Thread thread = new Thread(r, "myThread");
                thread.setDaemon(true);
                return thread;
            });

    @Test
    public void test() throws InterruptedException {
        AtomicInteger i = new AtomicInteger(0);
        expire.schedule(() -> System.out.println("hello" + i.getAndIncrement()), 500, TimeUnit.MILLISECONDS);
        expire.schedule(() -> System.out.println("hello" + i.getAndIncrement()), 800, TimeUnit.MILLISECONDS);
        expire.schedule(() -> System.out.println("hello" + i.getAndIncrement()), 100, TimeUnit.MILLISECONDS);
        expire.schedule(() -> System.out.println("hello" + i.getAndIncrement()), 1000, TimeUnit.MILLISECONDS);
        expire.schedule(() -> System.out.println("hello" + i.getAndIncrement()), 2000, TimeUnit.MILLISECONDS);
        expire.schedule(() -> System.out.println("hello" + i.getAndIncrement()), 1200, TimeUnit.MILLISECONDS);
        expire.schedule(() -> System.out.println("hello" + i.getAndIncrement()), 1600, TimeUnit.MILLISECONDS);
        System.out.println("finished..");

        Thread.sleep(3000);
    }

}
