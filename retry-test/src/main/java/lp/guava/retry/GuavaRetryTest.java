package lp.guava.retry;

import java.util.concurrent.ExecutionException;

import com.github.rholder.retry.RetryException;

public class GuavaRetryTest {

    public static void main(String[] args) {

        Custom c = new Custom();
        try {
            c.externalInvoke();
        } catch (ExecutionException | RetryException e) {
            e.printStackTrace();
        }
        System.out.println("finish invoke.");
    }

}
