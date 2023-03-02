package lp.brpc.client.archive;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

import lombok.Data;

/**
 * @Author wangxueqing01
 * @Date 2021/7/14 6:29 下午
 **/
@ProtobufClass
@Data
public class PictureVO {
    private Long picId;
    private List<Float> feature;
    private Integer cameraId;
    private Float longitude;
    private Float latitude;
    private String cameraName;
    private Long snapshotTime;
    private String carPlate;
    private Float faceScore;
    private Float blur;
    private Integer ageType;
    private List<Float> occlu;
    private Integer mainDriver;
    private Integer faceMask;
    private Integer cameraTag;
    private Float faceMaskProb;
    private Map<String, String> faceAttr;
    /**
     * 以下非brpc接口定义字段
     */
    private String imageId;
    private String backgroundImageId;
    private String gbId;
    private Long createTime;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, "feature");
    }
}
