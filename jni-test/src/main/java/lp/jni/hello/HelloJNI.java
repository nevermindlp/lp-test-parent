package lp.jni.hello;

/**
 * 生成头文件需要指定与包路径一样的类路径
 *
 * eg:
 * B000000095139:java lvpeng01$ pwd
 * /Users/lvpeng/workspace/lp-test-parent/jni-test/src/main/java
 * B000000095139:java lvpeng01$ javah -jni lp.jni.hello.HelloJNI
 *
 * Created by lvpeng01 on 2018/4/4.
 */
public class HelloJNI {

    public native String hello(String name);

    public native void print();

}
