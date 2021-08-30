package lp.brpc.client;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.baidu.brpc.spring.annotation.RpcProxy;

import lp.brpc.api.HelloRequest;
import lp.brpc.api.HelloService;

/**
 * @author : lvpeng01
 * @since : 2020/4/14
 **/
@Component
public class StartService implements ApplicationRunner {


    @RpcProxy
    private HelloService helloService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setAge(10);
        helloRequest.setName("lp");
        System.out.println(helloService.say(helloRequest).getMessage());

    }
}
