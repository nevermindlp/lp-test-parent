package lp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String test = "1#lp";

        String[] a = test.split("#");

        System.out.println(a[0] + "-" + a[1]);
    }

}
