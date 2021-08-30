package lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author : lvpeng01
 * @since : 2020/6/13
 **/
@SpringBootApplication
public class TestOrder {

    @Bean
    public String test() {
        System.out.println("aaaa");
        return "aaa";
    }

    public static void main(String[] args) {
        SpringApplication.run(TestOrder.class, args);
    }


}
