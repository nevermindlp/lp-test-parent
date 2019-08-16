package lp.random;

import java.util.Random;

import org.junit.Test;

/**
 * Created by lvpeng01 on 2019/3/29.
 */
public class RandomTest {

    @Test
    public void getRandomNum() {
        Random r = new Random();
        System.out.println(r.nextInt(2));
    }

}
