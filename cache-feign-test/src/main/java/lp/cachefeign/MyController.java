package lp.cachefeign;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : lvpeng01
 * @since : 2023/6/29
 **/
@Controller
public class MyController {

    @Autowired
    private CacheFeign cacheFeign;

    @Autowired
    private MyFeignClient myFeignClient;

    Executor executor = Executors.newFixedThreadPool(10);;

    @RequestMapping(value = "/cf/health", method = RequestMethod.GET)
    @ResponseBody
    public String getHealth(String key) {
        return cacheFeign.getHealthByKey(key);
    }

    @RequestMapping(value = "/cf/single", method = RequestMethod.GET)
    @ResponseBody
    public String singleTest() {
        return myFeignClient.getAddExporterHealth();
    }

    @RequestMapping(value = "/cf/100loop", method = RequestMethod.GET)
    @ResponseBody
    public String loop100() {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> cacheFeign.getHealthByKey(String.valueOf(finalI))).start();
        }
        return "loop100 success";
    }

    @RequestMapping(value = "/cf/1000loop", method = RequestMethod.GET)
    @ResponseBody
    public String loop1000() {
        for (AtomicInteger i = new AtomicInteger(0); i.get() < 1000;) {
            executor.execute(() -> cacheFeign.getHealthByKey(String.valueOf(i.getAndIncrement())));
        }
        return "loop 1000 success";
    }

}
