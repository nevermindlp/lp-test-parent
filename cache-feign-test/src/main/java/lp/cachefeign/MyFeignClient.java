package lp.cachefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : lvpeng01
 * @since : 2023/6/29
 **/
@FeignClient(
        contextId = "actuator-health",
        name = "add-exporter",
        primary = false,
        url = "http://10.75.148.160:8237"
)
public interface MyFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/actuator/health")
    String getAddExporterHealth();

}
