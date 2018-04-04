package lp.proxy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.tools.javac.util.Pair;


/**
 * Created by lvpeng01 on 2018/4/2.
 */
public class CustomInterfaceImpl implements CustomInterface {

    private Logger logger = LoggerFactory.getLogger(CustomInterfaceImpl.class);

    public String busMethod(String argOne, String argTwo) {
        logger.info("in busMethod, method is {}, {}", argOne, argTwo);
        return argOne + argTwo;
    }

    public String otherMethod(Pair<String, String> PairArg) {
        logger.info("in otherMethod, method is {}", PairArg.toString());
        return PairArg.toString();
    }
}
