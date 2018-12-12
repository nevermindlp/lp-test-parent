package lp.redis;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.AtomicDouble;

import lp.redis.vo.FeatureVo;
import lp.util.MatchUtils;

/**
 * Created by lvpeng01 on 2018/11/20.
 */
@SpringBootApplication
@EnableScheduling
@Import(RedisConfig.class)
@ComponentScan(basePackageClasses = RedisCacheSchedule.class)
public class RedisTestApplication implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    private double reidScore = 0.75d;

    private long forceCommitInterval = 4000L;

    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "1112");
        redisTemplate.opsForValue().set("test", FeatureVo.getRandomVo());

        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        System.out.println(redisTemplate.opsForValue().get("test"));

        redisTemplate.delete("aaa");
        redisTemplate.delete("test");
    }

    public void featureListAdd() {
        FeatureVo randomVo = FeatureVo.getRandomVo();
        redisTemplate.opsForList().leftPush(randomVo.getCameraId(), randomVo);
    }

    public void showListInfo() {
        Set<String> keys = redisTemplate.keys("*");
        keys.forEach(k -> {
            Object o = redisTemplate.opsForList().range(k, 0, -1);
            System.out.println(o);
        });

        System.out.println(keys);
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisTestApplication.class, args).close();
    }

    @Override
    public void run(String... strings) throws Exception {

        System.out.println(new Date().getTime());
        System.out.println(new Long(new Date().getTime()).doubleValue());

        CountDownLatch latch = new CountDownLatch(1);

//        test();
        // list test not support
//        IntStream.range(0, 10).forEach(i -> {
//            featureListAdd();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        showListInfo();
//
        IntStream.range(0, 1000).forEach(i -> {
            featureZSetAdd();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        zSetTest();
        latch.await();
    }

    private void zSetTest() {
        IntStream.range(0, 10).forEach(i -> {
            featureSetAdd();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void featureSetAdd() {
        FeatureVo randomVo = FeatureVo.getRandomVo();
        redisTemplate.opsForZSet().add(getZsetKey(randomVo), randomVo, randomVo.getInsertTime().getTime());
    }

    private void featureZSetAdd() {
        FeatureVo randomVo = FeatureVo.getRandomVo();
        doReid(randomVo);
    }

    private void doReid(FeatureVo randomVo) {
        final AtomicDouble maxMatchScore = new AtomicDouble(0);
        final AtomicReference<String> reTrackId = new AtomicReference<>(randomVo.getTrackId());
        String cameraKey = Constant.CACHE_CAMERA_PREFIX + randomVo.getCameraId() + "*";
        Set keys = redisTemplate.keys(cameraKey);
        keys.forEach(k -> {
            Set trackSet = redisTemplate.opsForZSet().range(k, -1, 0);
            trackSet.forEach(f -> {
                // do reid
                FeatureVo trackFeature = (FeatureVo) f;
                double matchScore = MatchUtils.norCosine(trackFeature.getFeature(), randomVo.getFeature());
                if (matchScore > reidScore) {
                    if (maxMatchScore.get() < matchScore) {
                        maxMatchScore.set(matchScore);
                        reTrackId.set(trackFeature.getTrackId());
                        System.out.println("max score is : " + maxMatchScore.get()
                                + " track id is : " + reTrackId.get());
                    }
                }
            });
        });
        randomVo.setTrackId(reTrackId.get());

        // check forceCommit
        Set oldestItem = redisTemplate.opsForZSet().range(getZsetKey(randomVo), 0, 0);
        oldestItem.forEach(item -> {
            FeatureVo f = (FeatureVo) item;
            System.out.println("track id is : " + f.getTrackId() + "first item is : " + f.getImageId());
            if (f.getInsertTime().getTime() < (new Date().getTime() - forceCommitInterval)) {
                // do force commit
                Set trackSet = redisTemplate.opsForZSet().range(getZsetKey(randomVo), 0, -1);
                // delete
                redisTemplate.opsForZSet().removeRange(getZsetKey(randomVo), 0, -1);
                // commit
                trackSet.forEach(i -> System.out.println("force commit : " + ((FeatureVo)i).getImageId()));
            }
        });
        redisTemplate.opsForZSet().add(getZsetKey(randomVo), randomVo, randomVo.getInsertTime().getTime());
    }

    private String getZsetKey(FeatureVo randomVo) {
        return Constant.CACHE_CAMERA_PREFIX + randomVo.getCameraId() + "_" + randomVo.getTrackId();
    }

    private String getCameraKey(FeatureVo randomVo) {
        return Constant.CACHE_CAMERA_PREFIX + randomVo.getCameraId() + "*";
    }
}
