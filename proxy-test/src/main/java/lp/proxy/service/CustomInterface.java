package lp.proxy.service;


import javafx.util.Pair;

/**
 * Created by lvpeng01 on 2018/4/2.
 */
public interface CustomInterface {

    String busMethod(String argOne, String argTwo);

    String otherMethod(Pair<String, String> PairArg);
}
