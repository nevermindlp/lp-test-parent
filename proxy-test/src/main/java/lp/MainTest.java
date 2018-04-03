package lp;

import lp.proxy.jdk.CustomProxy;
import lp.service.CustomInterface;
import lp.service.CustomInterfaceImpl;

/**
 * Created by lvpeng01 on 2018/4/2.
 */
public class MainTest {

    public static void main(String[] args) {
        CustomInterface impl = new CustomInterfaceImpl();
        CustomProxy customProxy = new CustomProxy(impl);
        CustomInterface newImpl = customProxy.createProxy(CustomInterface.class);
        String value = newImpl.busMethod("hello", "world");
        System.out.println("return value: " + value);
    }

}
