package lp.spring.retry;

public class SpringRetryTest {

    public static void main(String[] args) {
        Custom custom = new Custom();
        try {
            custom.doRetry();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
