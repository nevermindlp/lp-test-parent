package lp.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author : lvpeng01
 * @since : 2021/4/7
 **/
//@SpringBootApplication
public class BigMesTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigMesTestApplication.class, args);
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("so53605262", 1, (short) 1);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        System.out.println("send msg");
        return args -> template.send("so53605262", new String(new byte[1024 * 1024 * 2]));
    }

}
