package lp.brpc.client.archive;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import lombok.Data;

/**
 * @Author wangxueqing01
 * @Date 2021/7/21 5:36 下午
 **/
@Data
public class BaseApiResponse {

    @Protobuf(order = 1)
    private String code;
    @Protobuf(order = 2)
    private String message;
    @Protobuf(order = 3)
    private String requestId;
}
