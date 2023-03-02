package lp.brpc.api;


import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

import lombok.Data;

/**
 * @author : lvpeng01
 * @since : 2020/4/14
 **/
@ProtobufClass
@Data
public class HelloRequest {

    private String name;
    private Integer age;

}
