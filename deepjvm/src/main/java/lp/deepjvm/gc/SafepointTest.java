package lp.deepjvm.gc;

/**
 * // time java SafepointTestp
 * / 你还可以使用如下几个选项
 * // -XX:+PrintGC
 * // -XX:+PrintGCApplicationStoppedTime
 * // -XX:+PrintSafepointStatistics
 * // -XX:+UseCountedLoopSafepoints
 * <p>
 * Created by lvpeng01 on 2019/4/28.
 */
public class SafepointTest {

    static double sum = 0;

    public static void foo() {
        for (int i = 0; i < 0x77777777; i++) {
            sum += Math.sqrt(i);
        }
    }

    public static void bar() {
        for (int i = 0; i < 50_000_000; i++) {
            new Object().hashCode();
        }
    }

    public static void main(String[] args) {
        System.out.println("start...");
        long startTime = System.currentTimeMillis();
        new Thread(SafepointTest::foo).start();
//        new Thread(SafepointTest::bar).start();
        System.out.println("end ... cost : " + (System.currentTimeMillis() - startTime));
    }

}
