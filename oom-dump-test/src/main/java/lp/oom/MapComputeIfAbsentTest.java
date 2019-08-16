package lp.oom;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.Maps;

public class MapComputeIfAbsentTest {

    private Map<String, UserEntity> cache = Maps.newConcurrentMap();

    public static void main(String[] args) {

        MapComputeIfAbsentTest m = new MapComputeIfAbsentTest();
        Random r = new Random();
        while (true) {
            int rInt = r.nextInt(10);
            System.out.println(m.getUser(String.valueOf(rInt)));
            System.out.println("key size is " + m.getCacheSize());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public UserEntity getUser(String key) {
        return cache.computeIfAbsent(key + "suffix", k -> create(key));
    }

    private UserEntity create(String key) {
        return new UserEntity("lptest" + key, 0);
    }

    private Integer getCacheSize() {
        return cache.size();
    }

}
