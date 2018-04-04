package lp.jni;

import lp.jni.hello.HelloJNI;

/**
 * Created by lvpeng01 on 2018/4/4.
 */
public class MainTest {

    static {
        System.load("/Users/lvpeng/workspace/lp-test-parent/jni-test/src/main/java/lp/jni/impl/libhello.jnilib");
    }

    public static void main(String[] args) {
        HelloJNI jni = new HelloJNI();
        System.out.println(jni.hello("lvpeng"));
        jni.print();
    }
}
