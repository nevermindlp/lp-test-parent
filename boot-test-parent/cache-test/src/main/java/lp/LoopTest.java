package lp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : lvpeng01
 * @since : 2022/12/28
 **/
public class LoopTest {

    protected static ThreadPoolExecutor executor = new ThreadPoolExecutor(4,
            4,
            10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10000));

    static String button = "";

    static double size = 0;

    static List l = new ArrayList();

    static Random r = new Random();

    public static void main(String[] args) {

//        executor.submit(LoopTest::process);

        while (true) {
                        String button1 = "true";

                        if (!button1.equals("true")) {
                            System.out.println("button not true");
                        }

                        double size1 = Math.random();
//                        System.out.println("size is : " + size1);
//
//            l.add("test" + r.nextInt());
//            System.out.println(l.size());
        }

    }

    private static void process() {

        while (true) {
//            button = "true";
//
//            if (!button.equals("true")) {
//                System.out.println("button not true");
//            }
//
//            size = Math.random();
//            System.out.println("size is : " + size);

            l.add("test" + r.nextInt());
            System.out.println(l.size());
        }

    }

}
