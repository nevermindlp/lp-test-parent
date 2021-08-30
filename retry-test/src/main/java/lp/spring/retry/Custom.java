package lp.spring.retry;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

public class Custom {

    public void method() {
        System.out.println("in method");
        throw new RuntimeException("method exception");
    }

    public void doRetry() throws Throwable {
        // invoke method.
        retryTemplate().execute((RetryCallback<Object, Throwable>) context -> {
            method();
            return null;
        });
        System.out.println("finish invoke");
    }

    public RetryTemplate retryTemplate() {
        RetryTemplate template = new RetryTemplate();
        ExponentialBackOffPolicy policy = new ExponentialBackOffPolicy();
        policy.setInitialInterval(1000);
        policy.setMultiplier(5);
        policy.setMaxInterval(10_000);
        template.setBackOffPolicy(policy);
        return template;
    }

}
