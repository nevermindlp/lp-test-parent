package lp.com.lambda.thread;

import java.util.concurrent.Callable;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @author : lvpeng01
 * @since : 2020/12/21
 **/
public class Task implements Callable {

    private String s;
    public Task(String s) {
        this.s = s;
    }

    @Override
    public Pair<String, String> call() {
        return Pair.of(s, s + "a");
    }


}
