package lp.time;

import java.util.Date;

import org.junit.Test;

/**
 * Created by lvpeng01 on 2018/8/16.
 */
public class TimeTest {

    @Test
    public void timeConvertTest() {
        long time = 19040L;
        System.out.println(new Date(time));

        System.out.println(new Date());
    }

    @Test
    public void testNpe() {
        Boolean flag = null;
        if (!flag) {
            System.out.println("----");
        }
    }

    @Test
    public void testNpe1() {
//        myTest(new Date());
        myTest(null);
    }

    private void myTest(Date d) {
        System.out.println(d.getTime());
    }

}
