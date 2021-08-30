package lp.brpc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//import com.baidu.cie.patronum.brpc.client.BrpcClientConfigs;
//import com.baidu.cie.patronum.brpc.server.BrpcServerConfigs;

/**
 * 基类brpc测试
 *
 * @author : lvpeng01
 * @since : 2020/4/14
 **/
@SpringBootApplication
//@Import({BrpcClientConfigs.class, BrpcServerConfigs.class})
public class SimpleBrpc {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SimpleBrpc.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
        synchronized (SimpleBrpc.class) {
            try {
                SimpleBrpc.class.wait();
            } catch (Throwable e) {
            }
        }
    }
}
