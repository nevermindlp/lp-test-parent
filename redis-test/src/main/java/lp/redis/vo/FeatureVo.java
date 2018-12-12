package lp.redis.vo;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lp.util.FeatureGenerator;

/**
 * Created by lvpeng01 on 2018/11/21.
 */
public class FeatureVo {

    private String imageId;
    private byte[] feature;
    private Date snapshotTime;
    private String cameraId;
    private Date insertTime;
    private String trackId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public byte[] getFeature() {
        return feature;
    }

    public void setFeature(byte[] feature) {
        this.feature = feature;
    }

    public Date getSnapshotTime() {
        return snapshotTime;
    }

    public void setSnapshotTime(Date snapshotTime) {
        this.snapshotTime = snapshotTime;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("imageId", imageId)
                .append("feature", feature)
                .append("snapshotTime", snapshotTime)
                .append("cameraId", cameraId)
                .append("insertTime", insertTime)
                .toString();
    }

    public static FeatureVo getRandomVo() {
        FeatureVo featureVo = new FeatureVo();
        featureVo.setCameraId(getRandomCameraId());
        featureVo.setFeature(FeatureGenerator.norRandomFeature());
        featureVo.setImageId(getRandomImageId());
        featureVo.setInsertTime(new Date());
        featureVo.setTrackId(getRandomTrackId());
        featureVo.setSnapshotTime(Date.from(LocalDateTime.now().minusMinutes(1).toInstant(ZoneOffset.UTC)));
        return featureVo;
    }

    public static String getRandomImageId() {
        //        System.out.println("random image id is : " + randomImageId);
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String getRandomTrackId() {
        return getRandomNumRange(6, 9);
    }

    public static String getRandomFeature() {
        return getRandomNumRange(0, 10);
    }

    public static String getRandomCameraId() {
        return getRandomNumRange(0, 5);
    }

    public static String getRandomNumRange(int start, int end) {
        ArrayList<Object> collect = IntStream.range(start, end).collect(ArrayList::new, List::add, List::add);
//        System.out.println(collect);
        int i = new Random().nextInt(collect.size());
        return String.valueOf(collect.get(i));
    }

    public static void main(String[] args) {
        System.out.println(getRandomFeature());
        System.out.println(getRandomImageId());
    }

}
