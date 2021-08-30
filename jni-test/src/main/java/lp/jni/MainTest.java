package lp.jni;

import lp.jni.hello.HelloJNI;

/**
 * Created by lvpeng01 on 2018/4/4.
 */
public class MainTest {

    static {
        System.load("/Users/lvpeng01/IdeaProjects/lp-test-parent/jni-test/src/main/java/lp/jni/impl/libhello.jnilib");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                HelloJNI jni = new HelloJNI();
                System.out.println("thread is : " + Thread.currentThread() +
                        "info : " + jni.hello(String.valueOf(finalI)));
                jni.print();
            }).start();
        }

    }
}
