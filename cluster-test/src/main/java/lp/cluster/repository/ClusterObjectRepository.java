package lp.cluster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lp.cluster.entity.ClusterObject;

/**
 * @author : lvpeng01
 * @since : 2020/7/16
 **/
@Repository
public interface ClusterObjectRepository extends JpaRepository<ClusterObject, Long> {

    List<ClusterObject> findByClusterId(Long clusterId);

}
