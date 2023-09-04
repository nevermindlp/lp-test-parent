package lp.cachefeign;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import lp.cachefeign.config.SwaggerConfig;

/**
 * @author : lvpeng01
 * @since : 2023/6/29
 **/
@SpringBootApplication
@EnableFeignClients
@Import(SwaggerConfig.class)
public class CacheFeignApplication {

    @Bean
    public CloseableHttpClient feignClient() {
        return HttpClientUtils.newHttpClient();
    }

    public static void main(String[] args) {

        SpringApplication.run(CacheFeignApplication.class, args);

    }

}
