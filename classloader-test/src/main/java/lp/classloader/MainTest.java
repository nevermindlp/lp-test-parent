package lp.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lp.classloader.external.HelloInterface;

/**
 * Created by lvpeng01 on 2018/4/9.
 */
public class MainTest {

    public static void main(String[] args) {

        HelloInterface o;
        String filePath = "/Users/lvpeng/external/";
        String classPath = "lp.classloader.external.Hello";
        LpClassLoader lpClassLoader1 = new LpClassLoader(filePath);
        LpClassLoader lpClassLoader2 = new LpClassLoader(filePath);
        try {
            Class c1 = lpClassLoader1.loadClass(classPath);
            Object o1 = c1.newInstance();
            o = (HelloInterface) o1;
            System.out.println("hello impl classloader is :" + o.getClass().getClassLoader());
            System.out.println("helloInterface say : ");
            o.say();
            System.out.println("new classloader is: " + o1.getClass().getClassLoader());
            System.out.println("reflect invoke.... say : ");
            Method method1 = c1.getDeclaredMethod("say", null);
            method1.invoke(o1, null);


            // in some case to reload class.
            Class c2 = lpClassLoader2.loadClass(classPath);
            Object o2 = c2.newInstance();
            o = (HelloInterface) o2;
            System.out.println("hello impl classloader is :" + o.getClass().getClassLoader());
            System.out.println("helloInterface say : ");
            o.say();
            System.out.println("new classloader is: " + o2.getClass().getClassLoader());
            System.out.println("reflect invoke.... say : ");
            Method method2 = c2.getDeclaredMethod("say", null);
            method2.invoke(o2, null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
