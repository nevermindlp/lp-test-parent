package lp.brpc.api;

import com.baidu.cie.patronum.brpc.common.BrpcRequest;

import lombok.Data;

/**
 * @author : lvpeng01
 * @since : 2020/4/14
 **/
@Data
public class HelloRequest extends BrpcRequest {

    private String name;
    private Integer age;

}
