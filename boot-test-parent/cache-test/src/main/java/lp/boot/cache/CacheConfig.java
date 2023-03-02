package lp.boot.cache;

import java.util.Date;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author : lvpeng01
 * @since : 2020/6/13
 **/
@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {

    public static final String myCache = "lp-cache";
    static final  String testCache = "test-cache";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(myCache, testCache);
    }


//    @CacheEvict(allEntries = true, value = {myCache, testCache})
//    @Scheduled(fixedDelay = 10 * 1000, initialDelay = 2000)
    public void cacheEvict() {
        System.out.println("flush cache " + new Date());
    }

}
