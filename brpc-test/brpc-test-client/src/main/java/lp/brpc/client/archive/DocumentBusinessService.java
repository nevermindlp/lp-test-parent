package lp.brpc.client.archive;

import com.baidu.brpc.protocol.BrpcMeta;

/**
 * @author wangxueqing01
 * @date 4:29 下午 2021/7/8
 **/
public interface DocumentBusinessService {

    /**
     * 获取图片
     *
     * @param request
     * @return
     */
    @BrpcMeta(serviceName = "access_db_server.DocOperationService",
            methodName = "get_pictures")
    PictureInfoResponse getPictures(PictureInfoRequest request);

}
