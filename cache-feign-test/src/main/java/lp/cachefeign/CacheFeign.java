package lp.cachefeign;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author : lvpeng01
 * @since : 2023/6/29
 **/
@Service
public class CacheFeign {

    // 工作流定义本地cache
    private LoadingCache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(20,
            TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
        @Override
        public String load(String key)  {
            System.out.println("cache expired , load : " + key);
            return feignClient.getAddExporterHealth();
        }
    });

    @Autowired
    private MyFeignClient feignClient;

    public String getHealthByKey(String key) {
        try {
//            System.out.println("sleep 100ms.");
//            Thread.sleep(100);
            return cache.get(key);
        } catch (ExecutionException e) {
            return null;
        }
    }

}
