package lp.com.lambda.sort;

/**
 * @author : lvpeng01
 * @since : 2020/11/2
 **/
public class TestVo {

    private String snapshotTime;

    private String cameraId;

    public TestVo() {
    }

    public TestVo(String cameraId, String snapshotTime) {
        this.snapshotTime = snapshotTime;
        this.cameraId = cameraId;
    }

    public String getSnapshotTime() {
        return snapshotTime;
    }

    public void setSnapshotTime(String snapshotTime) {
        this.snapshotTime = snapshotTime;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }
}
