package lp.qps;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.google.common.util.concurrent.RateLimiter;

/**
 * @author : lvpeng01
 * @since : 2023/6/6
 **/
public class DynamicQPSTest {

    RateLimiter rateLimiter1 = RateLimiter.create(100);
    RateLimiter rateLimiter2 = RateLimiter.create(700);
    RateLimiter rateLimiter3 = RateLimiter.create(600);
    Random r = new Random();
    Random r1 = new Random();
    AtomicInteger i = new AtomicInteger();

    @JunitPerfConfig(threads = 100, duration = 5000)
    public void qpsTest() {
        step1();
        step2();
        step3();
//        System.out.println("workflow finished." + i.get());
    }

    /**
     * QPS ： 100
     */
    private void step1() {
        boolean b = r.nextBoolean();
        boolean b1 = r1.nextBoolean();
        if (b && b1) {
            rateLimiter1.acquire();
            int i = this.i.incrementAndGet();
            System.out.println("count num = : " + i);
        }
//        rateLimiter1.acquire();
    }

    /**
     * QPS ： 200
     */
    private void step2() {
        rateLimiter2.acquire();
    }

    /**
     * QPS ： 100
     */
    private void step3() {
        rateLimiter3.acquire();
    }

}
