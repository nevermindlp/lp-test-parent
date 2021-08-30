package lp.brpc.server;

import com.baidu.brpc.spring.annotation.RpcExporter;

import lp.brpc.api.HelloRequest;
import lp.brpc.api.HelloResponse;
import lp.brpc.api.HelloService;

/**
 * @author : lvpeng01
 * @since : 2020/4/14
 **/
@RpcExporter
public class HelloServiceImpl implements HelloService {
    @Override
    public HelloResponse say(HelloRequest helloRequest) {
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setMessage(helloRequest.getName() + helloRequest.getAge());
        return helloResponse;
    }
}
