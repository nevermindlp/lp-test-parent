package lp.brpc.client.archive;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author wangxueqing01
 * @Date 2021/7/14 5:57 下午
 **/
@ProtobufClass
@Setter
@Getter
public class PictureInfoResponse extends BaseApiResponse {
    private PictureInfoResult data;
}
