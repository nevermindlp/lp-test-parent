package lp.patronum.brpc.api;

import com.baidu.brpc.protocol.BrpcMeta;

/**
 * @author : lvpeng01
 * @since : 2020/4/14
 **/
public interface HelloService {

    @BrpcMeta(serviceName = "lp.helloService", methodName = "say")
    HelloResponse say(HelloRequest helloRequest);

}
