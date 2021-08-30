package lp.brpc.api;

import com.baidu.cie.patronum.brpc.common.BrpcResponse;

import lombok.Data;

/**
 * @author : lvpeng01
 * @since : 2020/4/14
 **/
@Data
public class HelloResponse extends BrpcResponse {
    private String message;
}
