package lp.boot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author : lvpeng01
 * @since : 2020/6/13
 **/
@SpringBootApplication
@EnableCaching
public class CacheDemoApplication {

    @Bean
    public String test() {
        System.out.println("bbbbb");
        return "bbbb";
    }

    public static void main(String[] args) {
        SpringApplication.run(CacheDemoApplication.class, args);
    }

}
