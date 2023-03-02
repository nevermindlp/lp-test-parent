package lp.brpc.client.archive;

import java.util.List;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

import lombok.Data;

/**
 * @Author wangxueqing01
 * @Date 2021/7/14 5:57 下午
 **/
@ProtobufClass
@Data
public class PictureInfoRequest {
    List<Long> picIds;
}
