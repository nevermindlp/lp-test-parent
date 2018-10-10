package lp.npe;

import org.junit.Test;

/**
 * Created by lvpeng01 on 2018/8/27.
 */
public class ExceptionBreakPoint {

    @Test
    public void testNpe() {

        for (int i = 0; i < 10; i++) {
            int count = 6;
            System.out.println(count/(count - i));
        }

    }

}
