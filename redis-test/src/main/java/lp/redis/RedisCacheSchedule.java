package lp.redis;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lp.redis.vo.FeatureVo;

/**
 * Created by lvpeng01 on 2018/11/22.
 */
@Component
public class RedisCacheSchedule {

    @Autowired
    private RedisTemplate redisTemplate;

    private Long expireInterval = 2000L;

    @Scheduled(fixedRate = 1000)
    public void doCacheScan() {
        // !!!按track维度失效!!!
        System.out.println("cache scan begin...");
        Set cameraSet = getAllCameraKeys();
        cameraSet.forEach(key -> {
            // key eg: CAMERA_CACHE_1_9
            Set newestItem = redisTemplate.opsForZSet().range(key, -1, -1);
            newestItem.forEach(item -> {
                // only one
                FeatureVo f = (FeatureVo) item;
                if (f.getInsertTime().getTime() < (new Date().getTime() - expireInterval)) {
                    // trigger track expire
                    Set trackItems = redisTemplate.opsForZSet().rangeByScore(key, 0, f.getInsertTime().getTime());
//                    redisTemplate.opsForZSet().range
                    // double check
                    // ...
                    // remove
                    redisTemplate.opsForZSet().removeRangeByScore(key, 0, f.getInsertTime().getTime());
                    // submit
                    trackItems.forEach(trackItem -> System.out.println("cache expire image id is : "
                            + ((FeatureVo)trackItem).getImageId() + " track id is : "
                            + ((FeatureVo)trackItem).getTrackId()));
                }
            });
        });

    }

    private Set getAllCameraKeys() {
        return redisTemplate.keys(Constant.CACHE_CAMERA_PREFIX + "*");
    }

    private Set getAllTrackKeys(String cameraId, String trackId) {
        return redisTemplate.keys(Constant.CACHE_CAMERA_PREFIX + cameraId + "_" + trackId);
    }

}
