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
@Table(name = "Archive00000020190801Collection")
public class Collection {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = "object_id")
    private String objectId;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "feature")
    private byte[] feature;

    @Column(name = "image_id")
    private String imageId;

    @Column(name = "imageResolution")
    private String imageResolution;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public byte[] getFeature() {
        return feature;
    }

    public void setFeature(byte[] feature) {
        this.feature = feature;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageResolution() {
        return imageResolution;
    }

    public void setImageResolution(String imageResolution) {
        this.imageResolution = imageResolution;
    }
}
