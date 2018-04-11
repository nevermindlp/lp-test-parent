package lp.classloader.external;

import lp.classloader.external.HelloInterface;

/**
 * Created by lvpeng01 on 2018/4/9.
 */
public class Hello implements HelloInterface {

    public void say() {
        System.out.println("external say hello.");
    }

    public void hello(String str) {
        System.out.println("external hello " + str);
    }

}
