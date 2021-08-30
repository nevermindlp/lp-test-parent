package lp.brpc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baidu.brpc.spring.annotation.RpcProxy;

import lp.brpc.api.HelloService;

/**
 * @author : lvpeng01
 * @since : 2020/4/14
 **/
@SpringBootApplication
public class BrpcClientTest {

    public static void main(String[] args) {
        SpringApplication.run(BrpcClientTest.class);
    }

}
