package lp.guava.retry;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;

public class Custom {

    public void method() {
        System.out.println("in method.");
//        throw new RuntimeException("method exception");
    }

    public void externalInvoke() throws ExecutionException, RetryException {
        retryer().call(() -> {
            method();
            return null;
        });
    }

    private Retryer retryer() {
        return RetryerBuilder.<Boolean>newBuilder()
                .retryIfRuntimeException()
                .withWaitStrategy(WaitStrategies.exponentialWait(1000, 6, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(5))
                .build();
    }

}
