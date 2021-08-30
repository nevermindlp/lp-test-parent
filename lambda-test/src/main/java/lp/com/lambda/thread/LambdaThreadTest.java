package lp.com.lambda.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @author : lvpeng01
 * @since : 2020/12/21
 **/
public class LambdaThreadTest {

    static List<String> list = new ArrayList<>();

    static {
        list.add("1");
        list.add("2");
        list.add("3");

    }

    public static void main(String[] args) {
        List<Future<Pair<String, String>>> futureList = new ArrayList<>();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new
                ArrayBlockingQueue<>(100), threadFactory, (r, executor) -> System.out.println("reject execution."));

        list.forEach(i -> {
            Future<Pair<String, String>> submit = (Future<Pair<String, String>>) executor1.submit(() -> {
                concat(i);
            });
            futureList.add(submit);
        });

        for (Future<Pair<String, String>> f : futureList) {
            try {
                Pair<String, String> p = f.get();
                System.out.println(p.getKey() + "_" + p.getValue());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


    }
    private static Pair concat(String s) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Pair.of(s, s + "a");
    }


}
