package lp.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

/**
 * Created by lvpeng01 on 2018/10/11.
 */
public class IgniteCache {

    public static void main(String[] args) {
        Ignite ignite = Ignition.start();
        org.apache.ignite.IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");
//        for (int i = 0; i < 10; i++) {
//            cache.put(i, Integer.toString(i));
//        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Got [key = " + i + ", val = " + cache.get(i) + "]");
        }
    }

}
