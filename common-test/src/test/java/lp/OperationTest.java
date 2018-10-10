package lp;

import org.junit.Test;

/**
 * Created by lvpeng01 on 2018/9/5.
 */
public class OperationTest {

    @Test
    public void div() {

        System.out.println(getDis(80D));

    }

    public Double getDis(Double score) {

        return 1 - score / 100;

    }

}
