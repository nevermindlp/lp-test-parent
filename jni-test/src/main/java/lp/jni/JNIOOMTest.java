package lp.jni;

import lp.jni.hello.HelloJNI;

/**
 * Created by lvpeng01 on 2018/4/4.
 */
public class JNIOOMTest {

    static {
        System.load("/Users/lvpeng01/IdeaProjects/lp-test-parent/jni-test/src/main/java/lp/jni/impl/libhello.jnilib");
    }

    public static void main(String[] args) {
        HelloJNI jni = new HelloJNI();

        String m = "hello";
        int i = 0;
        while(true) {
            jni.hello(String.valueOf(i));
//            m.concat(String.valueOf(i));
            i++;
        }

//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            new Thread(() -> {
//
//                System.out.println("thread is : " + Thread.currentThread() +
//                        "info : " + jni.hello(String.valueOf(finalI)));
//                jni.print();
//            }).start();
//        }

    }
}
