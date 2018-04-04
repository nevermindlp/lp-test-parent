package lp.proxy.jdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lp.proxy.service.CustomInterface;

/**
 * Created by lvpeng01 on 2018/4/2.
 */
public class CustomProxy {

    private Logger logger = LoggerFactory.getLogger(CustomProxy.class);
    private CustomInterface impl;

    public CustomProxy(CustomInterface object) {
        impl = object;
    }

    public <T> T createProxy(Class<T> target) {
        return (T)Proxy.newProxyInstance(target.getClassLoader(),
                new Class[]{target}, this::invoke);
    }

    public Object invoke(Object proxy, Method method, Object[] args) {

        if (method.getName().equals("toString")) {
            return "invoke toString method";
        }
        if (method.getName().equals("hashCode")) {
            return "invoke hashCode method";
        }
        if (method.getName().equals("equals")) {
            return "invoke equals method";
        }

        if (method.getName().equals("busMethod")) {
            logger.info("do something with method and args. eg: http invoke");
            logger.info("args", args);
            logger.info("now invoke impl.");
            try {
                return method.invoke(impl, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                logger.error("catch error.", e);
            }
        }

        if (method.getName().equals("otherMethod")) {
            logger.info("otherMethod been invoked.");
        }
        return null;
    }

}
