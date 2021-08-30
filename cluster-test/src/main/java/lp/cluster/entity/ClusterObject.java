package lp.cluster.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : lvpeng01
 * @since : 2020/7/16
 **/
@Entity
@Table(name = "ClusterObject_Archive00000020190801Aggregation")
public class ClusterObject {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = "cluster_id")
    private Long clusterId;

    @Column(name = "source_id")
    private Long sourceId;

    @Column(name = "snapshotTime")
    private String snapshotTime;

    @Column(name = "image_id")
    private String imageId;

    @Column(name = "cameraId")
    private String cameraId;

    @Column(name = "quality_score")
    private String qualityScore;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "type")
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getSnapshotTime() {
        return snapshotTime;
    }

    public void setSnapshotTime(String snapshotTime) {
        this.snapshotTime = snapshotTime;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public String getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(String qualityScore) {
        this.qualityScore = qualityScore;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
