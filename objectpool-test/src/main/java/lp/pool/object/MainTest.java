package lp.pool.object;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lp.pool.model.Person;

/**
 * Created by lvpeng01 on 2018/11/8.
 */
public class MainTest {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(
            20,
            new ThreadFactoryBuilder().setNameFormat("data-refresh-%d").build());

    public static void main(String[] args) {
        MyObjectPool pool = new MyObjectPool();
        List<CompletableFuture<Person>> completableFutures =
                IntStream.range(0, 20).mapToObj(String::valueOf).map(i -> CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("active num is : " + pool.getPool().getNumActive()
                                + " idle num is : " + pool.getPool().getNumIdle());
                        Person p = pool.getObject();
                        Thread.sleep(2000L);
                        pool.getPool().returnObject(p);
                        return p;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }, threadPool)).collect(toList());

//        System.out.println("done");

        CompletableFuture<Void> allDoneFuture =
                CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[] {}));

        CompletableFuture<List<Person>> listCompletableFuture = allDoneFuture
                .thenApply(v -> completableFutures.stream().map(CompletableFuture::join).collect(toList()));
        listCompletableFuture.join().forEach(System.out::println);

    }
}
