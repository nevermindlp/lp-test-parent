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
@Table(name = "Archive00000020190801Aggregation")
public class Aggregation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = "feature")
    private byte[] feature;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFeature() {
        return feature;
    }

    public void setFeature(byte[] feature) {
        this.feature = feature;
    }
}
