package lp.patronum.brpc.api;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Data;

/**
 * @author : lvpeng01
 * @since : 2020/4/14
 **/
@Data
@ProtobufClass
public class HelloResponse {
    private String message;
}
